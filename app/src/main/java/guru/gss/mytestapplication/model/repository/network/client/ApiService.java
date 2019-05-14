package guru.gss.mytestapplication.model.repository.network.client;

import guru.gss.mytestapplication.utils.models.BaseResponse;
import guru.gss.mytestapplication.utils.models.CharacterResponse;
import guru.gss.mytestapplication.utils.models.LocationsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("character")
    Single<CharacterResponse> getListCharacters();

    @GET("location")
    Single<LocationsResponse> getListLocations();

}
