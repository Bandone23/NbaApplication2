package com.example.bescalona.nbaapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazLogin;
import com.example.bescalona.nbaapplication.Presentador.PresentadorLogin;

public class LoginActivity extends AppCompatActivity  implements InterfazLogin.Vista {

    private EditText email,password;
    private ProgressBar progressBar;
    private InterfazLogin.Presentador presentador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setview();

    }
    private void setview() {
        presentador= new PresentadorLogin(this);
        email = findViewById(R.id.txtcorreo);
        password = findViewById(R.id.txtpass);
        progressBar =findViewById(R.id.progressBar);

   }
    public void menu(View view){

        if (TextUtils.isEmpty(password.getText().toString()) && (TextUtils.isEmpty(email.getText().toString()))){

            Toast.makeText(this,"Por favor complete los campos ",Toast.LENGTH_LONG).show();

        }else {
            presentador.inicioSesion(email.getText().toString(),password.getText().toString());
            // Toast.makeText(this ,"has realizado el login correctamente",Toast.LENGTH_SHORT).show();
        }
    }

   @Override
    public void ocultaProgress() {progressBar.setVisibility(View.GONE);}

    @Override
    public void muestraProgress() {progressBar.setVisibility(View.VISIBLE);}

    @Override
    public void toastSi() {
        Toast.makeText(this,"Sesion iniciada correctamente",Toast.LENGTH_LONG).show();
         Intent i  = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void toastNo() {Toast.makeText(this,"Error en el inicio de session ",Toast.LENGTH_LONG).show();}

    public void   aregistro (View view){
        Intent i  = new Intent(this,RegistroActivity.class);
        startActivity(i);
    }








}
