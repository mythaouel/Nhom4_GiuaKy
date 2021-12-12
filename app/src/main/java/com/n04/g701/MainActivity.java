package com.n04.g701;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.n04.adapter.ProductAdapter;
import com.n04.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MyDatabaseHelper db;
    ProductAdapter adapter;
    ListView lvProduct;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        loadData();
        db = new MyDatabaseHelper(this);
    }

    private void linkViews() {
        lvProduct = findViewById( R.id.lvProduct );
    }

    private void loadData() {
            adapter = new ProductAdapter( MainActivity.this, R.layout.item_layout,getDataFromDb() );
            lvProduct.setAdapter( adapter );
        }

    private List<Product> getDataFromDb() {
            products = new ArrayList<>();
            Cursor cursor = db.getData( "SELECT*FROM " + MyDatabaseHelper.TB_NAME);
            products.clear();
            while (cursor.moveToNext()){
                products.add( new Product(cursor.getString( 0 ), cursor.getString( 1 ), cursor.getDouble( 2 ), cursor.getString( 3 ),  cursor.getBlob( 4 )));
            }
            cursor.close();
            return products;
        }
    }
}

}