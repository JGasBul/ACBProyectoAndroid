package educacion.trax.acbproyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class CicloAllum extends AppCompatActivity {
    MyDBAdapter table=new MyDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_allum);
        final TextView mostrar=findViewById(R.id.result);
        final TextView ciclo=findViewById(R.id.busqueda);
        table.open();
        final Button buscar=findViewById(R.id.buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar.setText("");
                String cicloS= String.valueOf(ciclo.getText());
                ArrayList<String> alumnos =table.recuperarAlumnoCiclo(cicloS);
                Iterator it=alumnos.iterator();
                while(it.hasNext()){
                    String alumno= String.valueOf(it.next());
                    mostrar.setText(""+mostrar.getText()+"\n"+alumno);
                }
            }
        });

    }
}
