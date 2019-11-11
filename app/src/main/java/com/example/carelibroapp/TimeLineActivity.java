package com.example.carelibroapp;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.carelibroapp.ui.main.SectionsPagerAdapter;

public class TimeLineActivity extends AppCompatActivity implements PerfilFragment.OnFragmentInteractionListener {


    private TextView nombreCompleto_perfil;
    private TextView genero_perfil;
    private TextView telefono_perfil;
    private TextView email_perfil;
    private TextView fechaNac_perfil;


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

        nombreCompleto_perfil = findViewById(R.id.nombreCompleto_FP);
        genero_perfil = findViewById(R.id.genero_FP);
        telefono_perfil = findViewById(R.id.telefono_FP);
        email_perfil = findViewById(R.id.email_FP);
        fechaNac_perfil = findViewById(R.id.nacimiento_FP);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}