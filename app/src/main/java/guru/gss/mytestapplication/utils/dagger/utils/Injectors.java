package guru.gss.mytestapplication.utils.dagger.utils;

import android.content.Context;

import java.util.Map;
import java.util.WeakHashMap;

import guru.gss.mytestapplication.MyApp;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppComponent;
import guru.gss.mytestapplication.utils.dagger.modules.app.AppModule;
import guru.gss.mytestapplication.utils.dagger.modules.app.DaggerAppComponent;

public final class Injectors {

    private static final Map<Context, AppComponent> sComponents = new WeakHashMap<>();

    private Injectors() { }

    public static AppComponent get(Context context) {
        context = context.getApplicationContext();
        AppComponent component = sComponents.get(context);
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .application((MyApp) context.getApplicationContext())
                    .appModule(new AppModule())
                    .build();
            sComponents.put(context, component);
        }

        return component;
    }
}
