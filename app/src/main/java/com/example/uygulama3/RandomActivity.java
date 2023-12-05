package com.example.uygulama3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {



    EditText edtTxtAdet, edtTxtMax, edtTxtMin;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);


        edtTxtAdet = findViewById(R.id.edtTxtAdet);
        edtTxtMax = findViewById(R.id.edtTxtMax);
        edtTxtMin = findViewById(R.id.edtTxtMin);
        btnRandom =findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarEkle();
            }
        });

    }
    public void progressBarEkle() {
        Random random = new Random();

        LinearLayout lL = findViewById(R.id.linearLayout1);

        for (int i = 0; i < Integer.parseInt(edtTxtAdet.getText().toString()); i++) {
            int maks = Integer.parseInt(edtTxtMax.getText().toString());
            int min = Integer.parseInt(edtTxtMin.getText().toString());
            int randomNumberMax = random.nextInt(maks - min + 1) + min;
            int randomNumberMin = random.nextInt(maks - min + 1) + min;

            if(randomNumberMax <= randomNumberMin){
                int item = randomNumberMax;
                randomNumberMax = randomNumberMin;
                randomNumberMin = item;
            }



            int deger = random.nextInt(randomNumberMax - randomNumberMin + 1) + randomNumberMin;
            int yuzde = (int) ((deger - randomNumberMin) / (double)(randomNumberMax - randomNumberMin) * 100);

            View view = getLayoutInflater().inflate(R.layout.progress_bar, null);

            TextView tvMaks = view.findViewById(R.id.txtMax);
            TextView tvMin = view.findViewById(R.id.txtMin);
            TextView tvDegerYuzde = view.findViewById(R.id.txtSonuc);
            ProgressBar pBar = view.findViewById(R.id.progressBar1);

            tvMaks.setText(String.valueOf(randomNumberMax));
            tvMin.setText(String.valueOf(randomNumberMin));
            tvDegerYuzde.setText(deger + " = %" + yuzde);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                pBar.setMin(randomNumberMin);
            }


            pBar.setMax(randomNumberMax);
            pBar.setProgress(deger);

            lL.addView(view);
        }

    }
}