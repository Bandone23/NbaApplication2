package com.example.bescalona.nbaapplication.Presentador;

import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazLogin;
import com.example.bescalona.nbaapplication.LoginInterfaz.InterfazRegistro;
import com.example.bescalona.nbaapplication.Modelo.ModeloLogin;
import com.example.bescalona.nbaapplication.Modelo.ModeloRegistro;

public class PresentadorRegistro implements InterfazRegistro.Presentador,InterfazRegistro.Avisos {

    private  InterfazRegistro.Vista vista;
    private  InterfazRegistro.Modelo modelo;

    public PresentadorRegistro(InterfazRegistro.Vista vista) {
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
