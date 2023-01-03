package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.AsyncTask;

import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;
import com.posadskiy.currencyconverter.enums.Currency;

import java.math.RoundingMode;
import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {
    Button convertButton;
    private static final DecimalFormat round= new DecimalFormat("0.000");
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setText("CONVERT");
    }


    public void convertButton(View view){


        EditText india = (EditText) findViewById(R.id.india);
        EditText us = (EditText) findViewById(R.id.us);
        EditText uk = (EditText) findViewById(R.id.uk);
        EditText germany = (EditText) findViewById(R.id.germany);
        EditText korea = (EditText) findViewById(R.id.korea);



        if(convertButton.getText().toString()=="CONVERT") {
            convertButton.setText("RESET");

            double a[];
            a = new double[5];
            double ind[] = {0.013, 0.010, 0.012, 16.19};
            double usa[] = {77.65, 0.80, 0.93, 1257.23};
            double king[] = {97.37, 1.26, 1.17, 1576.75};
            double ger[] = {83.27, 1.07, 0.85, 1347.36};
            double kor[] = {0.062, 0.00080, 0.00063, 0.00074};

            if (india.getText().toString().length() > 0) {
                a[0] = Double.parseDouble(india.getText().toString());

                us.setText(String.valueOf(round.format(a[0] * ind[0])));
                uk.setText(String.valueOf(round.format(a[0] * ind[1])));
                germany.setText(String.valueOf(round.format(a[0] * ind[2])));
                korea.setText(String.valueOf(round.format(a[0] * ind[3])));
            }
            else if (us.getText().toString().length() > 0) {
                a[1] = Double.parseDouble(us.getText().toString());

                india.setText(String.valueOf(round.format(a[1] * usa[0])));
                uk.setText(String.valueOf(round.format(a[1] * usa[1])));
                germany.setText(String.valueOf(round.format(a[1] * usa[2])));
                korea.setText(String.valueOf(round.format(a[1] * usa[3])));
            } else if (uk.getText().toString().length() > 0) {
                a[2] = Double.parseDouble(uk.getText().toString());

                india.setText(String.valueOf(round.format(a[2] * king[0])));
                us.setText(String.valueOf(round.format(a[2] * king[1])));
                germany.setText(String.valueOf(round.format(a[2] * king[2])));
                korea.setText(String.valueOf(round.format(a[2] * king[3])));
            } else if (germany.getText().toString().length() > 0) {
                a[3] = Double.parseDouble(germany.getText().toString());

                india.setText(String.valueOf(round.format(a[3] * ger[0])));
                us.setText(String.valueOf(round.format(a[3] * ger[1])));
                uk.setText(String.valueOf(round.format(a[3] * ger[2])));
                korea.setText(String.valueOf(round.format(a[3] * ger[3])));
            } else if (korea.getText().toString().length() > 0) {
                a[4] = Double.parseDouble(korea.getText().toString());
                india.setText(String.valueOf((round.format(a[4] * kor[0]))));
                us.setText(String.valueOf(round.format(a[4] * kor[1])));
                uk.setText(String.valueOf(round.format(a[4] * kor[2])));
                germany.setText(String.valueOf(round.format(a[4] * kor[3])));
            }
            Toast.makeText(this, "Conversion Successfull!", Toast.LENGTH_LONG).show();
        }

        else {

            convertButton.setText("CONVERT");
            india.setText("");
            us.setText("");
            uk.setText("");
           germany.setText("");
           korea.setText("");

        }

    }



}
