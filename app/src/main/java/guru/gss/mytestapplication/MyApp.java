package guru.gss.mytestapplication;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import guru.gss.mytestapplication.model.repository.database.AppDatabase;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppComponent;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppModule;
import guru.gss.mytestapplication.utils.dagger.modules.app.DaggerAppComponent;

public class MyApp extends DaggerApplication {

    public static MyApp instance;
    private static Context mContext;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }

    public static Context getContext(){
        return mContext;
    }

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .appModule(new AppModule())
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    public AppDatabase getDatabase() {
        return database;
    }

}
