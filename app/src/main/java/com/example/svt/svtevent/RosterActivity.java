package com.example.svt.svtevent;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.svt.svtevent.data.MemberContract;
import com.example.svt.svtevent.data.MemberContract.MemberEntry;
import com.example.svt.svtevent.data.MemberDbHelper;

public class RosterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);

        Button addMembers = (Button)findViewById(R.id.newMember);

        addMembers.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v){
                        Intent myIntent = new Intent(v.getContext(), Registration.class);
                        startActivity(myIntent);
                    }
                });
    }

    // TODO: Query From MEMBERS DB HELPER
    private void displayDatabaseInfo(){
        String[] projection ={
                MemberEntry._ID,
                MemberEntry.COLUMN_MEMBER_NAME,
                MemberEntry.COLUMN_MEMBER_DEGREE,
                MemberEntry.COLUMN_MEMBER_GENDER,
                MemberEntry.COLUMN_MEMBER_DUE,
                MemberEntry.COLUMN_MEMBER_EMAIL};
        }
    }

