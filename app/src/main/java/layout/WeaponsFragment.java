package layout;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.softwareengineering.ttu.shadowruncharactermanager.*;
import com.softwareengineering.ttu.shadowruncharactermanager.Character;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WeaponsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WeaponsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeaponsFragment extends Fragment {
    Character character = Character.getInstance();
    WeaponsInventory inventory = WeaponsInventory.getInstance();
    LinearLayout weaponList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WeaponsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeaponsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WeaponsFragment newInstance(String param1, String param2) {
        WeaponsFragment fragment = new WeaponsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View layout = inflater.inflate(R.layout.fragment_weapons, container, false);
        weaponList = (LinearLayout) layout.findViewById(R.id.weapon_list);
        final TextView nuyenVal = (TextView) layout.findViewById(R.id.nuyen_value);
        inventory.setInflater(inflater);
        ImageButton addWeaponButton = (ImageButton) layout.findViewById(R.id.btn_add_weapon);

        nuyenVal.setText(Integer.toString(character.getNuyen()));

        if (character.hasWeapons()) {
            for (int i = 0; i < character.getWeaponList().size(); i++) {
                final View weaponListing = inventory.getWeaponView(weaponList, i);
                ImageButton weaponMenu = (ImageButton) weaponListing.findViewById(R.id.weapon_menu);
                final int id = character.getWeaponList().keyAt(i);
                final TextView txtCost = (TextView) weaponListing.findViewById(R.id.weapon_cost);
                final int cost = Integer.parseInt(txtCost.getText().toString());

                weaponList.addView(weaponListing);

                weaponMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popup = new PopupMenu(getContext(), v);
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.menu_weapon, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.remove_weapon:
                                        weaponList.removeView(weaponListing);
                                        character.removeWeapon(id);
                                        break;

                                    case R.id.sell_weapon:
                                        weaponList.removeView(weaponListing);
                                        character.removeWeapon(id);
                                        character.addNuyen(cost);
                                        nuyenVal.setText(Integer.toString(character.getNuyen()));
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                });
            }
        }

        addWeaponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View weaponPopup = inflater.inflate(R.layout.popup_layout, null, false);
                final Button btnCancel = (Button) weaponPopup.findViewById(R.id.btn_cancel_popup);
                final TextView txtNuyenVal = (TextView) weaponPopup.findViewById(R.id.nuyen_value);
                final PopupWindow popupWindow = new PopupWindow(
                        weaponPopup,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x80000000));

                txtNuyenVal.setText(Integer.toString(character.getNuyen()));

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                for (int i=0; i<inventory.getWeaponCount(); i++) {
                    final LinearLayout weaponSection = (LinearLayout) weaponPopup.findViewById(R.id.weapon_section);
                    final View popupListing = inventory.getWeaponPopupMiniView(weaponSection, i);
                    final View weaponListing2 = inventory.getWeaponPopupFullView(weaponList, i);
                    final Weapon weapon = inventory.getWeapon(i);
                    ImageButton weaponMenu = (ImageButton) weaponListing2.findViewById(R.id.weapon_menu);
                    final TextView txtCost = (TextView) popupListing.findViewById(R.id.weapon_cost);
                    final int cost = Integer.parseInt(txtCost.getText().toString());

                    final TextView weaponID = (TextView) weaponListing2.findViewById(R.id.weapon_id);

                    popupListing.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(cost > character.getNuyen()){
                                Toast nuyenWarning = Toast.makeText(getContext(), "Insufficient Nuyen", Toast.LENGTH_SHORT);
                                nuyenWarning.show();
                            }
                            else {
                                weaponList.addView(weaponListing2);
                                weaponID.setText(Integer.toString(character.addWeapon(weapon)));
                                character.subNuyen(cost);
                                nuyenVal.setText(Integer.toString(character.getNuyen()));
                                popupWindow.dismiss();
                            }
                        }
                    });

                    weaponSection.addView(popupListing);
                    weaponMenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            PopupMenu popup = new PopupMenu(getContext(), v);
                            MenuInflater inflater = popup.getMenuInflater();
                            inflater.inflate(R.menu.menu_weapon, popup.getMenu());
                            popup.show();

                            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {
                                    switch (item.getItemId()) {
                                        case R.id.remove_weapon:
                                            weaponList.removeView(weaponListing2);
                                            character.removeWeapon(Integer.parseInt(weaponID.getText().toString()));
                                            break;

                                        case R.id.sell_weapon:
                                            weaponList.removeView(weaponListing2);
                                            character.removeWeapon(Integer.parseInt(weaponID.getText().toString()));
                                            character.addNuyen(cost);
                                            nuyenVal.setText(Integer.toString(character.getNuyen()));
                                            break;
                                    }
                                    return true;
                                }
                            });
                        }
                    });
                }

                popupWindow.showAtLocation(layout.findViewById(R.id.weapon_list), Gravity.CENTER, 0, 0);
            }
        });

        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
