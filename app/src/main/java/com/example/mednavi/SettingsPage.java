package com.example.mednavi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class SettingsPage extends AppCompatActivity {

    TextView name, email, city;

    Button buttonLogOut;
    FirebaseAuth auth;
    FirebaseFirestore fStore;
    String userID;
    FirebaseUser user;
    ImageView mapsIcon;
    ImageView newsIcon;
    ImageView resourcesIcon;
    ImageView homeIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        mapsIcon = findViewById(R.id.maps_button);
        newsIcon = findViewById(R.id.news_button);
        resourcesIcon = findViewById(R.id.resources_button);
        homeIcon = findViewById(R.id.home_button);

        buttonLogOut = findViewById(R.id.logout_button);

        name = findViewById(R.id.settings_name);
        email = findViewById(R.id.settings_email);
        city = findViewById(R.id.settings_city);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        userID = auth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        ListenerRegistration nameSettings = documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                name.setText("Name: " + documentSnapshot.getString("fName"));
            }
        });
        ListenerRegistration emailSettings = documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                email.setText("Email: " + documentSnapshot.getString("email"));
            }
        });
        ListenerRegistration citySettings = documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                city.setText("City: " + documentSnapshot.getString("city"));
            }
        });


        newsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mapsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoogleResourceMap.class);
                startActivity(intent);
                finish();
            }
        });

        resourcesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResourcesPage.class);
                startActivity(intent);
                finish();
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameSettings.remove();
                emailSettings.remove();
                citySettings.remove();
                auth.signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}