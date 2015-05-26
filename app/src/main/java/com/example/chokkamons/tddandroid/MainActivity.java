package com.example.chokkamons.tddandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtCelcius = (EditText)findViewById(R.id.txtCelcius);
        final EditText txtFahrenheit = (EditText)findViewById(R.id.txtFahrenheit);

        txtCelcius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (txtCelcius.hasFocus()){
                        String text = txtCelcius.getText().toString();
                        if (!text.isEmpty()){
                            Double value = Double.parseDouble(text);
                            Double fh = ((9.0/5.0)*value)+32.0;
                            txtFahrenheit.setText(String.valueOf(fh));
                        }
                        else {
                            txtFahrenheit.setText("");
                        }
                    }
                }catch (Exception e){}
            }
        });

        txtFahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (txtFahrenheit.hasFocus()){
                        String text = txtFahrenheit.getText().toString();
                        if (!text.isEmpty()){
                            Double value = Double.parseDouble(text);
                            Double cc = (5.0/9.0)*(value-32.0);
                            txtCelcius.setText(String.valueOf(cc));
                        }
                        else{
                            txtCelcius.setText(text);
                        }
                    }
                }catch (Exception e){}
            }
        });


    }


}
