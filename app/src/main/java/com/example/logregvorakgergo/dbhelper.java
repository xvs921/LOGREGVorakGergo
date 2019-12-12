package com.example.logregvorakgergo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "logreg.db";
    public static String TABLE_NAME="felhasznalo";

    public static final String COL_1="ID";
    public static final String COL_2="EMAIL";
    public static final String COL_3="FELHNEV";
    public static final String COL_4="JELSZO";
    public static final String COL_5="TELJESNEV";

    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT NOT NULL UNIQUE,FELHNEV TEXT NOT NULL UNIQUE,JELSZO TEXT NOT NULL,TELJESNEV TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean adatRogzites(String email,String felhnev,String jelszo, String teljesnev) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_5, teljesnev);

        long eredmeny = database.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor eredmeny =database.rawQuery("SELECT *from "+TABLE_NAME,null);
        return eredmeny;
    }
    public long adatTorles(int id)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete(TABLE_NAME,COL_1+"=?",new String[] {String.valueOf(id)});
    }

    public long adatModosit(String id,String email,String felhnev,String jelszo, String teljesnev)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_2,email);
        values.put(COL_3,felhnev);
        values.put(COL_4,jelszo);
        values.put(COL_5,teljesnev);
        return database.update(TABLE_NAME,values,COL_1+"=?",new String[]{id});
    }
    public Cursor felhasznaloKereses(String felhnev, String jelszo){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+ TABLE_NAME +" WHERE " + COL_3+ " = ? AND "+COL_4+"= ?";
        return db.rawQuery(sql, new String[] {felhnev,jelszo});
    }
}
