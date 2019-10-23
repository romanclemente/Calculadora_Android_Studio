package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int opera;
    float valora, valorb, val;
    float resultado;
    boolean operar;
    boolean neg = false;
    boolean decimal = false;

    Button _1, _2, _3, _4, _5, _6, _7, _8, _9, _0;
    Button ac, masmenos, porcentaje, division, multiplicacion, resta, suma, igual, coma;
    Button cos, sin, tan, cosc, sec, cotan, raiz2, raiz3, log, potencia;
    TextView txtnumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            instanciar();
            acciones();
        } else {
            instanciarLandscape();
            accionesLandscape();
        }
    }

    //aqui instacion los botones cuando la pantalla en vertical
    public void instanciar() {
        txtnumer = findViewById(R.id.numer);
        _0 = findViewById(R.id.bt_0);
        _1 = findViewById(R.id.bt_1);
        _2 = findViewById(R.id.bt_2);
        _3 = findViewById(R.id.bt_3);
        _4 = findViewById(R.id.bt_4);
        _5 = findViewById(R.id.bt_5);
        _6 = findViewById(R.id.bt_6);
        _7 = findViewById(R.id.bt_7);
        _8 = findViewById(R.id.bt_8);
        _9 = findViewById(R.id.bt_9);

        ac = findViewById(R.id.acborrar);
        masmenos = findViewById(R.id.mameno);
        porcentaje = findViewById(R.id.porciento);
        division = findViewById(R.id.bt_division);
        multiplicacion = findViewById(R.id.bt_multiplicacion);
        resta = findViewById(R.id.bt_resta);
        suma = findViewById(R.id.bt_suma);
        igual = findViewById(R.id.bt_igualdad);
        coma = findViewById(R.id.bt_coma);
    }

    //instancio los botones y elementos cuando la pantalla esta en horizontal
    public void instanciarLandscape() {
        txtnumer = findViewById(R.id.numer);
        _0 = findViewById(R.id.bt_0);
        _1 = findViewById(R.id.bt_1);
        _2 = findViewById(R.id.bt_2);
        _3 = findViewById(R.id.bt_3);
        _4 = findViewById(R.id.bt_4);
        _5 = findViewById(R.id.bt_5);
        _6 = findViewById(R.id.bt_6);
        _7 = findViewById(R.id.bt_7);
        _8 = findViewById(R.id.bt_8);
        _9 = findViewById(R.id.bt_9);

        ac = findViewById(R.id.acborrar);
        masmenos = findViewById(R.id.mameno);
        porcentaje = findViewById(R.id.porciento);
        division = findViewById(R.id.bt_division);
        multiplicacion = findViewById(R.id.bt_multiplicacion);
        resta = findViewById(R.id.bt_resta);
        suma = findViewById(R.id.bt_suma);
        igual = findViewById(R.id.bt_igualdad);
        coma = findViewById(R.id.bt_coma);

        cos = findViewById(R.id.bt_cos);
        sin = findViewById(R.id.bt_sen);
        tan = findViewById(R.id.bt_tan);
        cosc = findViewById(R.id.bt_cosec);
        sec = findViewById(R.id.bt_sec);
        cotan = findViewById(R.id.bt_cotan);
        raiz2 = findViewById(R.id.bt_raiz2);
        raiz3 = findViewById(R.id.bt_raiz3);
        log = findViewById(R.id.bt_log);
        potencia = findViewById(R.id.bt_pote);

    }

    public void acciones() {

        _1.setOnClickListener(this);
        _0.setOnClickListener(this);
        _2.setOnClickListener(this);
        _3.setOnClickListener(this);
        _4.setOnClickListener(this);
        _5.setOnClickListener(this);
        _6.setOnClickListener(this);
        _7.setOnClickListener(this);
        _8.setOnClickListener(this);
        _9.setOnClickListener(this);

        ac.setOnClickListener(this);
        masmenos.setOnClickListener(this);
        porcentaje.setOnClickListener(this);
        division.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        resta.setOnClickListener(this);
        suma.setOnClickListener(this);
        igual.setOnClickListener(this);
        coma.setOnClickListener(this);
    }

    public void accionesLandscape() {
        _1.setOnClickListener(this);
        _0.setOnClickListener(this);
        _2.setOnClickListener(this);
        _3.setOnClickListener(this);
        _4.setOnClickListener(this);
        _5.setOnClickListener(this);
        _6.setOnClickListener(this);
        _7.setOnClickListener(this);
        _8.setOnClickListener(this);
        _9.setOnClickListener(this);

        ac.setOnClickListener(this);
        masmenos.setOnClickListener(this);
        porcentaje.setOnClickListener(this);
        division.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        resta.setOnClickListener(this);
        suma.setOnClickListener(this);
        igual.setOnClickListener(this);
        coma.setOnClickListener(this);

        cos.setOnClickListener(this);
        sin.setOnClickListener(this);
        tan.setOnClickListener(this);
        cotan.setOnClickListener(this);
        raiz2.setOnClickListener(this);
        cosc.setOnClickListener(this);
        sec.setOnClickListener(this);
        raiz3.setOnClickListener(this);
        log.setOnClickListener(this);
        potencia.setOnClickListener(this);


    }

    //y aqui le doy funcionalidad a los botones

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_coma:
                if (!decimal) {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + ".");
                    decimal = true;
                }
                break;
