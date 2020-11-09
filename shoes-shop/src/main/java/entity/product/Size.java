package entity.product;

public class Size {
    private int id;
    private int productID;
    private double size;

    public Size() {
    }

    public Size(int productID, double size) {
        this.productID = productID;
        this.size = size;
    }

    public Size(int id, int productID, double size) {
        this.id = id;
        this.productID = productID;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", productID=" + productID +
                ", size=" + size +
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
