package com.n04.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class AddProduct extends AppCompatActivity {

    EditText edtName,edtPrice;
    Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        linkViews();
        addEvents();
    }

    private void addEvents() {

    }

    private void linkViews() {
        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);

        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
    }
}