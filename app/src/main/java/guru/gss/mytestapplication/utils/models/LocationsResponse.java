package guru.gss.mytestapplication.utils.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationsResponse extends BaseResponse{

    @SerializedName("results")
    private List<Location> results;

    public List<Location> getResults() {
        return results;
    }

    public void setResults(List<Location> results) {
        this.results = results;
    }

}
