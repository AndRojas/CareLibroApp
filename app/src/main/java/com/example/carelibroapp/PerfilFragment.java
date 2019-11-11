package com.example.carelibroapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private TextView nombreCompleto_perfil;
    private TextView genero_perfil;
    private TextView telefono_perfil;
    private TextView email_perfil;
    private TextView fechaNac_perfil;
    private TextView ciudad_perfil;
    private ImageView foto_perfil;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;// ...
    private FirebaseUser userFB;

    private User user;
    String userUID;


    private OnFragmentInteractionListener mListener;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        userFB = mAuth.getCurrentUser();

        userUID = userFB.getUid();

        inicializarFirebase();


        user = new User();

        //mAuth.signOut();



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }




    private void inicializarFirebase() {
        //FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void cargarUsuario(){

        databaseReference.child("Users").child("DatosPerfil").child(userUID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                user.setId(dataSnapshot.child("id").getValue().toString());


                user.setNombre(dataSnapshot.child("nombre").getValue().toString());
                user.setEmail(dataSnapshot.child("email").getValue().toString());
                user.setCiudad(dataSnapshot.child("ciudad").getValue().toString());
                user.setFechaNac(dataSnapshot.child("fechaNac").getValue().toString());
                user.setGenero(dataSnapshot.child("genero").getValue().toString());
                user.setTelefono(dataSnapshot.child("telefono").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);


        nombreCompleto_perfil = v.findViewById(R.id.nombreCompleto_FP);
        ciudad_perfil = v.findViewById(R.id.ciudad_FP);
        genero_perfil = v.findViewById(R.id.genero_FP);
        telefono_perfil = v.findViewById(R.id.telefono_FP);
        email_perfil = v.findViewById(R.id.email_FP);
        fechaNac_perfil = v.findViewById(R.id.nacimiento_FP);
        foto_perfil = v.findViewById(R.id.fotoPerfil_FP);

        cargarUsuario();

        foto_perfil.setImageURI(userFB.getPhotoUrl());
        nombreCompleto_perfil.setText(user.getNombre());
        email_perfil.setText(user.getEmail());
        ciudad_perfil.setText(user.getCiudad());
        genero_perfil.setText(user.getGenero());
        telefono_perfil.setText(user.getTelefono());
        fechaNac_perfil.setText(user.getFechaNac());


        return v;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
