package com.example.svt.svtevent.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.svt.svtevent.data.MemberContract.MemberEntry;

/**
 * Created by Vasukesh on 3/18/2017.
 */

public class MemberProvider extends ContentProvider {

    // TODO: Finish URI Integration
    private static final int MEMBERS = 100;
    private static final int MEMBER_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        sUriMatcher.addURI(MemberContract.CONTENT_AUTHORITY,MemberContract.PATH_MEMBERS,MEMBERS);
        sUriMatcher.addURI(MemberContract.CONTENT_AUTHORITY,MemberContract.PATH_MEMBERS+ "/#",MEMBER_ID);
    }

    /** Tag for the log messages */
    public static final String LOG_TAG = MemberProvider.class.getSimpleName();

    /**
     * Initialize the provider and the database helper object.
     */
    private MemberDbHelper mDBHelper;
    @Override
    public boolean onCreate() {
         mDBHelper = new MemberDbHelper(getContext());
        return true;
    }

    /**
     * Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase database = mDBHelper.getReadableDatabase();
        Cursor cursor = null;
        int match = sUriMatcher.match(uri);
        switch(match){
            case MEMBERS:
                // TODO: Query for roster Table
                cursor = database.query(MemberEntry.TABLE_NAME,projection,selection,selectionArgs,
                        null,null,sortOrder);
                break;
            case MEMBER_ID:
                selection = MemberEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))  };
                cursor = database.query(MemberEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    /**
     * Insert new data into the provider with the given ContentValues.
     */
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /**
     * Updates the data at the given selection and selection arguments, with the new ContentValues.
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Delete the data at the given selection and selection arguments.
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * Returns the MIME type of data for the content URI.
     */
    @Override
    public String getType(Uri uri) {
        return null;
    }
}

