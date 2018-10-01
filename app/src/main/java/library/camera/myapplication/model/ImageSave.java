package library.camera.myapplication.model;

import io.realm.RealmObject;

public class ImageSave extends RealmObject {

    private byte[] image;
    private byte[] originalImage;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(byte[] originalImage) {
        this.originalImage = originalImage;
    }
}