//esta accion cambia de signo el valor que haya en pantalla
            case R.id.mameno:
                if (!txtnumer.getText().equals("0")) {
                    if (!neg) {
                        String texto = String.valueOf(txtnumer.getText());
                        txtnumer.setText("-" + texto);
                        neg = true;
                    } else {
                        String texto = String.valueOf(txtnumer.getText());
                        String[] parts = texto.split("-");
                        txtnumer.setText(parts[1]);
                        neg = false;
                    }
                }
                break;
            case R.id.bt_0:

                if (!txtnumer.getText().equals("0")) {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "0");
                }
                break;
            case R.id.bt_1:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("1");
                } else {
                    txtnumer.setText(txtnumer.getText() + "1");
                }
                break;
            case R.id.bt_2:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("2");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "2");
                }
                break;

            case R.id.bt_3:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("3");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "3");
                }
                break;

            case R.id.bt_4:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("4");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "4");
                }
                break;

            case R.id.bt_5:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("5");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "5");
                }
                break;

            case R.id.bt_6:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("6");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "6");
                }
                break;

            case R.id.bt_7:


                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("7");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "7");
                }
                break;

            case R.id.bt_8:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("8");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "8");
                }
                break;

            case R.id.bt_9:
                if (txtnumer.getText().equals("0")) {
                    txtnumer.setText("9");
                } else {
                    String texto = String.valueOf(txtnumer.getText());
                    txtnumer.setText(texto + "9");
                }
                break;


            case R.id.bt_suma:
                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                    resultado = valora;
                }
                opera = 1;
                break;

            case R.id.bt_resta:

                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                    resultado = valora;
                }
                opera = 2;
                break;

            case R.id.bt_division:

                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                    resultado = valora;
                }
                opera = 3;
                break;

            case R.id.bt_multiplicacion:

                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                    resultado = valora;
                }
                opera = 4;
                break;

            case R.id.porciento:
                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                }
                opera = 5;
                break;

            //realiza raices cuadradas

            case R.id.bt_raiz2:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.sqrt(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;

//realiza raices cubicas
            case R.id.bt_raiz3:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.pow(valora, 1.0 / 3.0);
                    ;
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace la secante
            case R.id.bt_sec:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    double resul = 1.0 / (float) Math.sin(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace la cosecante
            case R.id.bt_cosec:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    double resul = 1.0 / (float) Math.cos(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace la cotangente
            case R.id.bt_cotan:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    double resul = 1.0 / (float) Math.tan(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace el coseno
            case R.id.bt_cos:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.cos(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
            //hace el seno
            case R.id.bt_sen:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.sin(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace la tangente
            case R.id.bt_tan:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.tan(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
            //hace el logaritmo en base 10
            case R.id.bt_log:
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    float resul = (float) Math.log10(valora);
                    txtnumer.setText(String.valueOf(resul));
                }
                break;
//hace la potencia en cualquier base y exponente
            case R.id.bt_pote:

                decimal = false;
                if (valora == 0) {
                    valora = Float.parseFloat(String.valueOf(txtnumer.getText()));
                    txtnumer.setText("0");
                    resultado = valora;
                }
                opera = 6;
                break;
//borra el contenido total de las operaciones y las dejas a 0
            case R.id.acborrar:

                decimal = false;
                valora = 0;
                valorb = 0;
                resultado = 0;
                operar = false;
                txtnumer.setText("0");
                break;
            case R.id.bt_igualdad:

                decimal = false;
                if (!operar) {
                    operar = true;
                    valorb = Integer.parseInt(String.valueOf(txtnumer.getText()));
                    val = valorb;
                }

                switch (opera) {
                    case 1:
                        resultado = resultado + val;
                        txtnumer.setText(Float.toString(resultado));
                        break;
                    case 2:
                        resultado = resultado - val;
                        txtnumer.setText(Float.toString(resultado));
                        break;
                    case 3:
                        resultado = resultado / val;
                        txtnumer.setText(Float.toString(resultado));
                        break;
                    case 4:
                        resultado = resultado * val;
                        txtnumer.setText(Float.toString(resultado));
                        break;
                    case 5:
                        float resul = (resultado * val) / 100;
                        txtnumer.setText(String.valueOf(resul));
                        break;

                    case 6:
                        double resuli = Math.pow(resultado, val);
                        txtnumer.setText(String.valueOf(resuli));
                        break;

                }
                break;

        }
    }

}

