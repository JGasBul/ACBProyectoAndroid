package educacion.trax.acbproyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Busquedas extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedas);
        final Button allAlum=findViewById(R.id.allAlum);
        allAlum.setOnClickListener(this);
        final Button cicloAllum=findViewById(R.id.cicloalum);
        cicloAllum.setOnClickListener(this);
        final Button cursoAllm=findViewById(R.id.cursoAllum);
        cursoAllm.setOnClickListener(this);
        final Button allProf=findViewById(R.id.allProf);
        allProf.setOnClickListener(this);
        final Button todos=findViewById(R.id.todos);
        todos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.allAlum){
            Intent i=new Intent(getApplicationContext(),AllAlum.class);
            startActivity(i);
        }
        if (v.getId()==R.id.cicloalum){
            Intent i=new Intent(getApplicationContext(),CicloAllum.class);
            startActivity(i);
        }
        if (v.getId()==R.id.cursoAllum){
            Intent i=new Intent(getApplicationContext(),CursoAllum.class);
            startActivity(i);
        }
        if (v.getId()==R.id.allProf){
            Intent i=new Intent(getApplicationContext(),AllProf.class);
            startActivity(i);
        }
        if (v.getId()==R.id.todos){
            Intent i=new Intent(getApplicationContext(),todos.class);
            startActivity(i);
        }
    }
}
