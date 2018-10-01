package library.camera.myapplication;

import android.support.multidex.MultiDexApplication;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends MultiDexApplication {
    private static MyApplication instance;
    private static RealmConfiguration realmConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);

        realmConfig = new RealmConfiguration.Builder()
                .name("myapplication.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
