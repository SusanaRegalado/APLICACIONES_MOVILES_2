package com.example.eva_1_3_frag_din;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mostrarRojo(View v){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        FragmentRed fragmentRed= new FragmentRed();
        ft.replace(R.id.framLyt, fragmentRed);
        ft.commit();
    }
       public void mostrarAzul(View v){
           FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
           FragmentBlue fragmentBlue= new FragmentBlue();
           ft.replace(R.id.framLyt, fragmentBlue);
           ft.commit();
       }
}
