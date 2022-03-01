package com.example.listviewsqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;



public class Customer_Table extends SQLiteOpenHelper
{

    Context context;
    private static String DATABASE_NAME="CarDetailsDb.db";
    private static int DATABASE_VERSION=2;
    //String name, String username, String passwrod, String email, String mobileNo, String address, String status
    private static String createTableQuery="create table CustomerTable(name TEXT, username TEXT PRIMARY KEY,passwrod TEXT ,email TEXT,mobileNo TEXT,address TEXT,status TEXT)";


    public Customer_Table(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=  context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(createTableQuery);
        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS CustomerTable" );
        // Create tables again
        onCreate(db);
    }

    // //String name, String username, String passwrod, String email, String mobileNo, String address, String status, String Designation
    public boolean Add(Customer staff)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("name",staff.getName());
        values.put("username",staff.getUserName());
        values.put("passwrod",staff.getPassword());
        values.put("email",staff.getEmail());
        values.put("mobileNo",staff.getMobileNo());
        values.put("address",staff.getAddress());
        values.put("status",staff.getStatus());//

        // db.insert("StaffTable", null, values);

        long result = db.insert("CustomerTable", null, values);//insert

        if (result == -1)
        {db.close();
            return false;

        }
        else {
            db.close();
            return true;

        }



    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CustomerTable" , null);
        return res;
    }




    public boolean updatePassword(String s, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE  ManagerTable SET password ="+"'"+password+"'" +" where username="+"'"+password+"'");
        return true;
    }


    public Cursor getCustomer(String customerid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CustomerTable where username='"+customerid+"'" , null);
        return res;
    }
}

