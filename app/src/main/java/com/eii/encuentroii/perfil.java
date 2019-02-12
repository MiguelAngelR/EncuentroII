package com.eii.encuentroii;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import de.hdodenhof.circleimageview.CircleImageView;

public class perfil extends AppCompatActivity {
    String idR;
    String usuarioR;
    String edadR;
    String generoR;
    String estadoR;
    String municipioR;
    String escuelaR;
    String correoR;
    String codigoR;
    CircleImageView ciPerfil;
    ImageView ivCodigoQr;
    TextView tvUsuario,tvEdad,tvGenero,tvEstado,tvMunicipio,tvEscuela,tvCorreo,tvCodigo;
    private final static String PREFERENCES_DATOS_USUARIO = "datosUsuario";
    Button btCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        inicializar();
        recuperarDatos();
        imprimirDatos();
        botones();

    }


    public void inicializar(){
        btCodigo = (Button)findViewById(R.id.btRegresar);
        tvCorreo = (TextView)findViewById(R.id.tvCorreo);
        tvUsuario = (TextView)findViewById(R.id.tvNombreUsuario);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        tvGenero = (TextView)findViewById(R.id.tvGenero);
        tvEstado = (TextView)findViewById(R.id.tvEstado);
        tvEscuela = (TextView)findViewById(R.id.tvEscuela);
        tvCodigo = (TextView)findViewById(R.id.tvCodigo);
        tvMunicipio = (TextView)findViewById(R.id.tvMunicipio);
        ivCodigoQr = (ImageView)findViewById(R.id.ivCodigoQr);
        ciPerfil = (CircleImageView)findViewById(R.id.ciPerfil);
    }

    public void botones() {
           btCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(idR, BarcodeFormat.QR_CODE, 200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    ivCodigoQr.setImageBitmap(bitmap);

                    Toast.makeText(perfil.this, "Código QR generado correctamente", Toast.LENGTH_SHORT).show();
                }catch (WriterException e){
                        e.printStackTrace();
                }
            }
        });
    }

    public void recuperarDatos() {

        SharedPreferences preferences = getSharedPreferences(PREFERENCES_DATOS_USUARIO, MODE_PRIVATE);
        this.idR = preferences.getString("Id", "invitado");
        this.usuarioR = preferences.getString("Usuario", "invitado");
        this.edadR = preferences.getString("Edad", "");
        this.generoR = preferences.getString("Genero", "");
        this.estadoR = preferences.getString("Estado", "");
        this.municipioR = preferences.getString("Municipio", "");
        this.escuelaR = preferences.getString("Escuela", "");
        this.correoR = preferences.getString("Correo", "Invitado");
        this.codigoR = preferences.getString("Codigo", "");



    }

    public void imprimirDatos(){
        tvUsuario.setText(usuarioR);
        tvEdad.setText(edadR);
        tvGenero.setText(generoR);
        tvEstado.setText(estadoR);
        tvMunicipio.setText(municipioR);
        tvEscuela.setText(escuelaR);
        tvCorreo.setText(correoR);
        tvCodigo.setText(codigoR);
    }

}
