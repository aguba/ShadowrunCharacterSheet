package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.softwareengineering.ttu.shadowruncharactermanager.*;
import com.softwareengineering.ttu.shadowruncharactermanager.Character;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EquipmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EquipmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquipmentFragment extends Fragment {
    Character character = Character.getInstance();
    LinearLayout gearList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EquipmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EquipmentFragment newInstance(String param1, String param2) {
        EquipmentFragment fragment = new EquipmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EquipmentFragment() {
        // Required empty public constructor
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
        final View layout = inflater.inflate(R.layout.fragment_equipment, container, false);
        gearList = (LinearLayout) layout.findViewById(R.id.gear_list);
        ImageButton addGearButton = (ImageButton) layout.findViewById(R.id.btn_add_gear);

        if (character.hasGear()){
            for (int i = 0; i < character.getGearList().size(); i++){
                final View gearListing = inflater.inflate(R.layout.gear_list_layout, gearList, false);
                ImageButton gearMenu = (ImageButton) gearListing.findViewById(R.id.gear_menu);
                //final int id = character.getGearList().keyAt(i);
                final int id = character.gearKeyAt(i);
                TextView gearName = (TextView) gearListing.findViewById(R.id.gear_name);
                TextView gearCost = (TextView) gearListing.findViewById(R.id.gear_cost);
                TextView gearID = (TextView) gearListing.findViewById(R.id.gear_id);
                Equipment gear = character.getGear(i);

                gearName.setText(gear.getName());
                gearCost.setText(Integer.toString(gear.getCost()));
                gearID.setText(Integer.toString(id));
                gearList.addView(gearListing);

                gearMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popup = new PopupMenu(getContext(), v);
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.menu_gear, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.remove_gear:
                                        gearList.removeView(gearListing);
                                        character.removeGear(id);
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                });
            }
        }

        addGearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View gearListing = inflater.inflate(R.layout.gear_list_layout, gearList, false);
                ImageButton gearMenu = (ImageButton) gearListing.findViewById(R.id.gear_menu);
                Equipment gear = new Equipment();
                final int id;

                TextView gearName = (TextView) gearListing.findViewById(R.id.gear_name);
                TextView gearCost = (TextView) gearListing.findViewById(R.id.gear_cost);
                TextView gearID = (TextView) gearListing.findViewById(R.id.gear_id);

                id = character.addGear(gear);

                gearName.setText(gear.getName());
                gearCost.setText(Integer.toString(gear.getCost()));
                gearID.setText(Integer.toString(id));

                gearList.addView(gearListing);

                gearMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popup = new PopupMenu(getContext(), v);
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.menu_gear, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.remove_gear:
                                        gearList.removeView(gearListing);
                                        character.removeGear(id);
                                        break;
                                }
                                return true;
                            }
                        });
                    }
                });
            }
        });

        return layout;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
