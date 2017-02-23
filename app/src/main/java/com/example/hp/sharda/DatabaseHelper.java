package com.example.hp.sharda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HP on 2/16/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION =1;
    private static  final String DATABASE_NAME = "Contact.db";
    private static  final String table_name = "Contact";
    private static  final String column_name = "name";
    private static  final String column_email = "email";
    private static  final String column_cemail = "cemail";
    private static  final String column_phone = "phone";
    private static  final String column_id = "id";
    private static  final String column_batch = "batch";
    private static  final String column_degree = "degree";
    private static  final String column_stream = "stream";
    private static  final String column_pwd2 = "pwd1";
    private static  final String column_pwd1 = "pwd2";

    private SQLiteDatabase db ;

    private  static final String TableCreate = "create table Contact(id integer primary key not null, name text not null," +
            "email text not null, cemail text not null, phone text not null, batch text not null, degree text not null," +
            "stream text not null, pwd1 text not null , pwd2 text not null);";


    public  DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(TableCreate);
        this.db = db;
    }

    public  void insert(Contacts c)
    {
       db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Contact";
        Cursor  cursor = db.rawQuery(query,null);
        values.put(column_name,c.getName());
        values.put(column_email,c.getEmail());
        values.put(column_cemail,c.getCemail());
        values.put(column_phone,c.getPhone());
        values.put(column_id,c.getId());
        values.put(column_batch,c.getBatch());
        values.put(column_degree,c.getDegree());
        values.put(column_stream,c.getStream());
        values.put(column_pwd2,c.getPwd1());
        values.put(column_pwd1,c.getPwd2());

        db.insert(table_name, null , values);

        db.close();


    }

    public  String searchPass (String name)
    {
        db = this.getReadableDatabase();
        String query = "select name , pwd1 from"+table_name;
        Cursor cursor = db.rawQuery(query,null);

        String a , b;
        b= "NOT FOUND";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);

                if(a.equals(name))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());

        }
        return  b;


    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS"+table_name;
        db.execSQL(query);
        this.onCreate(db);

    }


}
