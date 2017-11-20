package es.albertoheredia.apppizzeria;

        import android.content.Intent;
        import android.content.res.Configuration;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.nio.file.Files;
        import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button acceder;
    EditText et_usuario, et_password;

    static final String USER = "user";
    static final String PASS ="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DeclararComponentes();


    }


    private void DeclararComponentes(){
        acceder = (Button)findViewById(R.id.btnAcceder);
        et_usuario = (EditText) findViewById(R.id.ma_et_usuario);
        et_password = (EditText) findViewById(R.id.ma_et_password);

        /* Eventos de los componentes*/
        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = et_password.getText().toString();
                String user = et_usuario.getText().toString();

                if(user.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos", Toast.LENGTH_LONG).show();
                }else{

                    if(user.equals(USER) && password.equals(PASS)){
                        Intent i = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                        i.putExtra("usuario", USER);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "La contraseña y/o usuario no son correctos", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }






}
