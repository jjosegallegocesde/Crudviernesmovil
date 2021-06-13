package com.example.crudviernes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Usuario> listadeTrabajadores= new ArrayList<>();
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //


    }
}