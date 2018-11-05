package com.example.bescalona.nbaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazLogin;
import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazRegistro;
import com.example.bescalona.nbaapplication.Presentador.PresentadorLogin;
import com.example.bescalona.nbaapplication.Presentador.PresentadorRegistro;

public class RegistroActivity extends AppCompatActivity  implements InterfazRegistro.Vista {

    private EditText email,password;

    private InterfazRegistro.Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setview();
    }



    private void setview() {
        presentador= new PresentadorRegistro(this);
        email = findViewById(R.id.txtcorreo);
        password = findViewById(R.id.txtpass);


    }


  public  void nuevousuario(View view){
        oknUsuario();

    }

    @Override
    public void oknUsuario() {
        if (TextUtils.isEmpty(password.getText().toString()) && (TextUtils.isEmpty(email.getText().toString()))){

            Toast.makeText(this,"Por favor complete los campos ",Toast.LENGTH_LONG).show();

        }else {
            presentador.NuevoUsuario(email.getText().toString(),password.getText().toString());

        }
    }

    @Override
    public void toastSi() {

        Toast.makeText(this,"Usuario Registrado Correctamente ",Toast.LENGTH_LONG).show();



    }

    @Override
    public void toastNo() {

        Toast.makeText(this,"Ocurrio Un problema en el registro ",Toast.LENGTH_LONG).show();

    }
}




