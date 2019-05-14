package guru.gss.mytestapplication.model.repository.preference;

import android.content.SharedPreferences;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PreferenceRepository {

    /**
     * Установить значение в SharedPreferences
     */
//    void setValue(String key, Object value);
    Completable setValue(String key, Object value);

    /**
     * Взять значение с SharedPreferences
     */
//    SharedPreferences getValue();
    Single<SharedPreferences> getValue();

    /**
     * Удалить значение в SharedPreferences
     */
//    void remove(String key);
    Completable remove(String key);

    /**
     * Проверить сужествует ли значение в SharedPreferences
     */
//    boolean isValueExist(String key);
    Single<Boolean> isValueExist(String key);

}
