package educacion.trax.acbproyectoandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;



public class SettingsClass extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("nom")){
            String nom=sharedPreferences.getString(key,"No seleccionado");
            Preference pref_nom=findPreference(key);
            pref_nom.setSummary(nom);
        }
        if(key.equals("user")){
            String user=sharedPreferences.getString(key,"No seleccionado");
            Preference pref_user=findPreference(key);
            pref_user.setSummary(user);
        }
        if(key.equals("fecha")){
            String fecha=sharedPreferences.getString(key,"No seleccionado");
            Preference pref_fecha=findPreference(key);
            pref_fecha.setSummary(fecha);
        }
        if(key.equals("genero")){
            String genero=sharedPreferences.getString(key,"No seleccionado");
            Preference pref_sex=findPreference(key);
            pref_sex.setSummary(genero);
        }
    }
}
