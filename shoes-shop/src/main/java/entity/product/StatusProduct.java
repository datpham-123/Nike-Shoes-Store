package entity.product;

public class StatusProduct {
    private int id;
    private String status;

    public StatusProduct() {
    }

    public StatusProduct(String status) {
        this.status = status;
    }

    public StatusProduct(int id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusProduct{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
