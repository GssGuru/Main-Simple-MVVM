package guru.gss.mytestapplication.model.interactors;

import java.util.List;

import guru.gss.mytestapplication.utils.models.Character;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface Interactor {
    interface Сharacter {
        Single<List<Character>> getList(int page);
        Completable setValueForFilter(String value);
    }
}
