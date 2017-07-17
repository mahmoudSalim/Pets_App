package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

import static android.R.attr.version;
import static android.os.FileObserver.CREATE;

/**
 * Created by mahmoud on 28/05/17.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    public static final String OPEN = "(";
    public static final String CLOSE = ");";
    public static final String INT = " INTEGER ";
    public static final String TXT = " TEXT" ;
    public static final String COMA = ", ";
    public static final String CREATE_TABLE = " CREATE TABLE ";
    public static final String PRIM_KEY = " PRIMARY KEY ";
    public static final String AUTO_INC = " AUTOINCREMENT ";
    public static final String NOT_NULL = " NOT NULL ";
    public static final String DEF_0 = " DEFAULT 0 ";

    public static final String DROP_TABLE = " DROP TABLE IF EXSIST ";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE pets (_id INTEGER, name TEXT, breed TEXT, gender INTEGER, weight INTEGER);

        String SQL_CREATE_PETS_TABLE = CREATE_TABLE + PetEntry.TABLE_NAME + OPEN
                + PetEntry.COLUMN_PET_ID + INT + PRIM_KEY  + AUTO_INC + COMA
                + PetEntry.COLUMN_PET_NAME + TXT + NOT_NULL + COMA
                + PetEntry.COLUMN_PET_BREED + TXT + COMA
                + PetEntry.COLUMN_PET_GENDER + INT + COMA
                + PetEntry.COLUMN_PET_WEIGHT + INT + DEF_0 + CLOSE;


        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
