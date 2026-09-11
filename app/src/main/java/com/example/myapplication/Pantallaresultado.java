package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantallaresultado extends AppCompatActivity {
    TextView txtresultado;

    Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantallaresultado);
        btnvolver = findViewById(R.id.btnvolver);

        TextView txtresultado = findViewById(R.id.txtResultado);

        double total = getIntent().getDoubleExtra("total", 0);

        txtresultado.setText(String.valueOf(total));

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }

            private void volver() {
                finish();;
            }
        });

    }



}