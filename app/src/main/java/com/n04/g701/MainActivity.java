package com.n04.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;

    public static MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new MyDatabaseHelper(this);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        lvProduct = findViewById(R.id.lvProduct);
    }
    private void addEvents() {
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openProductDetail();
            }
        });
    }

    private void openProductDetail() {
        Intent intent = new Intent(this, ProductDetail.class);
        startActivity(intent);
    }

}