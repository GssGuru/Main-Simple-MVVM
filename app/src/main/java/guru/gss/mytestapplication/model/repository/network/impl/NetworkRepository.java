package guru.gss.mytestapplication.model.repository.network.impl;



import java.util.List;

import guru.gss.mytestapplication.utils.models.Character;
import guru.gss.mytestapplication.utils.models.Location;
import io.reactivex.Single;

public interface NetworkRepository {

    Single<List<Character>> getListCharacters();

    Single<List<Location>> getListLocations();

}
