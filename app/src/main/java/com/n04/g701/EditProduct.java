package com.n04.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.n04.model.Product;

public class EditProduct extends AppCompatActivity {

    EditText edtName,edtPrice;
    Button btnOk, btnCancel;

    Product p;
    public static final String SELECTED_ITEM = "selected_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        linkViews();
        addEvents();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        p = (Product) intent.getSerializableExtra(SELECTED_ITEM);
        edtName.setText(p.getProductName());
        edtPrice.setText(String.valueOf(p.getProductPrice()));
    }

    private void linkViews() {
        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);

        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
    }

    private void addEvents() {

    }
}