package educacion.trax.acbproyectoandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pepeg on 07/11/2018.
 */

public class ClaseEstudiante implements Parcelable {
    private String nom;
    private String edad;
    private String ciclo;
    private String curso;
    private String n_m;

    public ClaseEstudiante(String nom, String edad, String ciclo, String curso, String n_m) {
        this.nom = nom;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
        this.n_m = n_m;
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

    public String getN_m() {
        return n_m;
    }

    public void setN_m(String n_m) {
        this.n_m = n_m;
    }

    protected ClaseEstudiante(Parcel in) {
        nom = in.readString();
        edad = in.readString();
        ciclo = in.readString();
        curso = in.readString();
        n_m = in.readString();
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
        dest.writeString(n_m);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ClaseEstudiante> CREATOR = new Parcelable.Creator<ClaseEstudiante>() {
        @Override
        public ClaseEstudiante createFromParcel(Parcel in) {
            return new ClaseEstudiante(in);
        }

        @Override
        public ClaseEstudiante[] newArray(int size) {
            return new ClaseEstudiante[size];
        }
    };
}
