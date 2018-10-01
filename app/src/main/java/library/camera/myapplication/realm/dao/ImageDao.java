package library.camera.myapplication.realm.dao;

import io.realm.Realm;
import io.realm.RealmResults;
import library.camera.myapplication.model.ImageSave;
import library.camera.myapplication.realm.OnCompleteListener;

public class ImageDao {

    public void saveImage(byte[] photo, byte[] originalImage, OnCompleteListener listener) {

        Realm realmIns = null;

        try {
            realmIns = Realm.getDefaultInstance();
            realmIns.executeTransactionAsync(
                    realm -> {

                        ImageSave imageSave = new ImageSave();
                        imageSave.setImage(photo);
                        imageSave.setOriginalImage(originalImage);
                        realm.insertOrUpdate(imageSave);
                    },
                    () -> listener.onComplete(true),
                    error -> listener.onComplete(false) );
        } finally {
            realmIns.close();
        }
    }

    public void removeImage(OnCompleteListener listener) {

        Realm realmIns = null;

        try {
            realmIns = Realm.getDefaultInstance();
            realmIns.executeTransactionAsync(
                    realm -> {

                        RealmResults<ImageSave> imageSaves = realm.where(ImageSave.class).findAll();
                        imageSaves.deleteAllFromRealm();
                    },
                    () -> listener.onComplete(true),
                    error -> listener.onComplete(false) );
        } finally {
            realmIns.close();
        }
    }

    public byte[] getImage() {

        Realm realmIns = null;
        try {
            realmIns = Realm.getDefaultInstance();
            ImageSave imageSave = realmIns.where(ImageSave.class).findFirst();
            if (imageSave != null) {
                ImageSave imageSave1 = realmIns.copyFromRealm(imageSave);
                return imageSave1.getImage();
            }
            return null;
        } finally {
            realmIns.close();
        }
    }

    public byte[] getOriginalImage() {

        Realm realmIns = null;
        try {
            realmIns = Realm.getDefaultInstance();
            ImageSave imageSave = realmIns.where(ImageSave.class).findFirst();
            if (imageSave != null) {
                ImageSave imageSave1 = realmIns.copyFromRealm(imageSave);
                return imageSave1.getOriginalImage();
            }
            return null;
        } finally {
            realmIns.close();
        }
    }
}
