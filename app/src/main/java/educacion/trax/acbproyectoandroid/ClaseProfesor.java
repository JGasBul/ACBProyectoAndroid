package educacion.trax.acbproyectoandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pepeg on 08/11/2018.
 */

public class ClaseProfesor implements Parcelable {
    private String nom;
    private String edad;
    private String ciclo;
    private String curso;
    private String desspacho;

    public ClaseProfesor(String nom, String edad, String ciclo, String curso, String desspacho) {
        this.nom = nom;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
        this.desspacho = desspacho;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDesspacho() {
        return desspacho;
    }

    public void setDesspacho(String desspacho) {
        this.desspacho = desspacho;
    }

    protected ClaseProfesor(Parcel in) {
        nom = in.readString();
        edad = in.readString();
        ciclo = in.readString();
        curso = in.readString();
        desspacho = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(edad);
        dest.writeString(ciclo);
        dest.writeString(curso);
        dest.writeString(desspacho);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ClaseProfesor> CREATOR = new Parcelable.Creator<ClaseProfesor>() {
        @Override
        public ClaseProfesor createFromParcel(Parcel in) {
            return new ClaseProfesor(in);
        }

        @Override
        public ClaseProfesor[] newArray(int size) {
            return new ClaseProfesor[size];
        }
    };
}