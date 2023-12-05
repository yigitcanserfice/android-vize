package com.example.uygulama3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {

    EditText edtTxtDemical, edtTxtByte, edtTxtCelcius ;
    Button btnDecimal, btnByte, btnCelcius;

    Spinner spinnerDecimal, spinnerByte;
    TextView txtDecimalSonuc, txtByteSonuc, txtCelciusSonuc;

    RadioButton rbFahrenayt, rbKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        DecimalHesap();
        MegaByteHesap();
        CelciusHesap();

    }

    public void DecimalHesap(){
        edtTxtDemical = findViewById(R.id.edtTxtDecimal);
        btnDecimal = findViewById(R.id.btnDecimal);
        spinnerDecimal = findViewById(R.id.spinnerDecimal);
        txtDecimalSonuc = findViewById(R.id.txtDecimalSonuc);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.decimalConverter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDecimal.setAdapter(adapter);


        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edtTxtDemical.getText().toString();
                int i = Integer.parseInt(string);
                if (!string.isEmpty()){
                    Integer selected = spinnerDecimal.getSelectedItemPosition();
                    if (selected == 0){
                        String sonuc = Integer.toBinaryString(i).toUpperCase();
                        txtDecimalSonuc.setText(sonuc);
                    } else if (selected == 1) {
                        String sonuc = Integer.toOctalString(i).toUpperCase();
                        txtDecimalSonuc.setText(sonuc);
                    } else if (selected == 2) {
                        String sonuc = Integer.toHexString(i).toUpperCase();
                        txtDecimalSonuc.setText(sonuc);
                    }
                }
                else {
                    txtDecimalSonuc.setText(" ");
                }

            }
        });
    }
    public void MegaByteHesap(){
        edtTxtByte = findViewById(R.id.edtTxtByte);
        btnByte = findViewById(R.id.btnByte);
        spinnerByte = findViewById(R.id.spinnerByte);
        txtByteSonuc = findViewById(R.id.txtByteSonuc);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.ByteConverter, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerByte.setAdapter(adapter2);

        btnByte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edtTxtByte.getText().toString();
                int i = Integer.parseInt(string);
                if (!string.isEmpty()){
                    Integer selected = spinnerByte.getSelectedItemPosition();
                    if (selected==0){//Kilobyte
                        String sonuc = String.valueOf(i * 1000);
                        txtByteSonuc.setText(sonuc);
                    } else if (selected==1) {//Byte
                        String sonuc = String.valueOf(i * 1000 * 1000);
                        txtByteSonuc.setText(sonuc);
                    } else if (selected==2) {//Kibibyte
                        String sonuc = String.valueOf(i * 976.5625);
                        txtByteSonuc.setText(sonuc);
                    } else if (selected==3) {//Bit
                        String sonuc = String.valueOf(i * 8000000);
                        txtByteSonuc.setText(sonuc);
                    }

                }
                else {
                    txtByteSonuc.setText(" ");
                }
            }
        });

    }
    public void CelciusHesap(){
        rbFahrenayt = findViewById(R.id.rbFahrenayt);
        rbKelvin = findViewById(R.id.rbKelvin);
        edtTxtCelcius = findViewById(R.id.edtTxtCelcius);
        btnCelcius = findViewById(R.id.btnCelcius);
        txtCelciusSonuc = findViewById(R.id.txtCelciusSonuc);

        btnCelcius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edtTxtCelcius.getText().toString();
                int i = Integer.parseInt(string);

                if(rbFahrenayt.isChecked()){
                    String sonuc = String.valueOf((i * 9/5)+32);
                    txtCelciusSonuc.setText(sonuc + "°F");

                } else if (rbKelvin.isChecked()) {
                    String sonuc = String.valueOf(i + 273.15);
                    txtCelciusSonuc.setText(sonuc + "°K");

                }
            }
        });

    }
}