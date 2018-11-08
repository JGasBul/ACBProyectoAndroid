package educacion.trax.acbproyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profesor extends AppCompatActivity {
    private ClaseProfesor prof;
    String nom,edad,ciclo,curso,despacho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        final EditText nomET=findViewById(R.id.nom);
        final EditText edadET=findViewById(R.id.edad);
        final EditText cicloET=findViewById(R.id.ciclo);
        final EditText cursoET=findViewById(R.id.curso);
        final EditText despachoET=findViewById(R.id.despacho);
        final Button aceptar=(Button) findViewById(R.id.aceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom= String.valueOf(nomET.getText());
                edad=String.valueOf(edadET.getText());
                ciclo=String.valueOf(cicloET.getText());
                curso=String.valueOf(cursoET.getText());
                despacho=String.valueOf(despachoET.getText());
                prof=new ClaseProfesor(nom,edad,ciclo,curso,despacho);
                Intent i=new Intent();
                Bundle b=new Bundle();
                b.putParcelable("profesor",prof);
                i.putExtras(b);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
