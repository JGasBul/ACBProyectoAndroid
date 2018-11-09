package educacion.trax.acbproyectoandroid;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
   MyDBAdapter table=new MyDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button config=findViewById(R.id.config);
        final Button est=findViewById(R.id.est);
        final Button profe=findViewById(R.id.prof);
        final Button busquedas=findViewById(R.id.busquedas);
        table.open();
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingsClass.class);
                startActivity(i);
            }
        });
        est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Estudiante.class);
                startActivityForResult(i,1);
            }
        });
        profe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Profesor.class);
                startActivityForResult(i,2);
            }
        });
        busquedas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Busquedas.class);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Bundle b=data.getExtras();
                ClaseEstudiante esttemp=b.getParcelable("estudiante");
                String nom=esttemp.getNom();
                int edad= Integer.parseInt(esttemp.getEdad());
                String ciclo=esttemp.getCiclo();
                int curso=Integer.parseInt(esttemp.getCurso());
                Float nota_media=Float.parseFloat(esttemp.getN_m());
                table.insertarAlumno(nom,edad,ciclo,curso,nota_media);

            }
        }
        if(requestCode==2){
            if(resultCode==RESULT_OK){
                Bundle b=data.getExtras();
                ClaseProfesor profetemp=b.getParcelable("profesor");
                String nom=profetemp.getNom();
                int edad= Integer.parseInt(profetemp.getEdad());
                String ciclo=profetemp.getCiclo();
                int curso= Integer.parseInt(profetemp.getCurso());
                String despacho=profetemp.getDesspacho();
                table.insertarProfe(nom,edad,ciclo,curso,despacho);
            }
        }
    }
}
