package com.example.uygulama3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SmsActivity extends AppCompatActivity {
    EditText edtTxtTelefon, edtTxtMesaj;
    Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtTxtTelefon = findViewById(R.id.edtTxtTelefon);
        edtTxtMesaj = findViewById(R.id.edtTxtMesaj);
        btnSms = findViewById(R.id.btnSms);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    smsGonder();
                }else {
                    ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
            smsGonder();
        }else {
            Toast.makeText(this, "Izin reddedildi." , Toast.LENGTH_SHORT).show();
        }
    }

    public void smsGonder(){
        String tel = edtTxtTelefon.getText().toString();
        String mesaj = edtTxtMesaj.getText().toString();

        if (!tel.isEmpty() && !mesaj.isEmpty()){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tel, null, mesaj, null, null);
            Toast.makeText(this, "SMS Gonderildi.", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Telefon numarasi ve mesajinizi giriniz.", Toast.LENGTH_SHORT).show();
        }
    }
}