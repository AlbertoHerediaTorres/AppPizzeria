package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by Alberto on 14/11/2017.
 */

public class ConfigurarActivity extends AppCompatActivity {

    Button esp, eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);
        DeclararComponentes();

    }

    private void DeclararComponentes(){
        esp = (Button)findViewById(R.id.btnEsp);
        eng = (Button)findViewById(R.id.btnEng);

        esp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("idioma","es");
                editor.apply();*/
                setLocale("es");
                Intent i = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                startActivity(i);
            }
        });

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setLocale("en");
                Intent i = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                startActivity(i);
            }
        });





    }

    private void setLocale(String localeCode){
        Locale locale = new Locale(localeCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
