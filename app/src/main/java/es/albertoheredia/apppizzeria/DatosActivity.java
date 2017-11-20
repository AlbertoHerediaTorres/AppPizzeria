package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alberto on 14/11/2017.
 */

public class DatosActivity extends AppCompatActivity {

    Button siguiente;
    EditText et_telefono, et_direccion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        declararBotones();

    }

    private void declararBotones(){
        siguiente = (Button)findViewById(R.id.btnSiguiente);
        et_telefono = (EditText) findViewById(R.id.da_et_telefono);
        et_direccion = (EditText) findViewById(R.id.da_et_direccion);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String telefono = et_telefono.getText().toString();
                String dirección = et_direccion.getText().toString();

                if(telefono.equals("") || dirección.equals("")){
                    Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos", Toast.LENGTH_LONG).show();
                }else {
                    if(telefono.length()==9){
                        if(telefono.charAt(0)=='6' || telefono.charAt(0)=='7' || telefono.charAt(0)=='8' || telefono.charAt(0)=='9'){
                            Intent i = new Intent(getApplicationContext(), PizzasActivity.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), "Formato erroneo. Telefono no valido", Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), "Longitud erronea. Telefono no valido", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }
}
