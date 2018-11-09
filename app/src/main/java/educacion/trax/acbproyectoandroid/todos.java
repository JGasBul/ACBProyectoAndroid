package educacion.trax.acbproyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class todos extends AppCompatActivity {
    MyDBAdapter table=new MyDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        final TextView mostrar=findViewById(R.id.mostrar);
        table.open();
        ArrayList<String> alumnos =table.recuperarAlumnos();
        ArrayList<String> profes =table.recuperarProfes();
        Iterator it=alumnos.iterator();
        while(it.hasNext()){
            String alumno= String.valueOf(it.next());
            mostrar.setText(mostrar.getText()+"\n"+alumno);
        }
        Iterator it2=profes.iterator();
        while(it2.hasNext()){
            String profesS= String.valueOf(it.next());
            mostrar.setText(mostrar.getText()+"\n"+profesS);
        }
    }
}
