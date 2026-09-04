package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText edtcaja1,edtcaja2;

    TextView txtresultado;

    Button btncalculadora;

    Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtcaja1 = findViewById(R.id.edtcaja1);
        edtcaja2 = findViewById(R.id.edtcaja2);
        txtresultado = findViewById(R.id.txtResultado);
        limpiar = findViewById(R.id.limpiar);
        btncalculadora = findViewById(R.id.btncalculadora);


        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });


        btncalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    calculadora();
            }
        });
        }

    private void limpiar() {
        edtcaja1.setText("");
        edtcaja2.setText("");
        txtresultado.setText("0");
    }

    private void calculadora(){
            String caja1 = edtcaja1.getText().toString();
            String caja2 = edtcaja2.getText().toString();

            if (caja1.isEmpty() || caja2.isEmpty()) {
                Toast.makeText(MainActivity.this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
            }else{

                int num1 = Integer.parseInt(caja1);
                int num2 = Integer.parseInt(caja2);


                int resultado = num1 + num2;

                txtresultado.setText(resultado+"");




        }

    }
}