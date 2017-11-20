package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by H on 13/11/2017.
 */

public class PedirActivity extends AppCompatActivity {

    Button recoger, domicilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);

        recoger = (Button)findViewById(R.id.btnRecoger);
        domicilio = (Button)findViewById(R.id.btnDomicilio);


        recoger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tipo_envio","recoger");
                editor.apply();

                Intent i = new Intent(getApplicationContext(), PizzasActivity.class);
                startActivity(i);

            }
        });

        domicilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tipo_envio","domicilio");
                editor.apply();

                Intent i = new Intent(getApplicationContext(),DatosActivity.class);
                startActivity(i);

            }
        });

    }
}
