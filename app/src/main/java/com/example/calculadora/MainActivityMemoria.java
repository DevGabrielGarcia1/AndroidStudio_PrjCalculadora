package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityMemoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memoria);

        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.color_default));

        Button btnVoltar = (Button)this.findViewById(R.id.btnVoltar);
        TextView txtMemoria = (TextView)this.findViewById(R.id.txtMemoria);

        Intent intent = getIntent();

        double memoria = intent.getDoubleExtra(MainActivity.EXTRA_MESSAGE,0);

        txtMemoria.setText("Memória: " + MainActivity.formatNumber(memoria));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}