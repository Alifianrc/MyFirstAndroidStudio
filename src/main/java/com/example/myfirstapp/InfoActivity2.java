package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity2 extends AppCompatActivity implements View.OnClickListener{

    EditText edNama, edInstitut;
    Button btnPindahTanpaData, btnPindahData, btnBack;

    public static final String EXTRA_NAMA_2 = "extra_name";
    public static final String EXTRA_INSTITUT_2 = "extra_institut";

    TextView tvNama, tvInstitut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        edNama = findViewById(R.id.ed_nama);
        edInstitut = findViewById(R.id.ed_institut);

        btnPindahData = findViewById(R.id.btn_pindah_data);
        btnPindahTanpaData = findViewById(R.id.btn_pindah_tanpa_data);
        btnBack=findViewById(R.id.btn_back);

        btnPindahData.setOnClickListener(this);
        btnPindahTanpaData.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        tvNama = findViewById(R.id.tv_nama);
        tvInstitut = findViewById(R.id.tv_institut);

        String terimaNama = getIntent().getStringExtra(InfoActivity1.EXTRA_NAMA_1);
        String terimaInstitut = getIntent().getStringExtra(InfoActivity1.EXTRA_INSTITUT_1);
        if(TextUtils.isEmpty(terimaNama)){
            tvNama.setText("Nama       : ");
        } else{
            tvNama.setText("Nama       : " + terimaNama);
        }
        if(TextUtils.isEmpty(terimaInstitut)){
            tvInstitut.setText("Institusi   : ");
        } else{
            tvInstitut.setText("Institusi   : " + terimaInstitut);
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_pindah_data:
                pindahActivityData();
                break;
            case R.id.btn_pindah_tanpa_data:
                pindahActivityTanpaData();
                break;
            case R.id.btn_back:
                backToMenu();
                break;
        }
    }

    private void pindahActivityTanpaData(){
        Intent moveIntent=new Intent(InfoActivity2.this,InfoActivity3.class);
        startActivity(moveIntent);
    }

    private void pindahActivityData(){
        String kirimNama = edNama.getText().toString().trim();
        String kirimInstitut = edInstitut.getText().toString().trim();
        Intent moveIntentWithData = new Intent(InfoActivity2.this,InfoActivity3.class);

        moveIntentWithData.putExtra(this.EXTRA_NAMA_2,kirimNama);
        moveIntentWithData.putExtra(this.EXTRA_INSTITUT_2,kirimInstitut);

        startActivity(moveIntentWithData);
    }

    private void backToMenu(){
        Intent moveIntent=new Intent(InfoActivity2.this,MainActivity.class);
        startActivity(moveIntent);
    }
}