package com.example.bescalona.nbaapplication.LoginInterfaz;

public interface InterfazRegistro {

    interface Vista{
        void oknUsuario();
        void toastSi();
        void toastNo();


    }


    interface  Presentador {
        void NuevoUsuario(String email,String password);
    }

    interface Modelo {

        void  CreaSesion(String email,String password);



    }

    interface  Avisos {

        void Oknusuario();

        void Errornsuaurio();


    }
}
