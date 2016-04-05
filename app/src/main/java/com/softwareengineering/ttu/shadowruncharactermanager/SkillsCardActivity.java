package com.softwareengineering.ttu.shadowruncharactermanager;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class SkillsCardActivity extends AppCompatActivity {
    Character character = Character.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_card);
        TextView akPool = (TextView) findViewById(R.id.AKDPool);
        akPool.setText(Integer.toString(character.getSkill("Academic Knowledge").getDicepool()));
        TextView akRTG = (TextView) findViewById(R.id.AKRTG);
        akRTG.setText(Integer.toString(character.getSkill("Academic Knowledge").getRating()));
        TextView arcaPool = (TextView) findViewById(R.id.ArcaDPool);
        arcaPool.setText(Integer.toString(character.getSkill("Arcana").getDicepool()));
        TextView arcaRTG = (TextView) findViewById(R.id.ArcaRTG);
        arcaRTG.setText(Integer.toString(character.getSkill("Arcana").getRating()));
        TextView arcPool = (TextView) findViewById(R.id.ArcDPool);
        arcPool.setText(Integer.toString(character.getSkill("Archery").getDicepool()));
        TextView arcRTG = (TextView) findViewById(R.id.ArcRTG);
        arcRTG.setText(Integer.toString(character.getSkill("Archery").getRating()));
        TextView armPool = (TextView) findViewById(R.id.ArmDPool);
        armPool.setText(Integer.toString(character.getSkill("Armorer").getDicepool()));
        TextView armRTG = (TextView) findViewById(R.id.ArmRTG);
        armRTG.setText(Integer.toString(character.getSkill("Armorer").getRating()));
        TextView artPool = (TextView) findViewById(R.id.ArtDPool);
        artPool.setText(Integer.toString(character.getSkill("Artisan").getDicepool()));
        TextView artRTG = (TextView) findViewById(R.id.ArtRTG);
        artRTG.setText(Integer.toString(character.getSkill("Artisan").getRating()));
        TextView autoPool = (TextView) findViewById(R.id.AutoDPool);
        autoPool.setText(Integer.toString(character.getSkill("Automatics").getDicepool()));
        TextView autoRTG = (TextView) findViewById(R.id.AutoRTG);
        autoRTG.setText(Integer.toString(character.getSkill("Automatics").getRating()));
        TextView bladePool = (TextView) findViewById(R.id.BladeDPool);
        bladePool.setText(Integer.toString(character.getSkill("Blades").getDicepool()));
        TextView bladeRTG = (TextView) findViewById(R.id.BladeRTG);
        bladeRTG.setText(Integer.toString(character.getSkill("Blades").getRating()));
        TextView chemPool = (TextView) findViewById(R.id.ChemDPool);
        chemPool.setText(Integer.toString(character.getSkill("Chemistry").getDicepool()));
        TextView chemRTG = (TextView) findViewById(R.id.ChemRTG);
        chemRTG.setText(Integer.toString(character.getSkill("Chemistry").getRating()));
        TextView climbPool = (TextView) findViewById(R.id.ClimbDPool);
        climbPool.setText(Integer.toString(character.getSkill("Climbing").getDicepool()));
        TextView climbRTG = (TextView) findViewById(R.id.ClimbRTG);
        climbRTG.setText(Integer.toString(character.getSkill("Climbing").getRating()));
        TextView clubPool = (TextView) findViewById(R.id.ClubDPool);
        clubPool.setText(Integer.toString(character.getSkill("Clubs").getDicepool()));
        TextView clubRTG = (TextView) findViewById(R.id.ClubRTG);
        clubRTG.setText(Integer.toString(character.getSkill("Clubs").getRating()));
        TextView comPool = (TextView) findViewById(R.id.ComDPool);
        comPool.setText(Integer.toString(character.getSkill("Computer").getDicepool()));
        TextView comRTG = (TextView) findViewById(R.id.ComRTG);
        comRTG.setText(Integer.toString(character.getSkill("Computer").getRating()));
        TextView conPool = (TextView) findViewById(R.id.ConDPool);
        conPool.setText(Integer.toString(character.getSkill("Con").getDicepool()));
        TextView conRTG = (TextView) findViewById(R.id.ConRTG);
        conRTG.setText(Integer.toString(character.getSkill("Con").getRating()));
        TextView dsPool = (TextView) findViewById(R.id.DSDPool);
        dsPool.setText(Integer.toString(character.getSkill("Data Search").getDicepool()));
        TextView dsRTG = (TextView) findViewById(R.id.DSRTG);
        dsRTG.setText(Integer.toString(character.getSkill("Data Search").getRating()));
        TextView demPool = (TextView) findViewById(R.id.DemDPool);
        demPool.setText(Integer.toString(character.getSkill("Demolitions").getDicepool()));
        TextView demRTG = (TextView) findViewById(R.id.DemRTG);
        demRTG.setText(Integer.toString(character.getSkill("Demolitions").getRating()));
        TextView disPool = (TextView) findViewById(R.id.DisDPool);
        disPool.setText(Integer.toString(character.getSkill("Disguise").getDicepool()));
        TextView disRTG = (TextView) findViewById(R.id.DisRTG);
        disRTG.setText(Integer.toString(character.getSkill("Disguise").getRating()));
        TextView divPool = (TextView) findViewById(R.id.DivDPool);
        divPool.setText(Integer.toString(character.getSkill("Diving").getDicepool()));
        TextView divRTG = (TextView) findViewById(R.id.DivRTG);
        divRTG.setText(Integer.toString(character.getSkill("Diving").getRating()));
        TextView dodPool = (TextView) findViewById(R.id.DodDPool);
        dodPool.setText(Integer.toString(character.getSkill("Dodge").getDicepool()));
        TextView dodRTG = (TextView) findViewById(R.id.DodRTG);
        dodRTG.setText(Integer.toString(character.getSkill("Dodge").getRating()));
        TextView encPool = (TextView) findViewById(R.id.EncDPool);
        encPool.setText(Integer.toString(character.getSkill("Enchanting").getDicepool()));
        TextView encRTG = (TextView) findViewById(R.id.EncRTG);
        encRTG.setText(Integer.toString(character.getSkill("Enchanting").getRating()));
        TextView eaPool = (TextView) findViewById(R.id.EADPool);
        eaPool.setText(Integer.toString(character.getSkill("Escape Artist").getDicepool()));
        TextView eaRTG = (TextView) findViewById(R.id.EARTG);
        eaRTG.setText(Integer.toString(character.getSkill("Escape Artist").getRating()));
        TextView etiPool = (TextView) findViewById(R.id.EtiDPool);
        etiPool.setText(Integer.toString(character.getSkill("Etiquette").getDicepool()));
        TextView etiRTG = (TextView) findViewById(R.id.EtiRTG);
        etiRTG.setText(Integer.toString(character.getSkill("Etiquette").getRating()));
        TextView faPool = (TextView) findViewById(R.id.FADPool);
        faPool.setText(Integer.toString(character.getSkill("First Aid").getDicepool()));
        TextView faRTG = (TextView) findViewById(R.id.FARTG);
        faRTG.setText(Integer.toString(character.getSkill("First Aid").getRating()));
        TextView forgPool = (TextView) findViewById(R.id.ForgDPool);
        forgPool.setText(Integer.toString(character.getSkill("Forgery").getDicepool()));
        TextView forgRTG = (TextView) findViewById(R.id.ForgRTG);
        forgRTG.setText(Integer.toString(character.getSkill("Forgery").getRating()));
        TextView gunPool = (TextView) findViewById(R.id.GunDPool);
        gunPool.setText(Integer.toString(character.getSkill("Gunnery").getDicepool()));
        TextView gunRTG = (TextView) findViewById(R.id.GunRTG);
        gunRTG.setText(Integer.toString(character.getSkill("Gunnery").getRating()));
        TextView gymPool = (TextView) findViewById(R.id.GymDPool);
        gymPool.setText(Integer.toString(character.getSkill("Gymnastics").getDicepool()));
        TextView gymRTG = (TextView) findViewById(R.id.GymRTG);
        gymRTG.setText(Integer.toString(character.getSkill("Gymnastics").getRating()));
        TextView hackPool = (TextView) findViewById(R.id.HackDPool);
        hackPool.setText(Integer.toString(character.getSkill("Hacking").getDicepool()));
        TextView hackRTG = (TextView) findViewById(R.id.HackRTG);
        hackRTG.setText(Integer.toString(character.getSkill("Hacking").getRating()));
        TextView hwPool = (TextView) findViewById(R.id.HWDPool);
        hwPool.setText(Integer.toString(character.getSkill("Heavy Weapons").getDicepool()));
        TextView hwRTG = (TextView) findViewById(R.id.HWRTG);
        hwRTG.setText(Integer.toString(character.getSkill("Heavy Weapons").getRating()));
        TextView infilPool = (TextView) findViewById(R.id.InfilDPool);
        infilPool.setText(Integer.toString(character.getSkill("Infiltration").getDicepool()));
        TextView infilRTG = (TextView) findViewById(R.id.InfilRTG);
        infilRTG.setText(Integer.toString(character.getSkill("Infiltration").getRating()));
        TextView instPool = (TextView) findViewById(R.id.InstDPool);
        instPool.setText(Integer.toString(character.getSkill("Instruction").getDicepool()));
        TextView instRTG = (TextView) findViewById(R.id.InstRTG);
        instRTG.setText(Integer.toString(character.getSkill("Instruction").getRating()));
        TextView ikPool = (TextView) findViewById(R.id.IKDPool);
        ikPool.setText(Integer.toString(character.getSkill("Interests Knowledge").getDicepool()));
        TextView ikRTG = (TextView) findViewById(R.id.IKRTG);
        ikRTG.setText(Integer.toString(character.getSkill("Interests Knowledge").getRating()));
        TextView intPool = (TextView) findViewById(R.id.IntDPool);
        intPool.setText(Integer.toString(character.getSkill("Intimidation").getDicepool()));
        TextView intRTG = (TextView) findViewById(R.id.IntRTG);
        intRTG.setText(Integer.toString(character.getSkill("Intimidation").getRating()));
        TextView leadPool = (TextView) findViewById(R.id.LeadDPool);
        leadPool.setText(Integer.toString(character.getSkill("Leadership").getDicepool()));
        TextView leadRTG = (TextView) findViewById(R.id.LeadRTG);
        leadRTG.setText(Integer.toString(character.getSkill("Leadership").getRating()));
        TextView lockPool = (TextView) findViewById(R.id.LockDPool);
        lockPool.setText(Integer.toString(character.getSkill("Locksmith").getDicepool()));
        TextView lockRTG = (TextView) findViewById(R.id.LockRTG);
        lockRTG.setText(Integer.toString(character.getSkill("Locksmith").getRating()));
        TextView longPool = (TextView) findViewById(R.id.LongDPool);
        longPool.setText(Integer.toString(character.getSkill("Longarms").getDicepool()));
        TextView longRTG = (TextView) findViewById(R.id.LongRTG);
        longRTG.setText(Integer.toString(character.getSkill("Longarms").getRating()));
        TextView navPool = (TextView) findViewById(R.id.NavDPool);
        navPool.setText(Integer.toString(character.getSkill("Navigation").getDicepool()));
        TextView navRTG = (TextView) findViewById(R.id.NavRTG);
        navRTG.setText(Integer.toString(character.getSkill("Navigation").getRating()));
        TextView negPool = (TextView) findViewById(R.id.NegDPool);
        negPool.setText(Integer.toString(character.getSkill("Negotiation").getDicepool()));
        TextView negRTG = (TextView) findViewById(R.id.NegRTG);
        negRTG.setText(Integer.toString(character.getSkill("Negotiation").getRating()));
        TextView palmPool = (TextView) findViewById(R.id.PalmDPool);
        palmPool.setText(Integer.toString(character.getSkill("Palming").getDicepool()));
        TextView palmRTG = (TextView) findViewById(R.id.PalmRTG);
        palmRTG.setText(Integer.toString(character.getSkill("Palming").getRating()));
        TextView paraPool = (TextView) findViewById(R.id.ParaDPool);
        paraPool.setText(Integer.toString(character.getSkill("Parachuting").getDicepool()));
        TextView paraRTG = (TextView) findViewById(R.id.ParaRTG);
        paraRTG.setText(Integer.toString(character.getSkill("Parachuting").getRating()));
        TextView perPool = (TextView) findViewById(R.id.PerDPool);
        perPool.setText(Integer.toString(character.getSkill("Perception").getDicepool()));
        TextView perRTG = (TextView) findViewById(R.id.PerRTG);
        perRTG.setText(Integer.toString(character.getSkill("Perception").getRating()));
        TextView pgPool = (TextView) findViewById(R.id.PGDPool);
        pgPool.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getDicepool()));
        TextView pgRTG = (TextView) findViewById(R.id.PGRTG);
        pgRTG.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getRating()));
        TextView pwPool = (TextView) findViewById(R.id.PWDPool);
        pwPool.setText(Integer.toString(character.getSkill("Pilot Watercraft").getDicepool()));
        TextView pwRTG = (TextView) findViewById(R.id.PWRTG);
        pwRTG.setText(Integer.toString(character.getSkill("Pilot Watercraft").getRating()));
        TextView pistPool = (TextView) findViewById(R.id.PistDPool);
        pistPool.setText(Integer.toString(character.getSkill("Pistols").getDicepool()));
        TextView pistRTG = (TextView) findViewById(R.id.PistRTG);
        pistRTG.setText(Integer.toString(character.getSkill("Pistols").getRating()));
        TextView pkPool = (TextView) findViewById(R.id.PKDPool);
        pkPool.setText(Integer.toString(character.getSkill("Professional Knowledge").getDicepool()));
        TextView pkRTG = (TextView) findViewById(R.id.PKRTG);
        pkRTG.setText(Integer.toString(character.getSkill("Professional Knowledge").getRating()));
        TextView runPool = (TextView) findViewById(R.id.RunDPool);
        runPool.setText(Integer.toString(character.getSkill("Running").getDicepool()));
        TextView runRTG = (TextView) findViewById(R.id.RunRTG);
        runRTG.setText(Integer.toString(character.getSkill("Running").getRating()));
        TextView shadowPool = (TextView) findViewById(R.id.ShadowDPool);
        shadowPool.setText(Integer.toString(character.getSkill("Shadowing").getDicepool()));
        TextView shadowRTG = (TextView) findViewById(R.id.ShadowRTG);
        shadowRTG.setText(Integer.toString(character.getSkill("Shadowing").getRating()));
        TextView skPool = (TextView) findViewById(R.id.SKDPool);
        skPool.setText(Integer.toString(character.getSkill("Street Knowledge").getDicepool()));
        TextView skRTG = (TextView) findViewById(R.id.SKRTG);
        skRTG.setText(Integer.toString(character.getSkill("Street Knowledge").getRating()));
        TextView survPool = (TextView) findViewById(R.id.SurvDPool);
        survPool.setText(Integer.toString(character.getSkill("Survival").getDicepool()));
        TextView survRTG = (TextView) findViewById(R.id.SurvRTG);
        survRTG.setText(Integer.toString(character.getSkill("Survival").getRating()));
        TextView swimPool = (TextView) findViewById(R.id.SwimDPool);
        swimPool.setText(Integer.toString(character.getSkill("Swimming").getDicepool()));
        TextView swimRTG = (TextView) findViewById(R.id.SwimRTG);
        swimRTG.setText(Integer.toString(character.getSkill("Swimming").getRating()));
        TextView twPool = (TextView) findViewById(R.id.TWDPool);
        twPool.setText(Integer.toString(character.getSkill("Throwing Weapons").getDicepool()));
        TextView twRTG = (TextView) findViewById(R.id.TWRTG);
        twRTG.setText(Integer.toString(character.getSkill("Throwing Weapons").getRating()));
        TextView trackPool = (TextView) findViewById(R.id.TrackDPool);
        trackPool.setText(Integer.toString(character.getSkill("Tracking").getDicepool()));
        TextView trackRTG = (TextView) findViewById(R.id.TrackRTG);
        trackRTG.setText(Integer.toString(character.getSkill("Tracking").getRating()));
        TextView ucPool = (TextView) findViewById(R.id.UCDPool);
        ucPool.setText(Integer.toString(character.getSkill("Unarmed Combat").getDicepool()));
        TextView ucRTG = (TextView) findViewById(R.id.UCRTG);
        ucRTG.setText(Integer.toString(character.getSkill("Unarmed Combat").getRating()));
    }

    public void incAKRTG(View view){
        character.getSkill("Academic Knowledge").ratingUp();
        TextView akPool = (TextView) findViewById(R.id.AKDPool);
        akPool.setText(Integer.toString(character.getSkill("Academic Knowledge").getDicepool()));
        TextView akRTG = (TextView) findViewById(R.id.AKRTG);
        akRTG.setText(Integer.toString(character.getSkill("Academic Knowledge").getRating()));
    }

    public void decAKRTG(View view){
        character.getSkill("Academic Knowledge").ratingDown();
        TextView akPool = (TextView) findViewById(R.id.AKDPool);
        akPool.setText(Integer.toString(character.getSkill("Academic Knowledge").getDicepool()));
        TextView akRTG = (TextView) findViewById(R.id.AKRTG);
        akRTG.setText(Integer.toString(character.getSkill("Academic Knowledge").getRating()));
    }

    public void incArcaRTG(View view){
        character.getSkill("Arcana").ratingUp();
        TextView arcaPool = (TextView) findViewById(R.id.ArcaDPool);
        arcaPool.setText(Integer.toString(character.getSkill("Arcana").getDicepool()));
        TextView arcaRTG = (TextView) findViewById(R.id.ArcaRTG);
        arcaRTG.setText(Integer.toString(character.getSkill("Arcana").getRating()));
    }

    public void decArcaRTG(View view){
        character.getSkill("Arcana").ratingDown();
        TextView arcaPool = (TextView) findViewById(R.id.ArcaDPool);
        arcaPool.setText(Integer.toString(character.getSkill("Arcana").getDicepool()));
        TextView arcaRTG = (TextView) findViewById(R.id.ArcaRTG);
        arcaRTG.setText(Integer.toString(character.getSkill("Arcana").getRating()));
    }

    public void incArcRTG(View view){
        character.getSkill("Archery").ratingUp();
        TextView arcPool = (TextView) findViewById(R.id.ArcDPool);
        arcPool.setText(Integer.toString(character.getSkill("Archery").getDicepool()));
        TextView arcRTG = (TextView) findViewById(R.id.ArcRTG);
        arcRTG.setText(Integer.toString(character.getSkill("Archery").getRating()));
    }

    public void decArcRTG(View view){
        character.getSkill("Archery").ratingDown();
        TextView arcPool = (TextView) findViewById(R.id.ArcDPool);
        arcPool.setText(Integer.toString(character.getSkill("Archery").getDicepool()));
        TextView arcRTG = (TextView) findViewById(R.id.ArcRTG);
        arcRTG.setText(Integer.toString(character.getSkill("Archery").getRating()));
    }

    public void incArmRTG(View view){
        character.getSkill("Armorer").ratingUp();
        TextView armPool = (TextView) findViewById(R.id.ArmDPool);
        armPool.setText(Integer.toString(character.getSkill("Armorer").getDicepool()));
        TextView armRTG = (TextView) findViewById(R.id.ArmRTG);
        armRTG.setText(Integer.toString(character.getSkill("Armorer").getRating()));
    }

    public void decArmRTG(View view){
        character.getSkill("Armorer").ratingDown();
        TextView armPool = (TextView) findViewById(R.id.ArmDPool);
        armPool.setText(Integer.toString(character.getSkill("Armorer").getDicepool()));
        TextView armRTG = (TextView) findViewById(R.id.ArmRTG);
        armRTG.setText(Integer.toString(character.getSkill("Armorer").getRating()));
    }

    public void incArtRTG(View view){
        character.getSkill("Artisan").ratingUp();
        TextView artPool = (TextView) findViewById(R.id.ArtDPool);
        artPool.setText(Integer.toString(character.getSkill("Artisan").getDicepool()));
        TextView artRTG = (TextView) findViewById(R.id.ArtRTG);
        artRTG.setText(Integer.toString(character.getSkill("Artisan").getRating()));
    }

    public void decArtRTG(View view){
        character.getSkill("Artisan").ratingDown();
        TextView artPool = (TextView) findViewById(R.id.ArtDPool);
        artPool.setText(Integer.toString(character.getSkill("Artisan").getDicepool()));
        TextView artRTG = (TextView) findViewById(R.id.ArtRTG);
        artRTG.setText(Integer.toString(character.getSkill("Artisan").getRating()));
    }

    public void incAutoRTG(View view){
        character.getSkill("Automatics").ratingUp();
        TextView autoPool = (TextView) findViewById(R.id.AutoDPool);
        autoPool.setText(Integer.toString(character.getSkill("Automatics").getDicepool()));
        TextView autoRTG = (TextView) findViewById(R.id.AutoRTG);
        autoRTG.setText(Integer.toString(character.getSkill("Automatics").getRating()));
    }

    public void decAutoRTG(View view){
        character.getSkill("Automatics").ratingDown();
        TextView autoPool = (TextView) findViewById(R.id.AutoDPool);
        autoPool.setText(Integer.toString(character.getSkill("Automatics").getDicepool()));
        TextView autoRTG = (TextView) findViewById(R.id.AutoRTG);
        autoRTG.setText(Integer.toString(character.getSkill("Automatics").getRating()));
    }

    public void incBladeRTG(View view){
        character.getSkill("Blades").ratingUp();
        TextView bladePool = (TextView) findViewById(R.id.BladeDPool);
        bladePool.setText(Integer.toString(character.getSkill("Blades").getDicepool()));
        TextView bladeRTG = (TextView) findViewById(R.id.BladeRTG);
        bladeRTG.setText(Integer.toString(character.getSkill("Blades").getRating()));
    }

    public void decBladeRTG(View view){
        character.getSkill("Blades").ratingDown();
        TextView bladePool = (TextView) findViewById(R.id.BladeDPool);
        bladePool.setText(Integer.toString(character.getSkill("Blades").getDicepool()));
        TextView bladeRTG = (TextView) findViewById(R.id.BladeRTG);
        bladeRTG.setText(Integer.toString(character.getSkill("Blades").getRating()));
    }

    public void incChemRTG(View view){
        character.getSkill("Chemistry").ratingUp();
        TextView chemPool = (TextView) findViewById(R.id.ChemDPool);
        chemPool.setText(Integer.toString(character.getSkill("Chemistry").getDicepool()));
        TextView chemRTG = (TextView) findViewById(R.id.ChemRTG);
        chemRTG.setText(Integer.toString(character.getSkill("Chemistry").getRating()));
    }

    public void decChemRTG(View view){
        character.getSkill("Chemistry").ratingDown();
        TextView chemPool = (TextView) findViewById(R.id.ChemDPool);
        chemPool.setText(Integer.toString(character.getSkill("Chemistry").getDicepool()));
        TextView chemRTG = (TextView) findViewById(R.id.ChemRTG);
        chemRTG.setText(Integer.toString(character.getSkill("Chemistry").getRating()));
    }

    public void incClimbRTG(View view){
        character.getSkill("Climbing").ratingUp();
        TextView climbPool = (TextView) findViewById(R.id.ClimbDPool);
        climbPool.setText(Integer.toString(character.getSkill("Climbing").getDicepool()));
        TextView climbRTG = (TextView) findViewById(R.id.ClimbRTG);
        climbRTG.setText(Integer.toString(character.getSkill("Climbing").getRating()));
    }

    public void decClimbRTG(View view){
        character.getSkill("Climbing").ratingDown();
        TextView climbPool = (TextView) findViewById(R.id.ClimbDPool);
        climbPool.setText(Integer.toString(character.getSkill("Climbing").getDicepool()));
        TextView climbRTG = (TextView) findViewById(R.id.ClimbRTG);
        climbRTG.setText(Integer.toString(character.getSkill("Climbing").getRating()));
    }

    public void incClubRTG(View view){
        character.getSkill("Clubs").ratingUp();
        TextView clubPool = (TextView) findViewById(R.id.ClubDPool);
        clubPool.setText(Integer.toString(character.getSkill("Clubs").getDicepool()));
        TextView clubRTG = (TextView) findViewById(R.id.ClubRTG);
        clubRTG.setText(Integer.toString(character.getSkill("Clubs").getRating()));
    }

    public void decClubRTG(View view){
        character.getSkill("Clubs").ratingDown();
        TextView clubPool = (TextView) findViewById(R.id.ClubDPool);
        clubPool.setText(Integer.toString(character.getSkill("Clubs").getDicepool()));
        TextView clubRTG = (TextView) findViewById(R.id.ClubRTG);
        clubRTG.setText(Integer.toString(character.getSkill("Clubs").getRating()));
    }

    public void incComRTG(View view){
        character.getSkill("Computer").ratingUp();
        TextView comPool = (TextView) findViewById(R.id.ComDPool);
        comPool.setText(Integer.toString(character.getSkill("Computer").getDicepool()));
        TextView comRTG = (TextView) findViewById(R.id.ComRTG);
        comRTG.setText(Integer.toString(character.getSkill("Computer").getRating()));
    }

    public void decComRTG(View view){
        character.getSkill("Computer").ratingDown();
        TextView comPool = (TextView) findViewById(R.id.ComDPool);
        comPool.setText(Integer.toString(character.getSkill("Computer").getDicepool()));
        TextView comRTG = (TextView) findViewById(R.id.ComRTG);
        comRTG.setText(Integer.toString(character.getSkill("Computer").getRating()));
    }

    public void incConRTG(View view){
        character.getSkill("Con").ratingUp();
        TextView conPool = (TextView) findViewById(R.id.ConDPool);
        conPool.setText(Integer.toString(character.getSkill("Con").getDicepool()));
        TextView conRTG = (TextView) findViewById(R.id.ConRTG);
        conRTG.setText(Integer.toString(character.getSkill("Con").getRating()));
    }

    public void decConRTG(View view){
        character.getSkill("Con").ratingDown();
        TextView conPool = (TextView) findViewById(R.id.ConDPool);
        conPool.setText(Integer.toString(character.getSkill("Con").getDicepool()));
        TextView conRTG = (TextView) findViewById(R.id.ConRTG);
        conRTG.setText(Integer.toString(character.getSkill("Con").getRating()));
    }

    public void incDSRTG(View view){
        character.getSkill("Data Search").ratingUp();
        TextView dsPool = (TextView) findViewById(R.id.DSDPool);
        dsPool.setText(Integer.toString(character.getSkill("Data Search").getDicepool()));
        TextView dsRTG = (TextView) findViewById(R.id.DSRTG);
        dsRTG.setText(Integer.toString(character.getSkill("Data Search").getRating()));
    }

    public void decDSRTG(View view){
        character.getSkill("Data Search").ratingDown();
        TextView dsPool = (TextView) findViewById(R.id.DSDPool);
        dsPool.setText(Integer.toString(character.getSkill("Data Search").getDicepool()));
        TextView dsRTG = (TextView) findViewById(R.id.DSRTG);
        dsRTG.setText(Integer.toString(character.getSkill("Data Search").getRating()));
    }

    public void incDemRTG(View view){
        character.getSkill("Demolitions").ratingUp();
        TextView demPool = (TextView) findViewById(R.id.DemDPool);
        demPool.setText(Integer.toString(character.getSkill("Demolitions").getDicepool()));
        TextView demRTG = (TextView) findViewById(R.id.DemRTG);
        demRTG.setText(Integer.toString(character.getSkill("Demolitions").getRating()));
    }

    public void decDemRTG(View view){
        character.getSkill("Demolitions").ratingDown();
        TextView demPool = (TextView) findViewById(R.id.DemDPool);
        demPool.setText(Integer.toString(character.getSkill("Demolitions").getDicepool()));
        TextView demRTG = (TextView) findViewById(R.id.DemRTG);
        demRTG.setText(Integer.toString(character.getSkill("Demolitions").getRating()));
    }

    public void incDisRTG(View view){
        character.getSkill("Disguise").ratingUp();
        TextView disPool = (TextView) findViewById(R.id.DisDPool);
        disPool.setText(Integer.toString(character.getSkill("Disguise").getDicepool()));
        TextView disRTG = (TextView) findViewById(R.id.DisRTG);
        disRTG.setText(Integer.toString(character.getSkill("Disguise").getRating()));
    }

    public void decDisRTG(View view){
        character.getSkill("Disguise").ratingDown();
        TextView disPool = (TextView) findViewById(R.id.DisDPool);
        disPool.setText(Integer.toString(character.getSkill("Disguise").getDicepool()));
        TextView disRTG = (TextView) findViewById(R.id.DisRTG);
        disRTG.setText(Integer.toString(character.getSkill("Disguise").getRating()));
    }

    public void incDivRTG(View view){
        character.getSkill("Diving").ratingUp();
        TextView divPool = (TextView) findViewById(R.id.DivDPool);
        divPool.setText(Integer.toString(character.getSkill("Diving").getDicepool()));
        TextView divRTG = (TextView) findViewById(R.id.DivRTG);
        divRTG.setText(Integer.toString(character.getSkill("Diving").getRating()));
    }

    public void decDivRTG(View view){
        character.getSkill("Diving").ratingDown();
        TextView divPool = (TextView) findViewById(R.id.DivDPool);
        divPool.setText(Integer.toString(character.getSkill("Diving").getDicepool()));
        TextView divRTG = (TextView) findViewById(R.id.DivRTG);
        divRTG.setText(Integer.toString(character.getSkill("Diving").getRating()));
    }

    public void incDodRTG(View view){
        character.getSkill("Dodge").ratingUp();
        TextView dodPool = (TextView) findViewById(R.id.DodDPool);
        dodPool.setText(Integer.toString(character.getSkill("Dodge").getDicepool()));
        TextView dodRTG = (TextView) findViewById(R.id.DodRTG);
        dodRTG.setText(Integer.toString(character.getSkill("Dodge").getRating()));
    }

    public void decDodRTG(View view){
        character.getSkill("Dodge").ratingDown();
        TextView dodPool = (TextView) findViewById(R.id.DodDPool);
        dodPool.setText(Integer.toString(character.getSkill("Dodge").getDicepool()));
        TextView dodRTG = (TextView) findViewById(R.id.DodRTG);
        dodRTG.setText(Integer.toString(character.getSkill("Dodge").getRating()));
    }

    public void incEncRTG(View view){
        character.getSkill("Enchanting").ratingUp();
        TextView encPool = (TextView) findViewById(R.id.EncDPool);
        encPool.setText(Integer.toString(character.getSkill("Enchanting").getDicepool()));
        TextView encRTG = (TextView) findViewById(R.id.EncRTG);
        encRTG.setText(Integer.toString(character.getSkill("Enchanting").getRating()));
    }

    public void decEncRTG(View view){
        character.getSkill("Enchanting").ratingDown();
        TextView encPool = (TextView) findViewById(R.id.EncDPool);
        encPool.setText(Integer.toString(character.getSkill("Enchanting").getDicepool()));
        TextView encRTG = (TextView) findViewById(R.id.EncRTG);
        encRTG.setText(Integer.toString(character.getSkill("Enchanting").getRating()));
    }

    public void incEARTG(View view){
        character.getSkill("Escape Artist").ratingUp();
        TextView eaPool = (TextView) findViewById(R.id.EADPool);
        eaPool.setText(Integer.toString(character.getSkill("Escape Artist").getDicepool()));
        TextView eaRTG = (TextView) findViewById(R.id.EARTG);
        eaRTG.setText(Integer.toString(character.getSkill("Escape Artist").getRating()));
    }

    public void decEARTG(View view){
        character.getSkill("Escape Artist").ratingDown();
        TextView eaPool = (TextView) findViewById(R.id.EADPool);
        eaPool.setText(Integer.toString(character.getSkill("Escape Artist").getDicepool()));
        TextView eaRTG = (TextView) findViewById(R.id.EARTG);
        eaRTG.setText(Integer.toString(character.getSkill("Escape Artist").getRating()));
    }

    public void incEtiRTG(View view){
        character.getSkill("Etiquette").ratingUp();
        TextView etiPool = (TextView) findViewById(R.id.EtiDPool);
        etiPool.setText(Integer.toString(character.getSkill("Etiquette").getDicepool()));
        TextView etiRTG = (TextView) findViewById(R.id.EtiRTG);
        etiRTG.setText(Integer.toString(character.getSkill("Etiquette").getRating()));
    }

    public void decEtiRTG(View view){
        character.getSkill("Etiquette").ratingDown();
        TextView etiPool = (TextView) findViewById(R.id.EtiDPool);
        etiPool.setText(Integer.toString(character.getSkill("Etiquette").getDicepool()));
        TextView etiRTG = (TextView) findViewById(R.id.EtiRTG);
        etiRTG.setText(Integer.toString(character.getSkill("Etiquette").getRating()));
    }

    public void incFARTG(View view){
        character.getSkill("First Aid").ratingUp();
        TextView faPool = (TextView) findViewById(R.id.FADPool);
        faPool.setText(Integer.toString(character.getSkill("First Aid").getDicepool()));
        TextView faRTG = (TextView) findViewById(R.id.FARTG);
        faRTG.setText(Integer.toString(character.getSkill("First Aid").getRating()));
    }

    public void decFARTG(View view){
        character.getSkill("First Aid").ratingDown();
        TextView faPool = (TextView) findViewById(R.id.FADPool);
        faPool.setText(Integer.toString(character.getSkill("First Aid").getDicepool()));
        TextView faRTG = (TextView) findViewById(R.id.FARTG);
        faRTG.setText(Integer.toString(character.getSkill("First Aid").getRating()));
    }

    public void incForgRTG(View view){
        character.getSkill("Forgery").ratingUp();
        TextView forgPool = (TextView) findViewById(R.id.ForgDPool);
        forgPool.setText(Integer.toString(character.getSkill("Forgery").getDicepool()));
        TextView forgRTG = (TextView) findViewById(R.id.ForgRTG);
        forgRTG.setText(Integer.toString(character.getSkill("Forgery").getRating()));
    }

    public void decForgRTG(View view){
        character.getSkill("Forgery").ratingDown();
        TextView forgPool = (TextView) findViewById(R.id.ForgDPool);
        forgPool.setText(Integer.toString(character.getSkill("Forgery").getDicepool()));
        TextView forgRTG = (TextView) findViewById(R.id.ForgRTG);
        forgRTG.setText(Integer.toString(character.getSkill("Forgery").getRating()));
    }

    public void incGunRTG(View view){
        character.getSkill("Gunnery").ratingUp();
        TextView gunPool = (TextView) findViewById(R.id.GunDPool);
        gunPool.setText(Integer.toString(character.getSkill("Gunnery").getDicepool()));
        TextView gunRTG = (TextView) findViewById(R.id.GunRTG);
        gunRTG.setText(Integer.toString(character.getSkill("Gunnery").getRating()));
    }

    public void decGunRTG(View view){
        character.getSkill("Gunnery").ratingDown();
        TextView gunPool = (TextView) findViewById(R.id.GunDPool);
        gunPool.setText(Integer.toString(character.getSkill("Gunnery").getDicepool()));
        TextView gunRTG = (TextView) findViewById(R.id.GunRTG);
        gunRTG.setText(Integer.toString(character.getSkill("Gunnery").getRating()));
    }

    public void incGymRTG(View view){
        character.getSkill("Gymnastics").ratingUp();
        TextView gymPool = (TextView) findViewById(R.id.GymDPool);
        gymPool.setText(Integer.toString(character.getSkill("Gymnastics").getDicepool()));
        TextView gymRTG = (TextView) findViewById(R.id.GymRTG);
        gymRTG.setText(Integer.toString(character.getSkill("Gymnastics").getRating()));
    }

    public void decGymRTG(View view){
        character.getSkill("Gymnastics").ratingDown();
        TextView gymPool = (TextView) findViewById(R.id.GymDPool);
        gymPool.setText(Integer.toString(character.getSkill("Gymnastics").getDicepool()));
        TextView gymRTG = (TextView) findViewById(R.id.GymRTG);
        gymRTG.setText(Integer.toString(character.getSkill("Gymnastics").getRating()));
    }

    public void incHackRTG(View view){
        character.getSkill("Hacking").ratingUp();
        TextView hackPool = (TextView) findViewById(R.id.HackDPool);
        hackPool.setText(Integer.toString(character.getSkill("Hacking").getDicepool()));
        TextView hackRTG = (TextView) findViewById(R.id.HackRTG);
        hackRTG.setText(Integer.toString(character.getSkill("Hacking").getRating()));
    }

    public void decHackRTG(View view){
        character.getSkill("Hacking").ratingDown();
        TextView hackPool = (TextView) findViewById(R.id.HackDPool);
        hackPool.setText(Integer.toString(character.getSkill("Hacking").getDicepool()));
        TextView hackRTG = (TextView) findViewById(R.id.HackRTG);
        hackRTG.setText(Integer.toString(character.getSkill("Hacking").getRating()));
    }

    public void incHWRTG(View view){
        character.getSkill("Heavy Weapons").ratingUp();
        TextView hwPool = (TextView) findViewById(R.id.HWDPool);
        hwPool.setText(Integer.toString(character.getSkill("Heavy Weapons").getDicepool()));
        TextView hwRTG = (TextView) findViewById(R.id.HWRTG);
        hwRTG.setText(Integer.toString(character.getSkill("Heavy Weapons").getRating()));
    }

    public void decHWRTG(View view){
        character.getSkill("Heavy Weapons").ratingDown();
        TextView hwPool = (TextView) findViewById(R.id.HWDPool);
        hwPool.setText(Integer.toString(character.getSkill("Heavy Weapons").getDicepool()));
        TextView hwRTG = (TextView) findViewById(R.id.HWRTG);
        hwRTG.setText(Integer.toString(character.getSkill("Heavy Weapons").getRating()));
    }

    public void incInfilRTG(View view){
        character.getSkill("Infiltration").ratingUp();
        TextView infilPool = (TextView) findViewById(R.id.InfilDPool);
        infilPool.setText(Integer.toString(character.getSkill("Infiltration").getDicepool()));
        TextView infilRTG = (TextView) findViewById(R.id.InfilRTG);
        infilRTG.setText(Integer.toString(character.getSkill("Infiltration").getRating()));
    }

    public void decInfilRTG(View view){
        character.getSkill("Infiltration").ratingDown();
        TextView infilPool = (TextView) findViewById(R.id.InfilDPool);
        infilPool.setText(Integer.toString(character.getSkill("Infiltration").getDicepool()));
        TextView infilRTG = (TextView) findViewById(R.id.InfilRTG);
        infilRTG.setText(Integer.toString(character.getSkill("Infiltration").getRating()));
    }

    public void incInstRTG(View view){
        character.getSkill("Instruction").ratingUp();
        TextView instPool = (TextView) findViewById(R.id.InstDPool);
        instPool.setText(Integer.toString(character.getSkill("Instruction").getDicepool()));
        TextView instRTG = (TextView) findViewById(R.id.InstRTG);
        instRTG.setText(Integer.toString(character.getSkill("Instruction").getRating()));
    }

    public void decInstRTG(View view){
        character.getSkill("Instruction").ratingDown();
        TextView instPool = (TextView) findViewById(R.id.InstDPool);
        instPool.setText(Integer.toString(character.getSkill("Instruction").getDicepool()));
        TextView instRTG = (TextView) findViewById(R.id.InstRTG);
        instRTG.setText(Integer.toString(character.getSkill("Instruction").getRating()));
    }

    public void incIKRTG(View view){
        character.getSkill("Interests Knowledge").ratingUp();
        TextView ikPool = (TextView) findViewById(R.id.IKDPool);
        ikPool.setText(Integer.toString(character.getSkill("Interests Knowledge").getDicepool()));
        TextView ikRTG = (TextView) findViewById(R.id.IKRTG);
        ikRTG.setText(Integer.toString(character.getSkill("Interests Knowledge").getRating()));
    }

    public void decIKRTG(View view){
        character.getSkill("Interests Knowledge").ratingDown();
        TextView ikPool = (TextView) findViewById(R.id.IKDPool);
        ikPool.setText(Integer.toString(character.getSkill("Interests Knowledge").getDicepool()));
        TextView ikRTG = (TextView) findViewById(R.id.IKRTG);
        ikRTG.setText(Integer.toString(character.getSkill("Interests Knowledge").getRating()));
    }

    public void incIntRTG(View view){
        character.getSkill("Intimidation").ratingUp();
        TextView intPool = (TextView) findViewById(R.id.IntDPool);
        intPool.setText(Integer.toString(character.getSkill("Intimidation").getDicepool()));
        TextView intRTG = (TextView) findViewById(R.id.IntRTG);
        intRTG.setText(Integer.toString(character.getSkill("Intimidation").getRating()));
    }

    public void decIntRTG(View view){
        character.getSkill("Intimidation").ratingDown();
        TextView intPool = (TextView) findViewById(R.id.IntDPool);
        intPool.setText(Integer.toString(character.getSkill("Intimidation").getDicepool()));
        TextView intRTG = (TextView) findViewById(R.id.IntRTG);
        intRTG.setText(Integer.toString(character.getSkill("Intimidation").getRating()));
    }

    public void incLeadRTG(View view){
        character.getSkill("Leadership").ratingUp();
        TextView leadPool = (TextView) findViewById(R.id.LeadDPool);
        leadPool.setText(Integer.toString(character.getSkill("Leadership").getDicepool()));
        TextView leadRTG = (TextView) findViewById(R.id.LeadRTG);
        leadRTG.setText(Integer.toString(character.getSkill("Leadership").getRating()));
    }

    public void decLeadRTG(View view){
        character.getSkill("Leadership").ratingDown();
        TextView leadPool = (TextView) findViewById(R.id.LeadDPool);
        leadPool.setText(Integer.toString(character.getSkill("Leadership").getDicepool()));
        TextView leadRTG = (TextView) findViewById(R.id.LeadRTG);
        leadRTG.setText(Integer.toString(character.getSkill("Leadership").getRating()));
    }

    public void incLockRTG(View view){
        character.getSkill("Locksmith").ratingUp();
        TextView lockPool = (TextView) findViewById(R.id.LockDPool);
        lockPool.setText(Integer.toString(character.getSkill("Locksmith").getDicepool()));
        TextView lockRTG = (TextView) findViewById(R.id.LockRTG);
        lockRTG.setText(Integer.toString(character.getSkill("Locksmith").getRating()));
    }

    public void decLockRTG(View view){
        character.getSkill("Locksmith").ratingDown();
        TextView lockPool = (TextView) findViewById(R.id.LockDPool);
        lockPool.setText(Integer.toString(character.getSkill("Locksmith").getDicepool()));
        TextView lockRTG = (TextView) findViewById(R.id.LockRTG);
        lockRTG.setText(Integer.toString(character.getSkill("Locksmith").getRating()));
    }

    public void incLongRTG(View view){
        character.getSkill("Longarms").ratingUp();
        TextView longPool = (TextView) findViewById(R.id.LongDPool);
        longPool.setText(Integer.toString(character.getSkill("Longarms").getDicepool()));
        TextView longRTG = (TextView) findViewById(R.id.LongRTG);
        longRTG.setText(Integer.toString(character.getSkill("Longarms").getRating()));
    }

    public void decLongRTG(View view){
        character.getSkill("Longarms").ratingDown();
        TextView longPool = (TextView) findViewById(R.id.LongDPool);
        longPool.setText(Integer.toString(character.getSkill("Longarms").getDicepool()));
        TextView longRTG = (TextView) findViewById(R.id.LongRTG);
        longRTG.setText(Integer.toString(character.getSkill("Longarms").getRating()));
    }

    public void incNavRTG(View view){
        character.getSkill("Navigation").ratingUp();
        TextView navPool = (TextView) findViewById(R.id.NavDPool);
        navPool.setText(Integer.toString(character.getSkill("Navigation").getDicepool()));
        TextView navRTG = (TextView) findViewById(R.id.NavRTG);
        navRTG.setText(Integer.toString(character.getSkill("Navigation").getRating()));
    }

    public void decNavRTG(View view){
        character.getSkill("Navigation").ratingDown();
        TextView navPool = (TextView) findViewById(R.id.NavDPool);
        navPool.setText(Integer.toString(character.getSkill("Navigation").getDicepool()));
        TextView navRTG = (TextView) findViewById(R.id.NavRTG);
        navRTG.setText(Integer.toString(character.getSkill("Navigation").getRating()));
    }

    public void incNegRTG(View view){
        character.getSkill("Negotiation").ratingUp();
        TextView negPool = (TextView) findViewById(R.id.NegDPool);
        negPool.setText(Integer.toString(character.getSkill("Negotiation").getDicepool()));
        TextView negRTG = (TextView) findViewById(R.id.NegRTG);
        negRTG.setText(Integer.toString(character.getSkill("Negotiation").getRating()));
    }

    public void decNegRTG(View view){
        character.getSkill("Negotiation").ratingDown();
        TextView negPool = (TextView) findViewById(R.id.NegDPool);
        negPool.setText(Integer.toString(character.getSkill("Negotiation").getDicepool()));
        TextView negRTG = (TextView) findViewById(R.id.NegRTG);
        negRTG.setText(Integer.toString(character.getSkill("Negotiation").getRating()));
    }

    public void incPalmRTG(View view){
        character.getSkill("Palming").ratingUp();
        TextView palmPool = (TextView) findViewById(R.id.PalmDPool);
        palmPool.setText(Integer.toString(character.getSkill("Palming").getDicepool()));
        TextView palmRTG = (TextView) findViewById(R.id.PalmRTG);
        palmRTG.setText(Integer.toString(character.getSkill("Palming").getRating()));
    }

    public void decPalmRTG(View view){
        character.getSkill("Palming").ratingDown();
        TextView palmPool = (TextView) findViewById(R.id.PalmDPool);
        palmPool.setText(Integer.toString(character.getSkill("Palming").getDicepool()));
        TextView palmRTG = (TextView) findViewById(R.id.PalmRTG);
        palmRTG.setText(Integer.toString(character.getSkill("Palming").getRating()));
    }

    public void incParaRTG(View view){
        character.getSkill("Parachuting").ratingUp();
        TextView paraPool = (TextView) findViewById(R.id.ParaDPool);
        paraPool.setText(Integer.toString(character.getSkill("Parachuting").getDicepool()));
        TextView paraRTG = (TextView) findViewById(R.id.ParaRTG);
        paraRTG.setText(Integer.toString(character.getSkill("Parachuting").getRating()));
    }

    public void decParaRTG(View view){
        character.getSkill("Parachuting").ratingDown();
        TextView paraPool = (TextView) findViewById(R.id.ParaDPool);
        paraPool.setText(Integer.toString(character.getSkill("Parachuting").getDicepool()));
        TextView paraRTG = (TextView) findViewById(R.id.ParaRTG);
        paraRTG.setText(Integer.toString(character.getSkill("Parachuting").getRating()));
    }

    public void incPerRTG(View view){
        character.getSkill("Perception").ratingUp();
        TextView perPool = (TextView) findViewById(R.id.PerDPool);
        perPool.setText(Integer.toString(character.getSkill("Perception").getDicepool()));
        TextView perRTG = (TextView) findViewById(R.id.PerRTG);
        perRTG.setText(Integer.toString(character.getSkill("Perception").getRating()));
    }

    public void decPerRTG(View view){
        character.getSkill("Perception").ratingDown();
        TextView perPool = (TextView) findViewById(R.id.PerDPool);
        perPool.setText(Integer.toString(character.getSkill("Perception").getDicepool()));
        TextView perRTG = (TextView) findViewById(R.id.PerRTG);
        perRTG.setText(Integer.toString(character.getSkill("Perception").getRating()));
    }

    public void incPGRTG(View view){
        character.getSkill("Pilot Ground Craft").ratingUp();
        TextView pgPool = (TextView) findViewById(R.id.PGDPool);
        pgPool.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getDicepool()));
        TextView pgRTG = (TextView) findViewById(R.id.PGRTG);
        pgRTG.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getRating()));
    }

    public void decPGRTG(View view){
        character.getSkill("Pilot Ground Craft").ratingDown();
        TextView pgPool = (TextView) findViewById(R.id.PGDPool);
        pgPool.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getDicepool()));
        TextView pgRTG = (TextView) findViewById(R.id.PGRTG);
        pgRTG.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getRating()));
    }

    public void incPWRTG(View view){
        character.getSkill("Pilot Watercraft").ratingUp();
        TextView pwPool = (TextView) findViewById(R.id.PWDPool);
        pwPool.setText(Integer.toString(character.getSkill("Pilot Watercraft").getDicepool()));
        TextView pwRTG = (TextView) findViewById(R.id.PWRTG);
        pwRTG.setText(Integer.toString(character.getSkill("Pilot Watercraft").getRating()));
    }

    public void decPWRTG(View view){
        character.getSkill("Pilot Watercraft").ratingDown();
        TextView pwPool = (TextView) findViewById(R.id.PWDPool);
        pwPool.setText(Integer.toString(character.getSkill("Pilot Watercraft").getDicepool()));
        TextView pwRTG = (TextView) findViewById(R.id.PWRTG);
        pwRTG.setText(Integer.toString(character.getSkill("Pilot Watercraft").getRating()));
    }

    public void incPistRTG(View view){
        character.getSkill("Pistols").ratingUp();
        TextView pistPool = (TextView) findViewById(R.id.PistDPool);
        pistPool.setText(Integer.toString(character.getSkill("Pistols").getDicepool()));
        TextView pistRTG = (TextView) findViewById(R.id.PistRTG);
        pistRTG.setText(Integer.toString(character.getSkill("Pistols").getRating()));
    }

    public void decPistRTG(View view){
        character.getSkill("Pistols").ratingDown();
        TextView pistPool = (TextView) findViewById(R.id.PistDPool);
        pistPool.setText(Integer.toString(character.getSkill("Pistols").getDicepool()));
        TextView pistRTG = (TextView) findViewById(R.id.PistRTG);
        pistRTG.setText(Integer.toString(character.getSkill("Pistols").getRating()));
    }

    public void incPKRTG(View view){
        character.getSkill("Professional Knowledge").ratingUp();
        TextView pkPool = (TextView) findViewById(R.id.PKDPool);
        pkPool.setText(Integer.toString(character.getSkill("Professional Knowledge").getDicepool()));
        TextView pkRTG = (TextView) findViewById(R.id.PKRTG);
        pkRTG.setText(Integer.toString(character.getSkill("Professional Knowledge").getRating()));
    }

    public void decPKRTG(View view){
        character.getSkill("Professional Knowledge").ratingDown();
        TextView pkPool = (TextView) findViewById(R.id.PKDPool);
        pkPool.setText(Integer.toString(character.getSkill("Professional Knowledge").getDicepool()));
        TextView pkRTG = (TextView) findViewById(R.id.PKRTG);
        pkRTG.setText(Integer.toString(character.getSkill("Professional Knowledge").getRating()));
    }

    public void incRunRTG(View view){
        character.getSkill("Running").ratingUp();
        TextView runPool = (TextView) findViewById(R.id.RunDPool);
        runPool.setText(Integer.toString(character.getSkill("Running").getDicepool()));
        TextView runRTG = (TextView) findViewById(R.id.RunRTG);
        runRTG.setText(Integer.toString(character.getSkill("Running").getRating()));
    }

    public void decRunRTG(View view){
        character.getSkill("Running").ratingDown();
        TextView runPool = (TextView) findViewById(R.id.RunDPool);
        runPool.setText(Integer.toString(character.getSkill("Running").getDicepool()));
        TextView runRTG = (TextView) findViewById(R.id.RunRTG);
        runRTG.setText(Integer.toString(character.getSkill("Running").getRating()));
    }

    public void incShadowRTG(View view){
        character.getSkill("Shadowing").ratingUp();
        TextView shadowPool = (TextView) findViewById(R.id.ShadowDPool);
        shadowPool.setText(Integer.toString(character.getSkill("Shadowing").getDicepool()));
        TextView shadowRTG = (TextView) findViewById(R.id.ShadowRTG);
        shadowRTG.setText(Integer.toString(character.getSkill("Shadowing").getRating()));
    }

    public void decShadowRTG(View view){
        character.getSkill("Shadowing").ratingDown();
        TextView shadowPool = (TextView) findViewById(R.id.ShadowDPool);
        shadowPool.setText(Integer.toString(character.getSkill("Shadowing").getDicepool()));
        TextView shadowRTG = (TextView) findViewById(R.id.ShadowRTG);
        shadowRTG.setText(Integer.toString(character.getSkill("Shadowing").getRating()));
    }

    public void incSKRTG(View view){
        character.getSkill("Street Knowledge").ratingUp();
        TextView skPool = (TextView) findViewById(R.id.SKDPool);
        skPool.setText(Integer.toString(character.getSkill("Street Knowledge").getDicepool()));
        TextView skRTG = (TextView) findViewById(R.id.SKRTG);
        skRTG.setText(Integer.toString(character.getSkill("Street Knowledge").getRating()));
    }

    public void decSKRTG(View view){
        character.getSkill("Street Knowledge").ratingDown();
        TextView skPool = (TextView) findViewById(R.id.SKDPool);
        skPool.setText(Integer.toString(character.getSkill("Street Knowledge").getDicepool()));
        TextView skRTG = (TextView) findViewById(R.id.SKRTG);
        skRTG.setText(Integer.toString(character.getSkill("Street Knowledge").getRating()));
    }

    public void incSurvRTG(View view){
        character.getSkill("Survival").ratingUp();
        TextView survPool = (TextView) findViewById(R.id.SurvDPool);
        survPool.setText(Integer.toString(character.getSkill("Survival").getDicepool()));
        TextView survRTG = (TextView) findViewById(R.id.SurvRTG);
        survRTG.setText(Integer.toString(character.getSkill("Survival").getRating()));
    }

    public void decSurvRTG(View view){
        character.getSkill("Survival").ratingDown();
        TextView survPool = (TextView) findViewById(R.id.SurvDPool);
        survPool.setText(Integer.toString(character.getSkill("Survival").getDicepool()));
        TextView survRTG = (TextView) findViewById(R.id.SurvRTG);
        survRTG.setText(Integer.toString(character.getSkill("Survival").getRating()));
    }

    public void incSwimRTG(View view){
        character.getSkill("Swimming").ratingUp();
        TextView swimPool = (TextView) findViewById(R.id.SwimDPool);
        swimPool.setText(Integer.toString(character.getSkill("Swimming").getDicepool()));
        TextView swimRTG = (TextView) findViewById(R.id.SwimRTG);
        swimRTG.setText(Integer.toString(character.getSkill("Swimming").getRating()));
    }

    public void decSwimRTG(View view){
        character.getSkill("Swimming").ratingDown();
        TextView swimPool = (TextView) findViewById(R.id.SwimDPool);
        swimPool.setText(Integer.toString(character.getSkill("Swimming").getDicepool()));
        TextView swimRTG = (TextView) findViewById(R.id.SwimRTG);
        swimRTG.setText(Integer.toString(character.getSkill("Swimming").getRating()));
    }

    public void incTWRTG(View view){
        character.getSkill("Throwing Weapons").ratingUp();
        TextView twPool = (TextView) findViewById(R.id.TWDPool);
        twPool.setText(Integer.toString(character.getSkill("Throwing Weapons").getDicepool()));
        TextView twRTG = (TextView) findViewById(R.id.TWRTG);
        twRTG.setText(Integer.toString(character.getSkill("Throwing Weapons").getRating()));
    }

    public void decTWRTG(View view){
        character.getSkill("Throwing Weapons").ratingDown();
        TextView twPool = (TextView) findViewById(R.id.TWDPool);
        twPool.setText(Integer.toString(character.getSkill("Throwing Weapons").getDicepool()));
        TextView twRTG = (TextView) findViewById(R.id.TWRTG);
        twRTG.setText(Integer.toString(character.getSkill("Throwing Weapons").getRating()));
    }

    public void incTrackRTG(View view){
        character.getSkill("Tracking").ratingUp();
        TextView trackPool = (TextView) findViewById(R.id.TrackDPool);
        trackPool.setText(Integer.toString(character.getSkill("Tracking").getDicepool()));
        TextView trackRTG = (TextView) findViewById(R.id.TrackRTG);
        trackRTG.setText(Integer.toString(character.getSkill("Tracking").getRating()));
    }

    public void decTrackRTG(View view){
        character.getSkill("Tracking").ratingDown();
        TextView trackPool = (TextView) findViewById(R.id.TrackDPool);
        trackPool.setText(Integer.toString(character.getSkill("Tracking").getDicepool()));
        TextView trackRTG = (TextView) findViewById(R.id.TrackRTG);
        trackRTG.setText(Integer.toString(character.getSkill("Tracking").getRating()));
    }

    public void incUCRTG(View view){
        character.getSkill("Unarmed Combat").ratingUp();
        TextView ucPool = (TextView) findViewById(R.id.UCDPool);
        ucPool.setText(Integer.toString(character.getSkill("Unarmed Combat").getDicepool()));
        TextView ucRTG = (TextView) findViewById(R.id.UCRTG);
        ucRTG.setText(Integer.toString(character.getSkill("Unarmed Combat").getRating()));
    }

    public void decUCRTG(View view){
        character.getSkill("Unarmed Combat").ratingDown();
        TextView ucPool = (TextView) findViewById(R.id.UCDPool);
        ucPool.setText(Integer.toString(character.getSkill("Unarmed Combat").getDicepool()));
        TextView ucRTG = (TextView) findViewById(R.id.UCRTG);
        ucRTG.setText(Integer.toString(character.getSkill("Unarmed Combat").getRating()));
    }
}
