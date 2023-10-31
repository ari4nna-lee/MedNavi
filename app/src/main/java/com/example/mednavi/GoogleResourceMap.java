package com.example.mednavi;

import androidx.fragment.app.FragmentActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mednavi.databinding.ActivityGoogleResourceMapBinding;

import java.sql.Array;
import java.util.ArrayList;

public class GoogleResourceMap extends FragmentActivity implements OnMapReadyCallback {

    private LinearLayout layout;
    private LinearLayout layout_2;
    private LinearLayout layout_3;

    private CheckBox ecuHealthHospitals;
    private CheckBox freeCharitable;
    private CheckBox pharm_check;
    private CheckBox social_services_check;
    private CheckBox lab_services_check;
    private CheckBox primary_check;
    private CheckBox bilingual_check;

    private CheckBox slidingScale;
    private CheckBox pediatric_check;
    private CheckBox adult_check;
    private CheckBox fam_medicine_check;
    private CheckBox behavioral_check;
    private CheckBox dental_check;

    private CheckBox urgentCare;
    private CheckBox medicare_medicaid_check;
    private CheckBox medicare_only_check;
    private CheckBox online_care_check;

    private GoogleMap mMap;
    private ActivityGoogleResourceMapBinding binding;

    private ArrayList<Marker>totalECUHealth = new ArrayList<>();
    private ArrayList<Marker>totalFreeCharitable = new ArrayList<>();
    private ArrayList<Marker>freePharmacyServices = new ArrayList<>();
    private ArrayList<Marker>freeSocialServices = new ArrayList<>();
    private ArrayList<Marker>freeLabServices = new ArrayList<>();
    private ArrayList<Marker>freePrimaryCare = new ArrayList<>();
    private ArrayList<Marker>bilingualStaff = new ArrayList<>();

    private ArrayList<Marker>totalSlidingScale = new ArrayList<>();
    private ArrayList<Marker> pediatricCare = new ArrayList<>();
    private ArrayList<Marker> adultCare = new ArrayList<>();
    private ArrayList<Marker> familyMedicine = new ArrayList<>();
    private ArrayList<Marker> behavioralCare = new ArrayList<>();
    private ArrayList<Marker> dentalCare = new ArrayList<>();

    private ArrayList<Marker>totalUrgCare = new ArrayList<>();
    private ArrayList<Marker>medicareMedicaid = new ArrayList<>();
    private ArrayList<Marker>medicareOnly = new ArrayList<>();
    private ArrayList<Marker>onlineCare = new ArrayList<>();

    private ImageView homeIcon;
    private ImageView newsButton;
    private ImageView settingsButton;
    private Button missingLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGoogleResourceMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        layout = findViewById(R.id.layout);
        layout = findViewById(R.id.layout_b);
        layout_2 = findViewById(R.id.layout_2);
        layout_3 = findViewById(R.id.layout_3);

        ecuHealthHospitals = findViewById(R.id.ecu_health_check);
        freeCharitable = findViewById(R.id.free_charitable_cat);
        slidingScale = findViewById(R.id.sliding_care);
        urgentCare = findViewById(R.id.urgent_care_cat);

        pharm_check = findViewById(R.id.pharm_check);
        social_services_check = findViewById(R.id.social_services_check);
        lab_services_check = findViewById(R.id.lab_check);
        primary_check = findViewById(R.id.primary_check);
        bilingual_check = findViewById(R.id.billingual_check);

        pediatric_check = findViewById(R.id.pediatric_check);
        adult_check = findViewById(R.id.adult_check);
        fam_medicine_check = findViewById(R.id.fam_med_check);
        behavioral_check = findViewById(R.id.behavioral_check);
        dental_check = findViewById(R.id.dental_sliding_check);

