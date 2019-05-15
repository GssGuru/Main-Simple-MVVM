package guru.gss.mytestapplication.model.interactors;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import guru.gss.mytestapplication.utils.models.Character;

public interface Interactor {
    interface CharacterInteractor {
        Single<List<Character>> getList(int page);
        Completable setValueForFilter(String value);
        String getMyString();
    }
}
