package com.example.svt.svtevent;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.svt.svtevent.data.MemberContract.MemberEntry;


public class Registration extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Object> {

    // TODO: Create Registration Page Variables

    // Identifier member Data loader
    private static final int EXISTING_MEMBER_LOADER = 0;

    // Content Uri For existing members
    private Uri mCurrentMemberUri;

    // Private Variables for Edit Text / Spinner Buttons
    private EditText mNameEditText;
    private EditText mDegreeEditText;
    private EditText mEmailEditText;
    private Spinner mGenderSpinner;
    private Spinner mDueSpinner;

    // Integer Variables for Gender and Due Payment Defaults
    private int mGender = MemberEntry.GENDER_UNKNOWN;

    private int mDue = MemberEntry.DUE_UNKNOWN;

    // Flag to check if member is edited
    private boolean mMemberHasChanged = false;


    // On Touch Register Activity View
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mMemberHasChanged = true;
            return false;
        }
    };



    // This Includes Save Button/ Spinner etc etc.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // TODO: Find Registration Page Variables and Listeners

        // get our current intent
        Intent intent = getIntent();
        mCurrentMemberUri = intent.getData();

        // Check if There is Data in URI
        if(mCurrentMemberUri == null){
            setTitle("Add a New Member");

            // invalidate the ability to delete members that arnt created yet
            invalidateOptionsMenu();
        } else{
            // if this is not a new member then it needed to be a current member to edit
            setTitle("Edit Member");

            // initialize loader to read data
            // display current values in registeration page
            getLoaderManager().initLoader(EXISTING_MEMBER_LOADER, null, this);

        }

        // Finding the Edit/Spinner Views
        //TODO: Make XML File For IDS FOR EDIT TEXT AND 2 Spinners
        mNameEditText = (EditText)findViewById(R.id.et_regName);
        //mDegreeEditText = (EditText)findViewById(R.id.);
        mEmailEditText = (EditText)findViewById(R.id.et_regEmail);
        mGenderSpinner = (Spinner)findViewById(R.id.regGenSpinner);
        mDueSpinner = (Spinner)findViewById();

        // set OnTouchListeners on all inputs to identify if they have been touched or
        // have been modified without saving.

        mNameEditText.setOnTouchListener(mTouchListener);
        mDegreeEditText.setOnTouchListener(mTouchListener);
        mEmailEditText.setOnTouchListener(mTouchListener);
        mGenderSpinner.setOnTouchListener(mTouchListener);
        mDueSpinner.setOnTouchListener(mTouchListener);

        setupSpinner();

    }

    private void setupSpinner(){
        // Create adaptor for the spinners. The List options from String Array
        // Todo: Create the Array List for Options on Due Payment and Gender
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_gender_options, android.R.layout.simple_spinner_item);
        ArrayAdapter dueSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_due_options, android.R.layout.simple_spinner_dropdown_item);


        // Specify dropdown layout
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dueSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);


        // Apply adapter to spinner
        mGenderSpinner.setAdapter(genderSpinnerAdapter);
        mDueSpinner.setAdapter(dueSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals("Male")) {
                        mGender = MemberEntry.GENDER_MALE;
                    } else if (selection.equals("Female")) {
                        mGender = MemberEntry.GENDER_FEMALE;
                    } else {
                        mGender = MemberEntry.GENDER_UNKNOWN;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = MemberEntry.GENDER_UNKNOWN;
            }
        });
    }

    private void saveMember(){
        // read inputs and remove whitespaces
        String nameString = mNameEditText.getText().toString().trim();
        String degreeString = mDegreeEditText.getText().toString().trim();
        String emailString = mEmailEditText.getText().toString().trim();

        // check if it is a new member and check if fields are blank

        if(mCurrentMemberUri == null &&
                TextUtils.isEmpty(nameString) && TextUtils.isEmpty(degreeString) &&
                TextUtils.isEmpty(emailString) && mGender == MemberEntry.GENDER_UNKNOWN);
        return;
    }


    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        // Todo: Create the menu options XML for Registration Page
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        // If this is a new Member, hide the "Delete" menu item.
        if (mCurrentMemberUri == null) {
            // Todo: Make menu action_delete Id
            MenuItem menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
        }
        return true;
    }


    @Override
    public Loader<Object> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Object> loader, Object o) {

    }

    @Override
    public void onLoaderReset(Loader<Object> loader) {

    }

    //TODO: Make The Registration Page

    // TODO: Methods to Link Registration Page Information To Roster Activity
}
