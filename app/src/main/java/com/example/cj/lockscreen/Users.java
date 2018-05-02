package com.example.cj.lockscreen;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by saleh on 5/2/18.
 */

@DynamoDBTable(tableName = "LOCK_USERS")
public class Users {
    private Integer _id;
    private Boolean _isOwner;
    private String _password;

    @DynamoDBHashKey(attributeName = "USER_ID")
    @DynamoDBAttribute(attributeName = "USER_ID")
    public Integer getUserId(){
        return _id;
    }
    public void setUserId(final Integer id){
        this._id = id;

    }
    @DynamoDBAttribute(attributeName = "owner")
    public Boolean getOwner(){
        return _isOwner;
    }
    public void setOwner(final Boolean isOwner){
        this._isOwner = isOwner;

    }
    @DynamoDBAttribute(attributeName = "password")
    public String getPassword(){
        return _password;
    }
    public void setPassword(final String password){
        this._password = password;
    }



}
