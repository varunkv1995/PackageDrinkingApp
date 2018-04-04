package comw.example.mdsaif.packagedrinkingapp.utils;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Md.Saif on 26-02-2018.
 */

public class RootApp extends Application {
    private static FirebaseAuth auth;

    public static FirebaseAuth getAuth() {
        return auth;
    }

    public static void setAuth(FirebaseAuth auth) {
        RootApp.auth = auth;
    }

    public static FirebaseDatabase getDatabase() {
        return database;
    }

    public static void setDatabase(FirebaseDatabase database) {
        RootApp.database = database;
    }

    private static FirebaseDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    public static String getUid() {
        if (auth.getCurrentUser() != null)
            return auth.getCurrentUser().getUid();
        return "";
    }
}
