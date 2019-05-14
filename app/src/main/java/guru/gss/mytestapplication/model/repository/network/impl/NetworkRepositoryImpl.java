package guru.gss.mytestapplication.model.repository.network.impl;


import java.util.List;

import javax.inject.Inject;

import guru.gss.mytestapplication.MyApp;
import guru.gss.mytestapplication.model.repository.network.client.RetrofitClient;
import guru.gss.mytestapplication.utils.dagger.utils.Injectors;
import guru.gss.mytestapplication.utils.models.Character;
import guru.gss.mytestapplication.utils.models.CharacterResponse;
import guru.gss.mytestapplication.utils.models.Location;
import guru.gss.mytestapplication.utils.models.LocationsResponse;
import io.reactivex.Single;

public class NetworkRepositoryImpl implements NetworkRepository {

    @Inject
    RetrofitClient restClient;

    public NetworkRepositoryImpl() {
        Injectors.get(MyApp.getContext()).inject(this);
    }

    @Override
    public Single<List<Character>> getListCharacters() {
        return restClient.getApiService().getListCharacters().map(CharacterResponse::getResults);
    }

    @Override
    public Single<List<Location>> getListLocations() {
        return restClient.getApiService().getListLocations().map(LocationsResponse::getResults);
    }
}
