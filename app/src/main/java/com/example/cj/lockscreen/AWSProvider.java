package com.example.cj.lockscreen;

import android.content.Context;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;

/**
 * Created by saleh on 5/1/18.
 */

public class AWSProvider {
    private static AWSProvider instance = null;
    private Context context;
    private AWSConfiguration awsConfiguration;


    public static AWSProvider getInstance() {
        return instance;
    }
    public static void init(Context context){
        if (instance == null)
            instance = new AWSProvider(context);
    }
    private AWSProvider(Context context) {
        this.context = context;
        this.awsConfiguration = new AWSConfiguration(context);
        IdentityManager identityManager = new IdentityManager(context, awsConfiguration );
        IdentityManager.setDefaultIdentityManager(identityManager);
        identityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
    }
    public IdentityManager getIdentityManager(){
        return IdentityManager.getDefaultIdentityManager();
    }
}
