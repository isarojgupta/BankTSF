package io.android.banktsf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9939018273,'Saroj',10000.00,'saroj@gmail.com','XXXXXXXXXX111','ABA844SB')");
        db.execSQL("insert into user_table values(8002934129,'Aditya',1522.67,'aditya@gmail.com','XXXXXXXXXXXX2341','SVA43355432')");
        db.execSQL("insert into user_table values(8051912718,'Poonam',1124.56,'cool.poonam@gmail.com','XXXXXXXXXXXX3412','SSHS387654321')");
        db.execSQL("insert into user_table values(9709895957,'Satyam',11512.01,'satyam.kam@gmail.com','XXXXXXXXXXXX4123','ABCDS743210')");
        db.execSQL("insert into user_table values(7547490985,'Sudarshan',21358.82,'sudarshan.sw@gmail.com','XXXXXXXXXXXX2345','BSDA32109')");
        db.execSQL("insert into user_table values(6364373384,'Simran',94511.16,'simran.07@gmail.com','XXXXXXXXXXXX3452','CABS4321098')");
        db.execSQL("insert into user_table values(4425422542,'Akash',15722.00,'akash.gupta@gmail.com','XXXXXXXXXXXX4523','ABC43SS0987')");
        db.execSQL("insert into user_table values(3524662432,'Aryan',852234.22,'kat.aryan@gmail.com','XXXXXXXXXXXX5234','BSACA32109876')");
        db.execSQL("insert into user_table values(5673424324,'Sushmita',43298.46,'sushmita.09@gmail.com','XXXXXXXXXXXX3456','CAAAB21098765')");
        db.execSQL("insert into user_table values(9634157236,'Vicky',273235.90,'vicky.09@gmail.com','XXXXXXXXXXXX4563','ABAC17654')");
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
