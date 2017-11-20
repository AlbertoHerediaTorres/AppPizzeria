package es.albertoheredia.apppizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;

import es.albertoheredia.apppizzeria.Clases.*;

/**
 * Created by H on 13/11/2017.
 */

public class PizzasActivity extends AppCompatActivity {

    Button personalizar, terminar;
    ArrayList<Especialidad> pizzas_especialidades =new ArrayList<Especialidad>();
    ArrayList<Tamano> tamanos = new ArrayList<>();
    RadioGroup gruopTam;
    Especialidad e=null;


    boolean esEspecialidad=false;
    ListView lvEspecialidades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);
        DeclararElementos();
        GenerarPizzasEspecialidades();








    }

    private void DeclararElementos(){
        personalizar = (Button)findViewById(R.id.btnPersonalizar);
        gruopTam = (RadioGroup)findViewById(R.id.rGTamano);
        terminar = (Button)findViewById(R.id.btnTerminar);
        lvEspecialidades = (ListView)findViewById(R.id.lv_especialidad);


          e = new Especialidad();

        personalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), PropiasActivity.class);
                startActivity(i1);

            }
        });


        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(esEspecialidad){

                    int radioSelecionado = gruopTam.getCheckedRadioButtonId();
                    RadioButton rb = (RadioButton)findViewById(radioSelecionado);
                    String tam = rb.getText().toString();

                    double precio_tam =DevolverPrecioTamano(tam);
                    String nombre_especialidad = e.getNombre();
                    double precio_pizza =DevolverPrecioEspecialidad(nombre_especialidad);

                    double precio_final = precio_pizza + precio_tam;

                    Intent i = new Intent(getApplicationContext(), TerminarActivity.class);
                    i.putExtra("precio",precio_final);
                    i.putExtra("nombre",nombre_especialidad);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Debes de seleccionar una especialidad", Toast.LENGTH_LONG).show();
                }


            }
        });



         lvEspecialidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String nombre_especialidad =  parent.getAdapter().getItem(position).toString();
                 e.setNombre(nombre_especialidad);

                 esEspecialidad=true;

             }
         });

    }

    private double DevolverPrecioEspecialidad(String nombre){
        for ( int i=0; i<pizzas_especialidades.size(); i++){
            if(pizzas_especialidades.get(i).getNombre().equals(nombre)){
                return pizzas_especialidades.get(i).getPrecio();
            }
        }
        return 0;
    }
    private double DevolverPrecioTamano(String nombre){
        for ( int i=0; i<tamanos.size(); i++){
            if(tamanos.get(i).getNombre().equals(nombre)){
                return tamanos.get(i).getPrecio();
            }
        }
        return 0;
    }
    private void GenerarPizzasEspecialidades(){

        tamanos.add(new Tamano("Pequeña",6.75));
        tamanos.add(new Tamano("Mediana",9.50));
        tamanos.add(new Tamano("Familiar",12));

        pizzas_especialidades.add(new Especialidad("Carbonara",1.50));
        pizzas_especialidades.add(new Especialidad("Hawaiana",1.20));
        pizzas_especialidades.add(new Especialidad("Barbacoa",2.10));
        pizzas_especialidades.add(new Especialidad("Mexicana",1.50));
        pizzas_especialidades.add(new Especialidad("Jerezana",0.25));
        pizzas_especialidades.add(new Especialidad("Romana",1));
        pizzas_especialidades.add(new Especialidad("Piñada",0));

        String[] nombre_especialidades = new String[pizzas_especialidades.size()];

        for (int i=0; i<pizzas_especialidades.size(); i++){
            nombre_especialidades[i] = pizzas_especialidades.get(i).getNombre();
        }

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, nombre_especialidades);


        lvEspecialidades.setAdapter(adaptador);
    }
}
