package com.example.cj.lockscreen;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

public class Access_History {

    @DynamoDBTable(tableName = "ACCESS_HISTORY")
    public class Users {
        private String _username;
        private String _time;
        private String _action;
        //Hash key means it is the primary key
        @DynamoDBHashKey(attributeName = "USERNAME")
        //Is the column name
        @DynamoDBAttribute(attributeName = "USERNAME")
        public String get_username(){
            return _username;
        }
        public void set_username(final String id){
            this._username = id;

        }
        @DynamoDBAttribute(attributeName = "TIME")
        public String get_time(){
            return _time;
        }
        public void set_time(final String time){
            this._time = time;

        }
        @DynamoDBAttribute(attributeName = "ACTION")
        public String get_action(){
            return _action;
        }
        public void set_action(final String action){
            this._action = action;
        }



    }

}
