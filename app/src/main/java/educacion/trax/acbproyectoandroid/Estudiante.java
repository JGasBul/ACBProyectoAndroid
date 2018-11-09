package educacion.trax.acbproyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Estudiante extends AppCompatActivity {
    private ClaseEstudiante est;
    String nom,edad,ciclo,curso,nota_media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        final EditText nomET=findViewById(R.id.nom);
        final EditText edadET=findViewById(R.id.edad);
        final EditText cicloET=findViewById(R.id.busqueda);
        final EditText cursoET=findViewById(R.id.cursos);
        final EditText nota_mediaET=findViewById(R.id.nota_media);
        final Button aceptar=(Button) findViewById(R.id.maincra);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom= String.valueOf(nomET.getText());
                edad=String.valueOf(edadET.getText());
                ciclo=String.valueOf(cicloET.getText());
                curso=String.valueOf(cursoET.getText());
                nota_media=String.valueOf(nota_mediaET.getText());
                est=new ClaseEstudiante(nom,edad,ciclo,curso,nota_media);
                Intent i=new Intent();
                Bundle b=new Bundle();
                b.putParcelable("estudiante",est);
                i.putExtras(b);
                setResult(RESULT_OK,i);
                finish();
            }
        });



    }
}
