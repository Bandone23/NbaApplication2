package com.example.bescalona.nbaapplication.Presentador;



import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazLogin;
import com.example.bescalona.nbaapplication.Modelo.ModeloLogin;

public class PresentadorLogin implements InterfazLogin.Presentador,InterfazLogin.Avisos {
   private  InterfazLogin.Vista vista;
   private  InterfazLogin.Modelo modelo;


// ...
    public PresentadorLogin(InterfazLogin.Vista vista) {
        this.vista = vista;
        modelo =new ModeloLogin(this);
  }
    @Override
    public void inicioSesion(String email, String password) {
        vista.muestraProgress();
        modelo.hacerSesion(email, password);

    }
    @Override
    public void Ok() {
       vista.toastSi();
       vista.ocultaProgress();
    }
    @Override
    public void Error() {
       vista.toastNo();
       vista.ocultaProgress();
    }
}
