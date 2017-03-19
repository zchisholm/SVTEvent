package com.example.svt.svtevent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
}
