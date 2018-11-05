package com.example.bescalona.nbaapplication.Modelo;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazLogin;
import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazRegistro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;

public class ModeloRegistro  implements InterfazRegistro.Modelo {

    private InterfazRegistro.Avisos avisos;
    private FirebaseAuth auth;
    private static final String TAG = "EmailPassword";

    private DatabaseReference bd;
  private FirebaseDatabase firebaseDatabase;





    public ModeloRegistro(InterfazRegistro.Avisos avisos) {
        this.avisos = avisos;
        auth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
       bd =FirebaseDatabase.getInstance().getReference();
      bd.child("Usuarios");
    }

    @Override
    public void CreaSesion(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    //
                    Log.d(TAG, "Usuario Creado correctamente");
                    FirebaseUser user = auth.getCurrentUser();
                       avisos.Oknusuario();

                } else {
                    //
                    Log.w(TAG, "Error al crear el usario", task.getException());
                    avisos.Errornsuaurio();
                }


            }
        });

    }

}
