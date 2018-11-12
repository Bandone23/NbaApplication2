package com.example.bescalona.nbaapplication.Interfaz;
public interface MvpStepsLogin {

    interface Vista{
        void watchProgress();
        void hideProgress();
        void messageYes();
        void messagedoNot();



    }


    interface  Presentador {
        void sendLogin(String email,String password);
    }

    interface Modelo {
        void  logIn(String email,String password);
            }

    interface  Avisos {

        void Ok();

        void Error();



    }
}
