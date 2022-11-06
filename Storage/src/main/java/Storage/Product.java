package Storage;

public class Product {
    private long id; //id сделки
    private long customerId; // id покупателя
    private long supplierId; // id продавца
    private long[] product; // спсиок товара который продали

    public Product(long id, long customerId, long supplierId, long[] product) {
        this.id = id;
        this.customerId = customerId;
        this.supplierId = supplierId;
        this.product = product;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long[] getProduct() {
        return product;
    }

    public void setProduct(long[] product) {
        this.product = product;
    }
}