package com.example.carelibroapp;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.carelibroapp.ui.main.SectionsPagerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.carelibroapp.PerfilFragment;
public class TimeLineActivity extends AppCompatActivity implements PerfilFragment.OnFragmentInteractionListener {


    private EditText nombreCompleto_perfil;
    private EditText genero_perfil;
    private EditText telefono_perfil;
    private EditText email_perfil;
    private EditText fechaNac_perfil;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;// ...
    private FirebaseUser userFB;

    private User user;
    String userUID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        userFB = mAuth.getCurrentUser();

        inicializarFirebase();


        Bundle extras = getIntent().getExtras();
        userUID = extras.getString("userID");

        cargarUsuario();

        user = new User();








    }

    private void cargarUsuario() {
        Log.d("MENSAJEEEEEEEEEE",userUID);
        Log.d("OTRO",userFB.getPhotoUrl().toString());

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}