package com.example.svt.svtevent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private Button rosterbtn, eventsbtn, emailButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up Buttons to ID's
        rosterbtn = (Button)findViewById(R.id.addMember);
        eventsbtn = (Button)findViewById(R.id.addEvent);
        emailButton = (Button)findViewById(R.id.sendReport);
        /**
         * Send Reports Button To Send Email
         */
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // open email client using intent
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "example.gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject One");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body Of Email....");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }

    // Using OnClick In XML to Access New Activities
    public void goToRoster(View v){
       Intent myIntent = new Intent(this, RosterActivity.class);
        startActivity(myIntent);
    }

    public void goToEvents(View v){
        Intent myIntent = new Intent(this, Events.class);
        startActivity(myIntent);
    }

    // TODO: Need to Display Data from Events Database
}
