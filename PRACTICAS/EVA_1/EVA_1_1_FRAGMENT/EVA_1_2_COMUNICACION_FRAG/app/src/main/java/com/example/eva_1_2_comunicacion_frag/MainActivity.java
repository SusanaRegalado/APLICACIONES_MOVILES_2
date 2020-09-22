package com.example.eva_1_2_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1. recuperar los fragmentos
    ListFragment lista;
    DataFragment datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //2. acceder a los fragmentos
    //hay un metodo que se ejecuta cuando un fragmento
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass()== ListFragment.class)
        lista=(ListFragment)fragment;
        else if(fragment.getClass()== DataFragment.class)
            datos = (DataFragment)fragment;
    }

    //INTERFAZ DE COMUNICACIÓN
   public void onMessageFromFragToMain(String sender, String param){
        if(sender.equals("LISTA")){//RECIBIR INFORMACION
           //ENVIAR AL FRAGMENTO
            datos.onMessageFromMainToFrag(param);
        }else if(sender.equals("DATA")){
            //IMPRIMIR MENSAJE
            Toast.makeText(this,param,Toast.LENGTH_LONG).show();
        }
   }
}
