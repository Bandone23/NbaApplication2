package com.example.bescalona.nbaapplication;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class SeleccionComunaActivity extends AppCompatActivity {

    private TextView mensajeTextView;
    private EditText mensajeEditText;




    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensajeRef = ref.child("mensaje");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_comuna);

        mensajeTextView= (TextView) findViewById(R.id.mensajeTextView);
        mensajeEditText= (EditText) findViewById(R.id.mensajeEditText);





    }


    @Override
    protected  void onStart() {
        super.onStart();

        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value= dataSnapshot.getValue(String.class);

                mensajeTextView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void modificar(View view) {
        String mensaje= mensajeEditText.getText().toString();
        mensajeRef.setValue(mensaje);

        mensajeEditText.setText("");

    }
}
