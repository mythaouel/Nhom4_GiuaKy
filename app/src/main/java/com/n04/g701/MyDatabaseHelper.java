package com.n04.g701;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NAME="electronic.sqlite";

    public static final String  TB_NAME="product";

    public static final String COL_ID="MASP";
    public static final String COL_NAME="TENSP";
    public static final String COL_PRICE="GIA";
    public static final String COL_BRAND="HANGSX";
    public static final String COL_PHOTO="HINH";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS " +TB_NAME +"("+ COL_ID + " VARCHAR(20) PRIMARY KEY, "+
                COL_NAME+ " VARCHAR(100), " + COL_PRICE + " REAL, "+ COL_BRAND + " VARCHAR(100), " + COL_PHOTO + " BLOB)";
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
    public void queryExec(String sql){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(sql);
    }
    public int getCount(){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TB_NAME,null);
        int count= cursor.getCount();
        cursor.close();
        return count;
    };
    public void createSomeDefaultTasks(){
        int count=getCount();
        if (count==0){
            queryExec("INSERT INTO "+TB_NAME+" VALUES('LP01','LAPTOP',12,'Apple',null)");

        }
    }
    public boolean insertData(String id,String name, double price,String brand, byte[] photo){
        try {
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TB_NAME + " VALUES(?,?,?,?,?)";
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
