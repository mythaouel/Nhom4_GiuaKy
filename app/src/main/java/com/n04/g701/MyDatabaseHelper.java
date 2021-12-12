package com.n04.g701;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NAME="product.sqlite";

    public static final String  TB_NAME="PRODUCT";

    public static final String COL_ID="MASP";
    public static final String COL_NAME="TENSP";
    public static final String COL_PRICE="GIA";
    public static final String COL_BRAND="HANGSX";
    public static final String COL_PHOTO="HINH";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS " +TB_NAME +"("+ COL_ID + " VARCHAR(20) PRIMARY KEY, "+
                COL_NAME+ " VARCHAR(100), " + COL_PRICE + " MONEY, "+ COL_BRAND + " VARCHAR(100), " + COL_PHOTO + " BLOB)";
        sqLiteDatabase.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TB_NAME);
        onCreate(sqLiteDatabase);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    public boolean insertData(String id,String name, Double price,String brand, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TB_NAME + " VALUES(null,?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(0, id);
            statement.bindString(1, name);
            statement.bindDouble(2,price);
            statement.bindString(3, brand);
            statement.bindBlob(4, photo);

            statement.executeInsert();
            return true;
        } catch (Exception Ex){
            return false;
        }
    }
}
