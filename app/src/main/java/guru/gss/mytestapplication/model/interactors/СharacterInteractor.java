package guru.gss.mytestapplication.model.interactors;

import java.util.List;

import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepositoryImpl;
import guru.gss.mytestapplication.utils.models.Character;
import guru.gss.mytestapplication.utils.rx.RxSchedulersImpl;
import io.reactivex.Completable;
import io.reactivex.Single;

public class СharacterInteractor implements Interactor.Сharacter {

    private RxSchedulersImpl rxSchedulers;
    private NetworkRepository networkRepository;
    private PreferenceRepository pref;

    public СharacterInteractor(PreferenceRepositoryImpl pref, RxSchedulersImpl rxSchedulers, NetworkRepository networkRepository) {
        this.pref = pref;
        this.rxSchedulers = rxSchedulers;
        this.networkRepository = networkRepository;
    }

    @Override
    public Single<List<Character>> getList(int page) {
        return networkRepository.getListCharacters();
    }

    @Override
    public Completable setValueForFilter(String value) {
        return pref.setValue(PreferenceRepositoryImpl.VALUE_FOR_FILTER, value);
    }
}
