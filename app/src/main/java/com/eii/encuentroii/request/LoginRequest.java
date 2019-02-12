package com.eii.encuentroii.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Liebheart on 01/04/2018.
 */

public class LoginRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL = "https://www.encuentroii.com/loginAndroid.php";
    private Map<String, String> params;

    public LoginRequest (String correo, String pass, Response.Listener<String> listener){
            super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("correo",correo);
        params.put("pass",pass);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
