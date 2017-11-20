package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Alberto on 14/11/2017.
 */

public class TerminarActivity extends AppCompatActivity {

    Button terminarPedido;
    TextView tvPizza, tvPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminar);
        declararComponentes();
        Bundle b=getIntent().getExtras();
        if(b!=null){
            String nombre_pizza = b.getString("nombre");
            Double precio_pizza = b.getDouble("precio");

            tvPizza.setText("PIZZA: "+nombre_pizza);

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String envio = prefs.getString("tipo_envio","");

            if(envio.equals("domicilio")){
                precio_pizza += 3;
            }
            tvPrecio.setText("TOTAL: "+precio_pizza + " €");

        }

    }

    private void declararComponentes(){
        terminarPedido = (Button)findViewById(R.id.btnTerminarPedido);
        tvPizza = (TextView) findViewById(R.id.tvPizza);
        tvPrecio = (TextView)findViewById(R.id.tVPrecio);



        terminarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "¡Pedido enviado correctamente! ¡¡¡En unos minutos su pizza irá al horno!!!", Toast.LENGTH_LONG).show();

            }
        });

    }

}
