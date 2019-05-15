package guru.gss.mytestapplication.utils.dagger.modules.character;

import dagger.Module;
import dagger.Provides;
import guru.gss.mytestapplication.model.interactors.CharacterInteractorImpl;
import guru.gss.mytestapplication.model.interactors.Interactor;
import guru.gss.mytestapplication.model.repository.database.AppDatabase;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepositoryImpl;
import guru.gss.mytestapplication.utils.rx.RxSchedulersImpl;

@Module
public class СharacterModule {

    @Provides
    Interactor.CharacterInteractor provideRegistrationViewInteractor(NetworkRepository networkRepository, PreferenceRepositoryImpl prefsRepository, RxSchedulersImpl rxSchedulers, AppDatabase db) {
        return new CharacterInteractorImpl(prefsRepository, rxSchedulers, networkRepository, db);
    }

}
