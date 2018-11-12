package com.example.bescalona.nbaapplication.Modelo;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.bescalona.nbaapplication.Interfaz.MvpStepsLogin;
import com.example.bescalona.nbaapplication.Presentador.PresentadorLogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ModeloLogin implements MvpStepsLogin.Modelo {

    private MvpStepsLogin.Avisos avisos;
    private FirebaseAuth auth;
    private static final String TAG = "EmailPassword";

    public ModeloLogin(PresentadorLogin presentadorLogin) {
    }

    @Override
    public void logIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Inicio de session Ok");
                    FirebaseUser user = auth.getCurrentUser();
                    avisos.Ok();


                } else {
                    Log.w(TAG, "Fallo el Inicio de sesion", task.getException());
                    avisos.Error();

                }
            }
        });
        
    }
}


