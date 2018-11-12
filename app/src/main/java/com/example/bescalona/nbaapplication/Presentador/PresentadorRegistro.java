package com.example.bescalona.nbaapplication.Presentador;

import com.example.bescalona.nbaapplication.Interfaz.MvpStepsRegister;
import com.example.bescalona.nbaapplication.Modelo.ModeloRegistro;

public class PresentadorRegistro implements MvpStepsRegister.Presentador,MvpStepsRegister.Avisos {

    private  MvpStepsRegister.Vista vista;
    private  MvpStepsRegister.Modelo modelo;

    public PresentadorRegistro(MvpStepsRegister.Vista vista) {
        this.vista = vista;
        modelo =new ModeloRegistro(this);

    }

    @Override
    public void NuevoUsuario(String email, String password) {
        modelo.CreaSesion(email, password);

    }

    @Override
    public void Oknusuario() {
        vista.toastSi();


    }

    @Override
    public void Errornsuaurio() {
        vista.toastNo();

    }
}
