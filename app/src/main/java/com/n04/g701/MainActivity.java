package com.n04.g701;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper db;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;

    public static MyDatabaseHelper db;
>>>>>>> dff8f6fdc6c0288265c13f813a79a7de38faac8a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new MyDatabaseHelper(this);
<<<<<<< HEAD
        db.createSomeDefaultTasks();
=======

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
>>>>>>> dff8f6fdc6c0288265c13f813a79a7de38faac8a
    }
}