package com.eii.encuentroii;

import android.app.Service;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Created by Michael Liebheart on 13/04/2018.
 */

public class MFirebasedInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "ENCUENTROII" ;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Toke" + token);

    }
}
