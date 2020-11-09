package entity.product;

public class Product {
    private int id;
    private int brandID;
    private int typeID;
    private int statusID;
    private String name;
    private String image;
    private String description;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int brandID, int typeID, int statusID, String name, String image, String description, double price, int quantity) {
        this.brandID = brandID;
        this.typeID = typeID;
        this.statusID = statusID;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, int brandID, int typeID, int statusID, String name, String image, String description, double price, int quantity) {
        this.id = id;
        this.brandID = brandID;
        this.typeID = typeID;
        this.statusID = statusID;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brandID=" + brandID +
                ", typeID=" + typeID +
                ", statusID=" + statusID +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
