package com.example.eva_1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class DataFragment extends Fragment {


    TextView txtVwDatos;
    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main=(MainActivity)getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout=(LinearLayout) inflater.inflate(R.layout.fragment_data, container);
        Button btnDatos=linearLayout.findViewById(R.id.btnData);
        txtVwDatos= linearLayout.findViewById(R.id.txtVwDatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            main.onMessageFromFragToMain("DATA", "MENSAJE DEL FRAGMENTO DE DATOS");
            }
        });
        return linearLayout;
    }
    public void onMessageFromMainToFrag(String param){
        txtVwDatos.setText(param);
    }
}
