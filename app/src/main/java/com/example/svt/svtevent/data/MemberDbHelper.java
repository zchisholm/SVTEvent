package com.example.svt.svtevent.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.svt.svtevent.data.MemberContract.MemberEntry;

/**
 * Created by Vasukesh on 3/18/2017.
 */

public class MemberDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = MemberDbHelper.class.getSimpleName();

    /***
     * name of database file
     */
    private static final String DATABASE_NAME = "roster.db";

    /**
     * Database Version
     * Default Version: 1
     * Type: Integer
     */
    private static final int DATABASE_VERSION = 1;

    // DB HELPER CONSTRUCTOR

    public MemberDbHelper(Context context) {
        // super takes in (Context, Name, Factory, Version)
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // OnCreate for creating a database


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains SQL statement for Member Database
        String SQL_CREATE_MEMBER_TABLE =  "CREATE TABLE " + MemberEntry.TABLE_NAME + " ("
                + MemberEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MemberEntry.COLUMN_MEMBER_NAME + " TEXT NOT NULL, "
                + MemberEntry.COLUMN_MEMBER_DEGREE + " TEXT, "
                + MemberEntry.COLUMN_MEMBER_GENDER + " INTEGER NOT NULL, "
                + MemberEntry.COLUMN_MEMBER_DUE + " INTEGER NOT NULL, "
                + MemberEntry.COLUMN_MEMBER_EMAIL + " TEXT NOT NULL);";

        /***
         * Anytime we want to Execute a Sql Command .execSQL
         * We will create the DATABASE Table
         */
        db.execSQL(SQL_CREATE_MEMBER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Version 1 Don't Need to Upgrade
    }
}
