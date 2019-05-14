package guru.gss.mytestapplication.utils.dagger.modules.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import guru.gss.mytestapplication.MyApp;
import guru.gss.mytestapplication.model.repository.network.client.RetrofitClient;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepositoryImpl;
import guru.gss.mytestapplication.utils.dagger.modules.character.СharacterComponent;
import guru.gss.mytestapplication.utils.dagger.modules.character.СharacterModule;


@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(RetrofitClient retrofitClient);
    void inject(NetworkRepositoryImpl network);
    void inject(MyApp app);

    СharacterComponent plus(СharacterModule module);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        @BindsInstance
        Builder appModule(AppModule appModule);
        AppComponent build();
    }
}
