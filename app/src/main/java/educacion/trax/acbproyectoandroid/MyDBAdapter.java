package educacion.trax.acbproyectoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jmalberola.
 */
public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "clase.db";
    private static final String DATABASE_TABLE_PROFE = "profes";
    private static final String DATABASE_TABLE_ALUMNO = "alumnos";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_PROFE = "CREATE TABLE "+DATABASE_TABLE_PROFE+" (_id integer primary key autoincrement, nom text, edad integer,ciclo text,curso integer,despacho integer);";
    private static final String DATABASE_CREATE_ALUMNO = "CREATE TABLE "+DATABASE_TABLE_ALUMNO+" (_id integer primary key autoincrement, nom text, edad integer,ciclo text,curso integer,nota_media float);";
    private static final String DATABASE_DROP_PROFE = "DROP TABLE IF EXISTS "+DATABASE_TABLE_PROFE+";";
    private static final String DATABASE_DROP_ALUMNO = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ALUMNO+";";



    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarProfe(String nom, int edad,String ciclo,int curso,String despacho){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put("nom",nom);
        newValues.put("edad",edad);
        newValues.put("ciclo",ciclo);
        newValues.put("curso",curso);
        newValues.put("despacho",despacho);

        db.insert(DATABASE_TABLE_PROFE,null,newValues);
    }
    public void insertarAlumno(String nom, int edad,String ciclo,int curso,float nota_media){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put("nom",nom);
        newValues.put("edad",edad);
        newValues.put("ciclo",ciclo);
        newValues.put("curso",curso);
        newValues.put("nota_media",nota_media);

        db.insert(DATABASE_TABLE_ALUMNO,null,newValues);
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_PROFE);
            db.execSQL(DATABASE_CREATE_ALUMNO);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP_PROFE);
            db.execSQL(DATABASE_DROP_ALUMNO);
            onCreate(db);
        }

    }
}