package com.example.mednavi;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mednavi.databinding.ActivityGoogleResourceMapBinding;

public class GoogleResourceMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGoogleResourceMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGoogleResourceMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
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

    private Bitmap resize(Drawable image){
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        //return new BitmapDrawable(getResources(), bitmapResized);
        return bitmapResized;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bitmap hospital_icon = resize(getDrawable(R.drawable.hospital_icon));
        Bitmap uc_icon = resize(getDrawable(R.drawable.urgent_care));

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
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_mc).title("ECU Health Medical Center")
                        .snippet("2100 Stantonsburg Rd, Greenville, NC 27834 \n (252)-975-4100"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_beaufort).title("ECU Health Beaufort Hospital")
                        .snippet("628 E 12th St, Washington, NC 27889 \n (252)-975-4100"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_bertie).title("ECU Health Bertie Hospital")
                        .snippet("1403 S King St, Windsor, NC, 27983 \n (252)-794-6600"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_chowan).title("ECU Health Chowan Hospital")
                        .snippet("211 Virginia Rd, Edenton, NC, 27932 \n (252)-482-8451"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_duplin).title("ECU Health Duplin Hospital")
                        .snippet("401 N. Main St, Kenansville, NC, 28349 \n (910)-296-0941"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_edge).title("ECU Health Edgecombe Hospital")
                        .snippet("111 Hospital Dr, Tarboro, NC, 27886 \n (252)-641-7700"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_north).title("ECU Health North Hospital")
                        .snippet("250 Smith Church Rd, Roanoke Rapids, NC, 27870 \n (252)-535-8011"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_roanoke).title("ECU Health Roanoke-Chowan Hospital")
                        .snippet("500 S Academy St, Ahoskie, NC, 27910 \n (252)-209-3000"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(ecu_health_obx).title("The Outer Banks Hospital")
                        .snippet("4800 S Croatan Hwy, Nags Head, NC, 27959 \n (252)-449-4500"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(hospital_icon));

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
        LatLng med_first_nb = new LatLng(35.034490, -77.012890);
        LatLng cchc_urg = new LatLng(35.105410, -77.092670);
        LatLng quicker_care = new LatLng(34.859530, -76.897620);
        LatLng carolinas_urg = new LatLng(34.730450, -76.775980);
        LatLng beach_care = new LatLng(34.735890, -76.798590);
        LatLng gville_hc = new LatLng(35.598770, -77.334970);

        mMap.addMarker(new MarkerOptions()
                        .position(phys_east_urg).title("Physicians East Urgent Care and Sleep Center")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(urg_down_east).title("Urgent Care Down East")
                        .snippet("Medicare accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_gville).title("FastMed Urgent Care - Greenville")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_golds).title("FastMed Urgent Care - Goldsboro")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(imm_care_golds).title("Immediate Care of Goldsboro")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(healthfirst_primary).title("HealthFirst Primary and Urgent Care")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(med_first_emerald).title("Med First Primary & Urgent Care - Emerald Isle")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(med_first_nb).title("Med First Primary & Urgent Care - New Bern")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(wilson_immed).title("Wilson Immediate Care")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_mcity).title("FastMed Urgent Care - Morehead City")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(med_first_swans).title("Med First Primary & Urgent Care - Swansboro")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(cchc_urg).title("CCHC Urgent Care")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(fastmed_urg_kinston).title("FastMed Urgent Care - Kinston")
                        .snippet("Medicare/Medicaid accepted, Online Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(med_first_newbern).title("Med First Primary and Urgent Care - New Bern")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(quicker_care).title("Quicker Care")
                        .snippet("Medicare accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(carolinas_urg).title("Carolinas Urgent and Primary Care"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(beach_care).title("BeachCare Urgent & Family Medical Center")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));
        mMap.addMarker(new MarkerOptions()
                        .position(gville_hc).title("Greenville Health Care")
                        .snippet("Medicare/Medicaid accepted"))
                .setIcon(BitmapDescriptorFactory.fromBitmap(uc_icon));

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

        // Uninsured, Sliding Scale (Greene Co.)
        LatLng reynolds_medical_center = new LatLng(35.453640, -77.682160);
        LatLng bernstein_chc_dental = new LatLng(35.652750, -77.370190);
        LatLng pamlico_chc_dental = new LatLng(35.142510, -76.772680);
        LatLng greene_dental = new LatLng(35.453900, -77.681460);
        LatLng snow_hill_integrated = new LatLng(35.441560, -77.660590);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ecu_health_mc));
    }
}