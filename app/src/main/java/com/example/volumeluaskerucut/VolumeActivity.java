package com.example.volumeluaskerucut;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeActivity extends AppCompatActivity implements View.OnClickListener {

private EditText ejari;
private EditText etinggi;
private Button btnhitung;
private TextView thasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        ejari = findViewById(R.id.injari);
        etinggi = findViewById(R.id.intinggi);

        btnhitung = findViewById(R.id.btnhitung);
        btnhitung.setOnClickListener(this);

        thasil = findViewById(R.id.thasil);
    }

    @Override
    public void onClick(View v) {
        Intent data = new Intent();
        if (v.getId() == R.id.btnhitung);

        String inputJari = ejari.getText().toString().trim();
        String inputTinggi = etinggi.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputJari)){
            isEmptyFields = true;
            ejari.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputTinggi)){
            isEmptyFields = true;
            etinggi.setError("Tidak Boleh Kosong");
        }
        
        Double jari = toDouble(inputJari);
        Double tinggi = toDouble(inputTinggi);

        if (jari == null){
            isInvalidDouble = true;
            ejari.setError("Angka harus sesuai");
        } if (tinggi == null){
            isInvalidDouble = true;
            etinggi.setError("Angka harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = 3.14 * jari * jari * tinggi;
            thasil.setText(String.valueOf(volume));
        }

        data.setData(Uri.parse(thasil.getText().toString()));
        setResult(RESULT_OK, data);

        finish();
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
