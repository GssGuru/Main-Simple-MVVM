package guru.gss.mytestapplication;

import android.content.Context;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppComponent;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppModule;
import guru.gss.mytestapplication.utils.dagger.modules.app.DaggerAppComponent;

public class MyApp extends DaggerApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
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

}
