package guru.gss.mytestapplication.utils.dagger.modules.character;

import dagger.Module;
import dagger.Provides;
import guru.gss.mytestapplication.model.interactors.Interactor;
import guru.gss.mytestapplication.model.interactors.СharacterInteractor;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepositoryImpl;
import guru.gss.mytestapplication.utils.rx.RxSchedulersImpl;

@Module
public class СharacterModule {

    @Provides
    Interactor.Сharacter provideRegistrationViewInteractor(NetworkRepository networkRepository, PreferenceRepositoryImpl prefsRepository, RxSchedulersImpl rxSchedulers) {
        return new СharacterInteractor(prefsRepository, rxSchedulers, networkRepository);
    }

}
