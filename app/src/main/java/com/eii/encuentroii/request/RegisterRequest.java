package com.eii.encuentroii.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Liebheart on 01/04/2018.
 */

public class RegisterRequest extends StringRequest {

    private static final String  REGISTER_REQUEST_URL ="https://www.encuentroii.com/registroAndroid.php"; //MODIFICAR MAS TARDE
    private Map<String, String> params;

    public RegisterRequest(String nombre, String apellidos , String edad, String genero, String estado, String municipio,
                           String cp, String escuela, String correo, String contraseña, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);

        params = new HashMap<>();
        params.put("nombre",nombre);
        params.put("apellidos",apellidos);
        params.put("edad",edad + "");
        params.put("genero",genero);
        params.put("estado",estado);
        params.put("municipio",municipio);
        params.put("codigo",cp +"");
        params.put("escuela",escuela);
        params.put("correo",correo);
        params.put("pass",contraseña);
        params.put("verificacion","1");


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