        medicare_medicaid_check = findViewById(R.id.medicare_medicaid);
        medicare_only_check = findViewById(R.id.medicare_only);
        online_care_check = findViewById(R.id.online_care);

        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout_2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout_3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        homeIcon = findViewById(R.id.home_button);
        newsButton = findViewById(R.id.news_button);
        settingsButton = findViewById(R.id.settings_button);
        missingLocation = findViewById(R.id.missing_location);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsPage.class);
                startActivity(intent);
                finish();
            }
        });

        missingLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSegOevUhOH5q-RaDsO1zCxmQyzD0uj70nBqM5z_TWN6---scQ/viewform?usp=sf_link"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    private Bitmap resize(Drawable image, int width, int height){
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, width, height, false);
        //return new BitmapDrawable(getResources(), bitmapResized);
        return bitmapResized;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bitmap hospital_icon = resize(getDrawable(R.drawable.hospital_icon), 70, 70);
        Bitmap uc_icon = resize(getDrawable(R.drawable.urgent_care), 70, 70);
        Bitmap charitable_icon = resize(getDrawable(R.drawable.charitable_icon), 90, 90);
        Bitmap sliding_scale_icon = resize(getDrawable(R.drawable.sliding_scale), 90, 90);

        // ECU Health Hospitals Markers
        LatLng ecu_health_mc = new LatLng(35.605820, -77.400940);
        LatLng ecu_health_beaufort = new LatLng(35.549330, -77.038310);
        LatLng ecu_health_bertie = new LatLng(35.988630, -76.928300);
        LatLng ecu_health_chowan = new LatLng(36.070070, -76.611400);
        LatLng ecu_health_duplin = new LatLng(34.965040, -77.961850);
        LatLng ecu_health_edge = new LatLng(35.921090, -77.556200);
        LatLng ecu_health_north = new LatLng(36.432380, -77.646220);
        LatLng ecu_health_roanoke = new LatLng(36.291510, -76.987730);
        LatLng ecu_health_obx = new LatLng(35.939690, -75.617820);
        Marker ecu_health_main = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_mc).title("ECU Health Medical Center")
                        .snippet("2100 Stantonsburg Rd, Greenville, NC 27834 \n (252)-975-4100"));
        ecu_health_main.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_beaufort = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_beaufort).title("ECU Health Beaufort Hospital")
                        .snippet("628 E 12th St, Washington, NC 27889 \n (252)-975-4100"));
        ecu_beaufort.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_bertie = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_bertie).title("ECU Health Bertie Hospital")
                        .snippet("1403 S King St, Windsor, NC, 27983 \n (252)-794-6600"));
        ecu_bertie.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_chowan = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_chowan).title("ECU Health Chowan Hospital")
                        .snippet("211 Virginia Rd, Edenton, NC, 27932 \n (252)-482-8451"));
        ecu_chowan.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_duplin = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_duplin).title("ECU Health Duplin Hospital")
                        .snippet("401 N. Main St, Kenansville, NC, 28349 \n (910)-296-0941"));
        ecu_duplin.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_edge = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_edge).title("ECU Health Edgecombe Hospital")
                        .snippet("111 Hospital Dr, Tarboro, NC, 27886 \n (252)-641-7700"));
        ecu_edge.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_north = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_north).title("ECU Health North Hospital")
                        .snippet("250 Smith Church Rd, Roanoke Rapids, NC, 27870 \n (252)-535-8011"));
        ecu_north.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_roanoke = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_roanoke).title("ECU Health Roanoke-Chowan Hospital")
                        .snippet("500 S Academy St, Ahoskie, NC, 27910 \n (252)-209-3000"));
        ecu_roanoke.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        Marker ecu_obx = mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_obx).title("The Outer Banks Hospital")
                        .snippet("4800 S Croatan Hwy, Nags Head, NC, 27959 \n (252)-449-4500"));
        ecu_obx.setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));

        totalECUHealth.add(ecu_health_main); totalECUHealth.add(ecu_beaufort); totalECUHealth.add(ecu_bertie); totalECUHealth.add(ecu_chowan); totalECUHealth.add(ecu_duplin); totalECUHealth.add(ecu_edge); totalECUHealth.add(ecu_north); totalECUHealth.add(ecu_roanoke); totalECUHealth.add(ecu_obx);
        checkAndUncheck(ecuHealthHospitals, totalECUHealth);

        // Urgent Care Locations
        LatLng phys_east_urg = new LatLng(35.568870, -77.356370);
        LatLng urg_down_east = new LatLng(35.560030, -77.058360);
        LatLng fastmed_urg_gville = new LatLng(35.581370, -77.376990);
        LatLng fastmed_urg_kinston = new LatLng(35.292660, -77.585790);
        LatLng fastmed_urg_golds = new LatLng(35.374840, -77.953930);
        LatLng imm_care_golds = new LatLng(35.400810, -77.954920);
        LatLng healthfirst_primary = new LatLng(35.583450, -77.373660);
        LatLng med_first_emerald = new LatLng(34.665190, -77.032340);
        LatLng med_first_newbern = new LatLng(35.100906, -77.100634);
        LatLng wilson_immed = new LatLng(35.719750, -77.945330);
        LatLng fastmed_urg_mcity = new LatLng(34.726610, -76.758570);
        LatLng med_first_swans = new LatLng(34.694530, -77.131860);
        LatLng cchc_urg = new LatLng(35.105410, -77.092670);
        LatLng quicker_care = new LatLng(34.859530, -76.897620);
        LatLng carolinas_urg = new LatLng(34.730450, -76.775980);
        LatLng beach_care = new LatLng(34.735890, -76.798590);
        LatLng gville_hc = new LatLng(35.598770, -77.334970);

        Marker phys_east = mMap.addMarker(new MarkerOptions()
                        .position(phys_east_urg).title("Physicians East Urgent Care and Sleep Center")
                        .snippet("Medicare/Medicaid accepted"));
        phys_east.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker down_east = mMap.addMarker(new MarkerOptions()
                        .position(urg_down_east).title("Urgent Care Down East")
                        .snippet("Medicare accepted"));
        down_east.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker fast_gville = mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_gville).title("FastMed Urgent Care - Greenville")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        fast_gville.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker fast_golds = mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_golds).title("FastMed Urgent Care - Goldsboro")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        fast_golds.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker immed_golds = mMap.addMarker(new MarkerOptions()
                        .position(imm_care_golds).title("Immediate Care of Goldsboro")
                        .snippet("Medicare/Medicaid accepted"));
        immed_golds.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker health_first = mMap.addMarker(new MarkerOptions()
                        .position(healthfirst_primary).title("HealthFirst Primary and Urgent Care")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        health_first.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker first_emerald = mMap.addMarker(new MarkerOptions()
                        .position(med_first_emerald).title("Med First Primary & Urgent Care - Emerald Isle")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        first_emerald.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker medfirst_nb = mMap.addMarker(new MarkerOptions()
                .position(med_first_newbern).title("Med First Primary & Urgent Care - New Bern")
                .snippet("Medicare/Medicaid accepted, Online Care"));
        medfirst_nb.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker wilson_imm = mMap.addMarker(new MarkerOptions()
                        .position(wilson_immed).title("Wilson Immediate Care")
                        .snippet("Medicare/Medicaid accepted"));
        wilson_imm.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker fast_mcity = mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_mcity).title("FastMed Urgent Care - Morehead City")
                        .snippet("Medicare/Medicaid accepted"));
        fast_mcity.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker medfirst_swan = mMap.addMarker(new MarkerOptions()
                        .position(med_first_swans).title("Med First Primary & Urgent Care - Swansboro")
                        .snippet("Medicare/Medicaid accepted"));
        medfirst_swan.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker chcc = mMap.addMarker(new MarkerOptions()
                        .position(cchc_urg).title("CCHC Urgent Care")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        chcc.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker fast_med_kinston = mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_kinston).title("FastMed Urgent Care - Kinston")
                        .snippet("Medicare/Medicaid accepted, Online Care"));
        fast_med_kinston.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker quicker = mMap.addMarker(new MarkerOptions()
                        .position(quicker_care).title("Quicker Care")
                        .snippet("Medicare accepted"));
        quicker.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker carolinas = mMap.addMarker(new MarkerOptions()
                        .position(carolinas_urg).title("Carolinas Urgent and Primary Care"));
        carolinas.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker beach = mMap.addMarker(new MarkerOptions()
                        .position(beach_care).title("BeachCare Urgent & Family Medical Center")
                        .snippet("Medicare/Medicaid accepted"));
        beach.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        Marker gville_health = mMap.addMarker(new MarkerOptions()
                        .position(gville_hc).title("Greenville Health Care")
                        .snippet("Medicare/Medicaid accepted"));
        gville_health.setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));

        totalUrgCare.add(phys_east);  totalUrgCare.add(fast_gville);  totalUrgCare.add(fast_golds);  totalUrgCare.add(immed_golds);  totalUrgCare.add(health_first);  totalUrgCare.add(medfirst_nb);  totalUrgCare.add(first_emerald);  totalUrgCare.add(wilson_imm); totalUrgCare.add(fast_mcity);  totalUrgCare.add(medfirst_swan);  totalUrgCare.add(chcc);  totalUrgCare.add(fast_med_kinston);  totalUrgCare.add(beach);  totalUrgCare.add(gville_health); totalUrgCare.add(down_east); totalUrgCare.add(quicker); totalUrgCare.add(carolinas);
        medicareMedicaid.add(phys_east);  medicareMedicaid.add(fast_gville);  medicareMedicaid.add(fast_golds);  medicareMedicaid.add(immed_golds);  medicareMedicaid.add(health_first);  medicareMedicaid.add(medfirst_nb);  medicareMedicaid.add(first_emerald);  medicareMedicaid.add(wilson_imm); medicareMedicaid.add(fast_mcity);  medicareMedicaid.add(medfirst_swan);  medicareMedicaid.add(chcc);  medicareMedicaid.add(fast_med_kinston);  medicareMedicaid.add(beach);  medicareMedicaid.add(gville_health);
        medicareOnly.add(down_east); medicareOnly.add(quicker);
        onlineCare.add(fast_gville); onlineCare.add(fast_golds); onlineCare.add(health_first); onlineCare.add(medfirst_nb); onlineCare.add(first_emerald); onlineCare.add(chcc); onlineCare.add(fast_med_kinston);

        checkAndUncheck(urgentCare, totalUrgCare);
        checkAndUncheck(medicare_medicaid_check, medicareMedicaid);
        checkAndUncheck(medicare_only_check, medicareOnly);
        checkAndUncheck(online_care_check, onlineCare);

        // Free/Charitable Clinics of NC
        LatLng comm_crossroads_clinic = new LatLng(35.604840, -77.387980);
        LatLng pitt_county_care_clinic = new LatLng(35.637310, -77.363600);
        LatLng watch_healthcare = new LatLng(35.398628, -77.952431); // Must be uninsured and from Wayne County
        LatLng merci_clinic = new LatLng(35.111290, -77.068900); // Must be Craven/Jones/Pamlico, uninsured, within 250% poverty level
        LatLng catholic_charities = new LatLng(35.109700, -77.039080); // Check elibility
        LatLng hope_clinic = new LatLng(35.143780, -76.770460);
        LatLng caring_comm_clinic = new LatLng(34.762010, -77.379850);
        LatLng broad_st_clinic = new LatLng(34.732820, -76.753220);
        LatLng healthnet_albe = new LatLng(36.311350, -76.221710);
        LatLng comm_clinic_dare = new LatLng(35.976950, -75.648470);
        LatLng cape_fear_clinic = new LatLng(34.206010, -77.927000);

        Marker comm_crossroads = mMap.addMarker(new MarkerOptions()
                .position(comm_crossroads_clinic)
                .title("Community Crossroads Clinic")
                .snippet("For all"));
        comm_crossroads.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));

        Marker pitt_county_care = mMap.addMarker(new MarkerOptions()
                        .position(pitt_county_care_clinic).title("Pitt County Care Clinic")
                        .snippet("Uninsured patients"));
        pitt_county_care.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker watch_health = mMap.addMarker(new MarkerOptions()
                        .position(watch_healthcare).title("WATCH Campus Clinic")
                        .snippet("Uninsured Wayne County residents"));
        watch_health.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker merci = mMap.addMarker(new MarkerOptions()
                        .position(merci_clinic).title("MERCI Clinic")
                        .snippet("Restrictions apply, check eligibility"));
        merci.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker catholic = mMap.addMarker(new MarkerOptions()
                        .position(catholic_charities).title("Catholic Charities of the Diocese of Raleigh/New Bern")
                        .snippet("Ages 60+, Chronic Health Condition, No private insurance/Medicaid"));
        catholic.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker hope = mMap.addMarker(new MarkerOptions()
                        .position(hope_clinic).title("Hope Clinic")
                        .snippet("Restrictions apply, check eligibility"));
        hope.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker caring_comm = mMap.addMarker(new MarkerOptions()
                        .position(caring_comm_clinic).title("Caring Community Clinic")
                        .snippet("Restrictions apply, must first become eligible"));
        caring_comm.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker broad_st = mMap.addMarker(new MarkerOptions()
                        .position(broad_st_clinic).title("Broad Street Clinic Foundation")
                        .snippet("Restrictions apply, must first become eligible"));
        broad_st.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker albemarle = mMap.addMarker(new MarkerOptions()
                        .position(healthnet_albe).title("HealthNet Albemarle")
                        .snippet("Restrictions apply, some fees"));
        albemarle.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker comm_dare = mMap.addMarker(new MarkerOptions()
                        .position(comm_clinic_dare).title("Community Care Clinic of Dare")
                        .snippet("Restrictions apply, must first become eligible"));
        comm_dare.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));
        Marker cape_fear = mMap.addMarker(new MarkerOptions()
                        .position(cape_fear_clinic).title("Cape Fear Clinic")
                        .snippet("Uninsured patients, limited walk-ins"));
        cape_fear.setIcon(BitmapDescriptorFactory.fromBitmap(charitable_icon));

        totalFreeCharitable.add(comm_crossroads); totalFreeCharitable.add(pitt_county_care); totalFreeCharitable.add(watch_health); totalFreeCharitable.add(merci); totalFreeCharitable.add(catholic); totalFreeCharitable.add(hope); totalFreeCharitable.add(caring_comm); totalFreeCharitable.add(broad_st); totalFreeCharitable.add(albemarle); totalFreeCharitable.add(comm_dare); totalFreeCharitable.add(cape_fear);
        freePharmacyServices.add(comm_crossroads); freePharmacyServices.add(pitt_county_care); freePharmacyServices.add(merci); freePharmacyServices.add(hope); freePharmacyServices.add(broad_st); freePharmacyServices.add(albemarle); freePharmacyServices.add(cape_fear);
        freeSocialServices.add(comm_crossroads); freeSocialServices.add(pitt_county_care);
        freeLabServices.add(pitt_county_care); freeLabServices.add(watch_health); freeLabServices.add(merci); freeLabServices.add(hope); freeLabServices.add(comm_dare);
        freePrimaryCare.add(merci); freePrimaryCare.add(hope); freePrimaryCare.add(albemarle); freePrimaryCare.add(comm_dare); freePrimaryCare.add(cape_fear);
        bilingualStaff.add(merci); bilingualStaff.add(watch_health); bilingualStaff.add(pitt_county_care); bilingualStaff.add(comm_crossroads); bilingualStaff.add(hope); bilingualStaff.add(albemarle); bilingualStaff.add(comm_dare); bilingualStaff.add(cape_fear);

        checkAndUncheck(freeCharitable, totalFreeCharitable);
        checkAndUncheck(pharm_check, freePharmacyServices);
        checkAndUncheck(social_services_check, freeSocialServices);
        checkAndUncheck(lab_services_check, freeLabServices);
        checkAndUncheck(primary_check, freePrimaryCare);
        checkAndUncheck(bilingual_check, bilingualStaff);

        // Uninsured, Sliding Scale (Greene Co.)
        LatLng reynolds_medical_center = new LatLng(35.453640, -77.682160);
        LatLng bernstein_chc_dental = new LatLng(35.652750, -77.370190);
        LatLng pamlico_chc_dental = new LatLng(35.142510, -76.772680);
        LatLng greene_dental = new LatLng(35.453900, -77.681460);
        LatLng snow_hill_integrated = new LatLng(35.441560, -77.660590);

        Marker reynolds_mc = mMap.addMarker(new MarkerOptions()
                        .position(reynolds_medical_center).title("Kate B Reynolds Medical Center")
                        .snippet("Specialized in pediatric, obstertrics, family medicine, behavioral health"));
        reynolds_mc.setIcon(BitmapDescriptorFactory.fromBitmap(sliding_scale_icon));
        Marker bernstein = mMap.addMarker(new MarkerOptions()
                        .position(bernstein_chc_dental).title("James D. Bernstein Community Health Center + Dental")
                        .snippet("Specialized in pediatric, adult, family medicine, behavioral health"));
        bernstein.setIcon(BitmapDescriptorFactory.fromBitmap(sliding_scale_icon));
        Marker pamlico = mMap.addMarker(new MarkerOptions()
                        .position(pamlico_chc_dental).title("Pamlico Community Health Center + Dental")
                        .snippet("Specialized in pediatric, family medicine, behavioral health"));
        pamlico.setIcon(BitmapDescriptorFactory.fromBitmap(sliding_scale_icon));
        Marker snow_hill = mMap.addMarker(new MarkerOptions()
                        .position(snow_hill_integrated).title("Snow Hill Integrated Care Services")
                        .snippet("Specialized in adult, family medicine, behavioral health"));
        snow_hill.setIcon(BitmapDescriptorFactory.fromBitmap(sliding_scale_icon));
        Marker greene = mMap.addMarker(new MarkerOptions()
                        .position(greene_dental).title("Greene Dental Services")
                        .snippet("Specialized in pediatric and adult dental care"));
        greene.setIcon(BitmapDescriptorFactory.fromBitmap(sliding_scale_icon));

        totalSlidingScale.add(reynolds_mc); totalSlidingScale.add(bernstein); totalSlidingScale.add(pamlico); totalSlidingScale.add(snow_hill); totalSlidingScale.add(greene);
        pediatricCare.add(reynolds_mc); pediatricCare.add(bernstein); pediatricCare.add(pamlico); pediatricCare.add(greene);
        adultCare.add(bernstein); adultCare.add(snow_hill); adultCare.add(greene);
        familyMedicine.add(reynolds_mc); familyMedicine.add(bernstein); familyMedicine.add(pamlico); familyMedicine.add(snow_hill);
        behavioralCare.add(reynolds_mc); behavioralCare.add(bernstein); behavioralCare.add(pamlico); behavioralCare.add(snow_hill);
        dentalCare.add(bernstein); dentalCare.add(pamlico); dentalCare.add(greene);

        checkAndUncheck(slidingScale, totalSlidingScale);
        checkAndUncheck(pediatric_check, pediatricCare);
        checkAndUncheck(adult_check, adultCare);
        checkAndUncheck(fam_medicine_check, familyMedicine);
        checkAndUncheck(behavioral_check, behavioralCare);
        checkAndUncheck(dental_check, dentalCare);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ecu_health_mc));
    }

    private void checkAndUncheck(CheckBox checker, ArrayList<Marker> category) {
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = checker.isChecked();
                if (!checked) {
                    for (Marker marker : category) {
                        marker.setVisible(false);
                    }
                } else {
                    for (Marker marker : category) {
                        marker.setVisible(true);
                    }
                }
            }
        });

    }

}