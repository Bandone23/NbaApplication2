package com.example.bescalona.nbaapplication.Interfaz;

public interface MvpStepsRegister {

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
