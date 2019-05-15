package guru.gss.mytestapplication.model.repository.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

import guru.gss.mytestapplication.MyApp;
import guru.gss.mytestapplication.utils.LoggerUtils;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
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
        return new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver s) {
                try {
                    SharedPreferences.Editor editor = mPref.edit();
                    if (value instanceof String) {
                        String val = (String) value;
                        editor.putString(key, val);
                    }
                    if (value instanceof Integer) {
                        Integer val = (Integer) value;
                        editor.putInt(key, val);
                    }
                    if (value instanceof Boolean) {
                        Boolean val = (Boolean) value;
                        editor.putBoolean(key, val);
                    }
                    editor.apply();
                } catch (Exception e) {
                    LoggerUtils.errorLog(getClass().getName(), e);
                }
            }
        };
    }

    @Override
    public Completable remove(String key) {
        return new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver s) {
                try {
                    mPref.edit().remove(key).apply();
                } catch (Exception e) {
                    LoggerUtils.errorLog(getClass().getName(), e);
                }
            }
        };
    }

    @Override
    public Single<Boolean> isValueExist(String key) {
        return Single.fromCallable(() -> {
            try {
                return mPref.contains(key);
            } catch (Exception e) {
                LoggerUtils.errorLog(getClass().getName(), e);
                return false;
            }
        });
    }

    @Override
    public Single<SharedPreferences> getValue() {
        return Single.fromCallable(() -> mPref);
    }
}
