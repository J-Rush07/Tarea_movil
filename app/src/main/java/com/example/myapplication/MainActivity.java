package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText edtcaja1,edtcaja2;


    Spinner spin;

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
        spin = findViewById(R.id.spin);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Procesos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);



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
            }else {

                int num1 = Integer.parseInt(caja1);
                int num2 = Integer.parseInt(caja2);


                double total = 0;
                String opspinner = spin.getSelectedItem().toString();
                switch (opspinner) {
                    case "+":
                        total = num1 + num2;
                        break;
                    case "-":
                        total = num1 - num2;
                        break;
                    case "*":
                        total = num1 * num2;
                        break;
                    case "/":
                        total = (num1 / num2);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "invalido", Toast.LENGTH_LONG).show();

                }


                Intent intent = new Intent(MainActivity.this, Pantallaresultado.class);
                intent.putExtra("total", total);
                startActivity(intent);







        }

    }



}