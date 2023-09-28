package com.example.calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.function.Function;

import kotlin.jvm.internal.Lambda;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.calculadora.MESSAGE";
    double memoria = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializar
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.color_default));


        //Primeira linha de botões
        ImageButton btnSoma = (ImageButton)this.findViewById(R.id.btnSoma);
        ImageButton btnSubtracao = (ImageButton)this.findViewById(R.id.btnSubtracao);
        ImageButton btnDivisao = (ImageButton)this.findViewById(R.id.btnDivisao);
        ImageButton btnMultiplicacao = (ImageButton)this.findViewById(R.id.btnMultiplicacao);

        //Segunda linha de botões
        ImageButton btnMmenos = (ImageButton)this.findViewById(R.id.btnMMenos);
        ImageButton btnMmais = (ImageButton)this.findViewById(R.id.btnMMais);
        ImageButton btnMR= (ImageButton)this.findViewById(R.id.btnMR);
        ImageButton btnMC= (ImageButton)this.findViewById(R.id.btnMC);

        //Terceira linha de botões
        ImageButton btnMX = (ImageButton)this.findViewById(R.id.btnMX);

        //EditText's
        EditText txtNumberV1 = (EditText)this.findViewById(R.id.txtNumberV1);
        EditText txtNumberV2 = (EditText)this.findViewById(R.id.txtNumberV2);
        EditText txtNumberResultado = (EditText)this.findViewById(R.id.txtNumberResultado);

        //TextView's
        TextView txtMemoria = (TextView)this.findViewById(R.id.txtMemoria);


        Button btnFinalizar = (Button)this.findViewById(R.id.btnFinalizar);

        //Preparar
        btnMC.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.cinsa));
        btnMR.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this,R.color.cinsa));



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);

                double calc = 0;

                if(txtNumberV1.getText().toString().equals("") || txtNumberV2.getText().toString().equals("")){
                    if(txtNumberResultado.getText().toString().equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Campos vazios!");
                        builder.setMessage("Ao menos dois campos devem estar preenchidos!");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtNumberV1.requestFocus();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return;
                    }else{
                        if(txtNumberV1.getText().toString().equals("")){
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }else{
                            txtNumberV2.setText(txtNumberV1.getText().toString());
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }
                    }
                }

                calc = Double.parseDouble(txtNumberV1.getText().toString()) + Double.parseDouble(txtNumberV2.getText().toString());

                txtNumberResultado.setText(formatNumber(calc));
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(),0);

                double calc = 0;

                if(txtNumberV1.getText().toString().equals("") || txtNumberV2.getText().toString().equals("")){
                    if(txtNumberResultado.getText().toString().equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Campos vazios!");
                        builder.setMessage("Ao menos dois campos devem estar preenchidos!");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtNumberV1.requestFocus();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return;
                    }else{
                        if(txtNumberV1.getText().toString().equals("")){
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }else{
                            txtNumberV2.setText(txtNumberV1.getText().toString());
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }
                    }
                }

                calc = Double.parseDouble(txtNumberV1.getText().toString()) - Double.parseDouble(txtNumberV2.getText().toString());

                txtNumberResultado.setText(formatNumber(calc));
            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(),0);

                double calc = 0;

                if(txtNumberV1.getText().toString().equals("") || txtNumberV2.getText().toString().equals("")){
                    if(txtNumberResultado.getText().toString().equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Campos vazios!");
                        builder.setMessage("Ao menos dois campos devem estar preenchidos!");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtNumberV1.requestFocus();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return;
                    }else{
                        if(txtNumberV1.getText().toString().equals("")){
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }else{
                            txtNumberV2.setText(txtNumberV1.getText().toString());
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }
                    }
                }

                calc = Double.parseDouble(txtNumberV1.getText().toString()) / Double.parseDouble(txtNumberV2.getText().toString());

                txtNumberResultado.setText(formatNumber(calc));
            }
        });

        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(),0);

                double calc = 0;

                if(txtNumberV1.getText().toString().equals("") || txtNumberV2.getText().toString().equals("")){
                    if(txtNumberResultado.getText().toString().equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Campos vazios!");
                        builder.setMessage("Ao menos dois campos devem estar preenchidos!");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                txtNumberV1.requestFocus();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        return;
                    }else{
                        if(txtNumberV1.getText().toString().equals("")){
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }else{
                            txtNumberV2.setText(txtNumberV1.getText().toString());
                            txtNumberV1.setText(txtNumberResultado.getText().toString());
                        }
                    }
                }

                calc = Double.parseDouble(txtNumberV1.getText().toString()) * Double.parseDouble(txtNumberV2.getText().toString());
                txtNumberResultado.setText(formatNumber(calc));
            }
        });

        //btnM+
        btnMmais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (!txtNumberResultado.getText().toString().equals("")) {
                    memoria += Double.parseDouble(txtNumberResultado.getText().toString());
                    if (memoria > 0) {
                        txtMemoria.setVisibility(view.VISIBLE);
                        btnMC.setClickable(true);
                        btnMR.setClickable(true);
                        btnMC.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.color_default2));
                        btnMR.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.color_default2));

                        txtMemoria.setText("Memória: " + formatNumber(memoria));
                    }
                }
            }
        });

        //btnM-
        btnMmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (!txtNumberResultado.getText().toString().equals("")) {
                    memoria -= Double.parseDouble(txtNumberResultado.getText().toString());
                    txtMemoria.setVisibility(view.VISIBLE);
                    btnMC.setClickable(true);
                    btnMR.setClickable(true);
                    btnMC.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.color_default2));
                    btnMR.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.color_default2));

                    txtMemoria.setText("Memória: " + formatNumber(memoria));
                }
            }
        });

        //btnMR
        btnMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(),0);

                txtNumberV1.setText(formatNumber(memoria));
            }
        });

        //btnMC
        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(),0);

                memoria = 0;
                btnMC.setClickable(false);
                btnMR.setClickable(false);
                btnMC.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.cinsa));
                btnMR.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this,R.color.cinsa));
                txtMemoria.setVisibility(view.INVISIBLE);
            }
        });

        //btnMX
        btnMX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityMemoria.class);
                intent.putExtra(EXTRA_MESSAGE,memoria);
                startActivity(intent);
            }
        });

    }

    public static String formatNumber(double value){
        if(value%1 == 0){
            return String.format("%.0f",value);
        }else {
            DecimalFormat formatter = new DecimalFormat("#.#########");
            return formatter.format(value);
        }
    }

    public void hideKeyboard(View view){
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}