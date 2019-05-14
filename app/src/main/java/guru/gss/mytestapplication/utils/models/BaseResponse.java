package guru.gss.mytestapplication.utils.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class BaseResponse {

    @SerializedName("info")
    private MyResponceInfo info;

    public MyResponceInfo getInfo() {
        return info;
    }

    public void setInfo(MyResponceInfo info) {
        this.info = info;
    }
}
