package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MenuPrincipalActivity extends AppCompatActivity {

    Button pedir, configurar, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        DeclararComponentes();
        Bundle b=getIntent().getExtras();
        if(b!=null){
            String nombre_usuario = b.getString("usuario");
            setTitle("Hola, "+nombre_usuario);
        }

    }


    private void DeclararComponentes(){
        pedir = (Button)findViewById(R.id.btnPedir);
        configurar = (Button)findViewById(R.id.btnConfigurar);
        salir = (Button)findViewById(R.id.btnSalir);



        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PedirActivity.class);
                startActivity(i);
            }
        });

        configurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ConfigurarActivity.class);
                startActivity(i);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
