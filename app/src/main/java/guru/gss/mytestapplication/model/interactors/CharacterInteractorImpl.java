package guru.gss.mytestapplication.model.interactors;

import java.util.ArrayList;
import java.util.List;

import guru.gss.mytestapplication.model.repository.database.AppDatabase;
import guru.gss.mytestapplication.model.repository.database.dao.CharacterDao;
import guru.gss.mytestapplication.model.repository.network.impl.NetworkRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepository;
import guru.gss.mytestapplication.model.repository.preference.PreferenceRepositoryImpl;
import guru.gss.mytestapplication.utils.rx.RxSchedulersImpl;
import io.reactivex.Completable;
import io.reactivex.Single;

public class CharacterInteractorImpl implements Interactor.CharacterInteractor {

    private RxSchedulersImpl rxSchedulers;
    private NetworkRepository networkRepository;
    private PreferenceRepository pref;
    private CharacterDao characterDao;
    public List<guru.gss.mytestapplication.utils.models.Character> list;
    public String myString = "ghbdtn";

    public CharacterInteractorImpl(PreferenceRepositoryImpl pref, RxSchedulersImpl rxSchedulers, NetworkRepository networkRepository, AppDatabase db) {
        this.pref = pref;
        this.rxSchedulers = rxSchedulers;
        this.networkRepository = networkRepository;
        characterDao = db.characterDao();
        list = new ArrayList<>();
    }

    @Override
    public Single<List<guru.gss.mytestapplication.utils.models.Character>> getList(int page) {
        return networkRepository.getListCharacters();
    }

    @Override
    public Completable setValueForFilter(String value) {
        return pref.setValue(PreferenceRepositoryImpl.VALUE_FOR_FILTER, value);
    }

    @Override
    public String getMyString() {
        return myString;
    }

}
