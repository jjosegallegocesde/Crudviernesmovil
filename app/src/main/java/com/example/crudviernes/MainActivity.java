package com.example.crudviernes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS

    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    EditText cajaNombre,cajaEdad;
    Button botonRegistrar;
    Map<String, Object> usuario = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaNombre=findViewById(R.id.nombre);
        cajaEdad=findViewById(R.id.edad);
        botonRegistrar=findViewById(R.id.registrar);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1. Capturo los valores a registrar
                String nombre=cajaNombre.getText().toString();
                String edad=cajaEdad.getText().toString();

                //2. Llenar el objeto a enviar a BD
                usuario.put("nombre",nombre);
                usuario.put("edad",edad);

                //3. Llamar a la funcion registrarUsuario
                registarUsuario();
            }
        });

    }

    public void registarUsuario(){

        baseDatos.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(MainActivity.this, "Exito", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(MainActivity.this, "Error "+e, Toast.LENGTH_SHORT).show();

                    }
                });

    }

}