package com.example.svt.svtevent.data;

import android.provider.BaseColumns;

/**
 * Created by Vasukesh on 3/18/2017.
 */

public final class MemberContract {
    // empty private contructor to stop others from initializing it
    private MemberContract(){}


    /***
     * URI AND CONTENT PROVIDER DETAILS
     */



    /***
     * Inner Class that defines constant values for member database table
     * each entry is a single member
     */
    public static final class MemberEntry implements BaseColumns{

        /** The content URI to Access the Member Data in the Provider*/

        /** Name of Databsae **/
        public final static String TABLE_NAME = "members";

        /**
         * Unique ID NUMBER for Each Member
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        // Name of Member

        public final static String COLUMN_MEMBER_NAME ="name";

        /**
         * values for Gender
         * Type: INTEGER
          */

        public final static String COLUMN_MEMBER_GENDER="gender";

        /***
         * IF MEMBER HAS PAID THEIR DUES
         * TYPE: INTEGER
         */

        public final static String COLUMN_MEMBER_DUE= "due";

        /**
         * Member Degree
         */
        public final static String COLUMN_MEMBER_DEGREE="degree";

        /**
         * Member Emails
         */
        public final static String COLUMN_MEMBER_EMAIL = "email";

        /**
         * Values for Gender
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
        /**
         * Values for Dues Paid By Member
         */
        public static final int DUE_UNKNOWN = 0;
        public static final int DUE_PAID = 1;
        public static final int DUE_NOTPAID = 2;

        /**
         * Checks if the Gender in the Spinner is MALE/FEMALE/UNKNOWN
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }

        /**
         * Checks if the Payment Due Choice is Valid
         */
        public static boolean isValidDue(int due){
            if(due == DUE_NOTPAID || due == DUE_PAID || due == DUE_UNKNOWN){
                return true;
            }
            return false;
        }
    }
}
