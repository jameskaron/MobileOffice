package pccw.mobleoffice;

/**
 * Created by 80575749 on 2015/1/7.
 */
public class Efax {
    private int imageId;
    private String name;

    public Efax(String name,int imageId ) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
