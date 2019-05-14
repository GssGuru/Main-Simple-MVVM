package guru.gss.mytestapplication.model.repository.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

import guru.gss.mytestapplication.MyApp;
import io.reactivex.Completable;
import io.reactivex.Single;


public class PreferenceRepositoryImpl implements PreferenceRepository {

    public static final String VALUE_FOR_FILTER = "valueForFilter";

    private final SharedPreferences mPref;

    @Inject
    public PreferenceRepositoryImpl() {
        mPref = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext());
    }

    @Override
    public Completable setValue(String key, Object value) {
        return null;
    }

    @Override
    public Single<SharedPreferences> getValue() {
        return null;
    }

    @Override
    public Completable remove(String key) {
        return null;
    }

    @Override
    public Single<Boolean> isValueExist(String key) {
        return null;
    }

//    /**
//     * Установить значение в SharedPreferences
//     */
//    @Override
//    public void setValue(String key, Object value) {
//        SharedPreferences.Editor editor = mPref.edit();
//        if (value instanceof String) {
//            String val = (String) value;
//            editor.putString(key, val);
//        }
//        if (value instanceof Integer) {
//            Integer val = (Integer) value;
//            editor.putInt(key, val);
//        }
//        if (value instanceof Boolean) {
//            Boolean val = (Boolean) value;
//            editor.putBoolean(key, val);
//        }
//        editor.apply();
//    }
//
//    /**
//     * Взять значение с SharedPreferences
//     */
//    @Override
//    public SharedPreferences getValue() {
//        return mPref;
//    }
//
//    /**
//     * Удалить значение в SharedPreferences
//     */
//    @Override
//    public void remove(String key){
//        mPref.edit().remove(key).apply();
//    }
//
//    /**
//     * Проверить сужествует ли значение в SharedPreferences
//     */
//    @Override
//    public boolean isValueExist(String key){
//        return mPref.contains(key);
//    }
}
