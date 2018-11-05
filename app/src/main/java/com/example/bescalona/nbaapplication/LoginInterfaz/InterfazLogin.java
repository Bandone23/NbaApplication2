package com.example.bescalona.nbaapplication.LoginInterfaz;
public interface InterfazLogin {

    interface Vista{
        void ocultaProgress();
        void muestraProgress();
        void toastSi();
        void toastNo();



    }


    interface  Presentador {
        void inicioSesion(String email,String password);
    }

    interface Modelo {
        void  hacerSesion(String email,String password);
            }

    interface  Avisos {

        void Ok();

        void Error();



    }
}
