package com.example.bescalona.nbaapplication.Presentador;



import com.example.bescalona.nbaapplication.Interfaz.MvpStepsLogin;
import com.example.bescalona.nbaapplication.Modelo.ModeloLogin;

public class PresentadorLogin implements MvpStepsLogin.Presentador,MvpStepsLogin.Avisos {
   private  MvpStepsLogin.Vista vista;
   private  MvpStepsLogin.Modelo modelo;


// ...
    public PresentadorLogin(MvpStepsLogin.Vista vista) {
        this.vista = vista;
        modelo =new ModeloLogin(this);
  }

  @Override
    public void Ok() {
       vista.messageYes();
       vista.hideProgress();
    }
    @Override
    public void Error() {
       vista.messagedoNot();
       vista.hideProgress();
    }

    @Override
    public void sendLogin(String email, String password) {
        vista.watchProgress();
        modelo.logIn(email, password);
    }
}
