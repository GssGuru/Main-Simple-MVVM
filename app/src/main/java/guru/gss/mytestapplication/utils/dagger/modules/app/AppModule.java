package guru.gss.mytestapplication.utils.dagger.modules.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import guru.gss.mytestapplication.model.repository.network.client.RetrofitClient;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepository;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepositoryImpl;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepositoryImpl;
import guru.gss.mytestapplication.utils.rx.RxSchedulers;
import guru.gss.mytestapplication.utils.rx.RxSchedulersImpl;

@Module
public class AppModule {

    @Provides
    @Singleton
    public RetrofitClient provideRetrofitClient() {
        return RetrofitClient.getInstance();
    }

    @Provides
    @Singleton
    public NetworkRepository provideNetworkInteractor() {
        return new NetworkRepositoryImpl();
    }

    @Provides
    @Singleton
    public PreferenceRepositoryImpl provideSharedPrefsRepository() {
        return new PreferenceRepositoryImpl();
    }

    @Provides
    @Singleton
    public RxSchedulersImpl provideRxSchedlers() {
        return new RxSchedulers();
    }

}
