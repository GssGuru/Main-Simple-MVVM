package guru.gss.mytestapplication.utils;

import android.util.Log;

public class LoggerUtils {

    private static final String LOG = "sgg";

    public static void errorLog(String location){
        Log.e(LOG, location);
    }

    public static void errorLog(String location, Throwable e){
        Log.e(LOG, location, e);
    }
}
