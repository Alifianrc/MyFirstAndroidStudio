package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonback, btnHitung;
    EditText edtPanjang, edtLebar, edtTinggi;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtPanjang = findViewById(R.id.ed_panjang);
        edtLebar = findViewById(R.id.ed_lebar);
        edtTinggi = findViewById(R.id.ed_tinggi);
        tvHasil = findViewById(R.id.tv_hasil);
        buttonback = findViewById(R.id.btn_back);
        buttonback.setOnClickListener(this);
        btnHitung = findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_hitung) {
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();


            boolean isEmptyField = false;
            boolean isInvalidDouble = false;

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang == null) {
                isInvalidDouble = true;
                edtPanjang.setError("Nilai harus berupa angka yang valid ");
            }
            if (lebar == null) {
                isInvalidDouble = true;
                edtLebar.setError("Nilai harus berupa angka yang valid ");
            }
            if (tinggi == null) {
                isInvalidDouble = true;
                edtTinggi.setError("Nilai harus berupa angka yang valid ");
            }

            //pemisah saja
            if (TextUtils.isEmpty(inputPanjang)) {
                isEmptyField = true;
                edtPanjang.setError("Masukkan Nomor !");
            }
            if (TextUtils.isEmpty(inputLebar)) {
                isEmptyField = true;
                edtLebar.setError("Masukkan Nomor !");
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyField = true;
                edtTinggi.setError("Masukkan Nomor !");
            }


            if (!isInvalidDouble && !isEmptyField) {
                double volume = lebar * tinggi * panjang;
                tvHasil.setText("" + volume);
                tvHasil.setText(String.valueOf(volume));
            }


        }

        else if (view.getId() == R.id.btn_back){
            openMainActivity();
        }
    }

    private Double toDouble(String str) {

        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}