package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import es.albertoheredia.apppizzeria.Clases.Tamano;

/**
 * Created by Alberto on 14/11/2017.
 */

public class PropiasActivity extends AppCompatActivity {

    Button especialidades, terminar;
    ArrayList<Tamano> tamanos = new ArrayList<>();
    CheckBox cbPimiento, cbChampinone, cbPollo, cbBacon, cbCebolla, cbQueso, cbPina, cbPicada, cbTomate, cbTernera, cbAtun, cbPeperonni;
    RadioGroup gruopTam;
    final Double PRECIO_INGREDIENTE = 0.5;
    boolean tieneIngrediente = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propias);
        declararComponentes();
    }

    private void declararComponentes() {
        GenerarTamanos();
        especialidades = (Button)findViewById(R.id.btnEspecialidad);
        gruopTam = (RadioGroup)findViewById(R.id.rGTamano);
        terminar = (Button)findViewById(R.id.btnTerminar);
        cbPimiento = (CheckBox)findViewById(R.id.cBPimiento);
        cbChampinone = (CheckBox)findViewById(R.id.cBChampinone);
        cbPollo = (CheckBox)findViewById(R.id.cBPollo);
        cbBacon = (CheckBox)findViewById(R.id.cBBacon);
        cbCebolla = (CheckBox)findViewById(R.id.cBCebolla);
        cbQueso = (CheckBox)findViewById(R.id.cBQueso);
        cbPina = (CheckBox)findViewById(R.id.cBPina);
        cbPicada = (CheckBox)findViewById(R.id.cBPicada);
        cbTomate = (CheckBox)findViewById(R.id.cBTomate);
        cbTernera = (CheckBox)findViewById(R.id.cBTernera);
        cbAtun = (CheckBox)findViewById(R.id.cBAtun);
        cbPeperonni = (CheckBox)findViewById(R.id.cbPeperonni);


                especialidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PizzasActivity.class);
                startActivity(i);

            }
        });

        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> lista_ingredientes = new ArrayList<>();

                if(cbQueso.isChecked()){
                    lista_ingredientes.add("Queso");
                    tieneIngrediente = true;
                }
                if(cbBacon.isChecked()){
                    lista_ingredientes.add("Bacon");
                    tieneIngrediente = true;
                }
                if(cbPimiento.isChecked()){
                    lista_ingredientes.add("Pimiento");
                    tieneIngrediente = true;
                }
                if(cbChampinone.isChecked()){
                    lista_ingredientes.add("Champiñones");
                    tieneIngrediente = true;
                }
                if(cbPollo.isChecked()){
                    lista_ingredientes.add("Pollo");
                    tieneIngrediente = true;
                }
                if(cbCebolla.isChecked()){
                    lista_ingredientes.add("Cebolla");
                    tieneIngrediente = true;
                }
                if(cbPina.isChecked()){
                    lista_ingredientes.add("Piña");
                    tieneIngrediente = true;
                }
                if(cbPicada.isChecked()){
                    lista_ingredientes.add("Carne Picada");
                    tieneIngrediente = true;
                }
                if(cbTomate.isChecked()){
                    lista_ingredientes.add("Tomate");
                    tieneIngrediente = true;
                }
                if(cbTernera.isChecked()){
                    lista_ingredientes.add("Ternera");
                    tieneIngrediente = true;
                }
                if(cbAtun.isChecked()){
                    lista_ingredientes.add("Atún");
                    tieneIngrediente = true;
                }
                if(cbPeperonni.isChecked()){
                    lista_ingredientes.add("Peperonni");
                    tieneIngrediente = true;
                }

                if(tieneIngrediente) {
                    double total_ingredientes = lista_ingredientes.size() * PRECIO_INGREDIENTE;

                    int radioSelecionado = gruopTam.getCheckedRadioButtonId();
                    RadioButton rb = (RadioButton) findViewById(radioSelecionado);
                    String tam = rb.getText().toString();

                    double precio_tam = DevolverPrecioTamano(tam);

                    double precio_final = total_ingredientes + precio_tam;

                    String ingredientes = "";
                    for (int x = 0; x < lista_ingredientes.size(); x++) {
                        if (x == lista_ingredientes.size() - 1) {
                            ingredientes += lista_ingredientes;
                        }
                    }

                    Intent i = new Intent(getApplicationContext(), TerminarActivity.class);
                    i.putExtra("precio", precio_final);
                    i.putExtra("nombre", ingredientes);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Tienes que colocar al menos un ingrediente", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private double DevolverPrecioTamano(String nombre){
        for ( int i=0; i<tamanos.size(); i++){
            if(tamanos.get(i).getNombre().equals(nombre)){
                return tamanos.get(i).getPrecio();
            }
        }
        return 0;
    }
    private void GenerarTamanos() {

        tamanos.add(new Tamano("Pequeña", 6.75));
        tamanos.add(new Tamano("Mediana", 9.50));
        tamanos.add(new Tamano("Familiar", 12));

    }
}
