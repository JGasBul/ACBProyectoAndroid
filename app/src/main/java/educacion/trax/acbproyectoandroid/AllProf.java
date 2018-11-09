package educacion.trax.acbproyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class AllProf extends AppCompatActivity {
    MyDBAdapter table=new MyDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_prof);
        table.open();
        final TextView mostrar=findViewById(R.id.mostrar);
        ArrayList<String> profes =table.recuperarProfes();
        Iterator it=profes.iterator();
        while(it.hasNext()){
            String profesS= String.valueOf(it.next());
            mostrar.setText(mostrar.getText()+"\n"+profesS);
        }
    }
}
