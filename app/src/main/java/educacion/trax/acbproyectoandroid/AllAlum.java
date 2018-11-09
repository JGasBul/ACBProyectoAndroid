package educacion.trax.acbproyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class AllAlum extends AppCompatActivity {
    MyDBAdapter table=new MyDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alum);
        final TextView mostrar=findViewById(R.id.mostrar);
        table.open();
        ArrayList<String> alumnos =table.recuperarAlumnos();
        Iterator it=alumnos.iterator();
        while(it.hasNext()){
            String alumno= String.valueOf(it.next());
            mostrar.setText(mostrar.getText()+"\n"+alumno);
        }
    }
}
