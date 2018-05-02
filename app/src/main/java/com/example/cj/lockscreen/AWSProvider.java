package com.example.cj.lockscreen;

import android.content.Context;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

/**
 * Created by saleh on 5/1/18.
 */

public class AWSProvider {
    private static AWSProvider instance = null;
    private Context context;
    private Integer resourceID;
    private AWSConfiguration awsConfiguration;
    private AmazonDynamoDBClient dbClient = null;
    private DynamoDBMapper dbMapper = null;


    public static AWSProvider getInstance() {
        return instance;
    }
    public static void init(Context context){
        if (instance == null){
            instance = new AWSProvider(context);
        }
    }
    private AWSProvider(Context context) {
        resourceID = context.getResources().getIdentifier("awsconfiguration", "raw", context.getPackageName());
        this.context = context;
        this.awsConfiguration = new AWSConfiguration(context, resourceID);
        IdentityManager identityManager = new IdentityManager(context, awsConfiguration );
        IdentityManager.setDefaultIdentityManager(identityManager);
        identityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
    }
    public IdentityManager getIdentityManager(){
        return IdentityManager.getDefaultIdentityManager();

    }
    public AWSConfiguration getAwsConfiguration(){
        return awsConfiguration;
    }
    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }
    public DynamoDBMapper getDyanomoDBMapper(){
        if (dbMapper == null) {
            final AWSCredentialsProvider cp = getIdentityManager().getCredentialsProvider();
            dbClient = new AmazonDynamoDBClient(cp);
            dbMapper = DynamoDBMapper.builder()
                    .awsConfiguration(getConfiguration())
                    .dynamoDBClient(dbClient)
                    .build();
        }
        return dbMapper;
    }


}
