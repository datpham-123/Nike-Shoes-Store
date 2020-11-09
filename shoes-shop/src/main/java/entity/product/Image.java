package entity.product;

public class Image {
    private int id;
    private int productID;
    private String image;

    public Image() {
    }

    public Image(int productID, String image) {
        this.productID = productID;
        this.image = image;
    }

    public Image(int id, int productID, String image) {
        this.id = id;
        this.productID = productID;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", productID=" + productID +
                ", image='" + image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
