package Storage;

public class Stock {
    private long id; // id товара
    private String titile; // Название товара
    private double price; // Цена товара
    private StockCategories categories; // Категория товара
    private long count; //количество товара

    public Stock(long id, String titile, double price, StockCategories categories, long count) {
        this.id = id;
        this.titile = titile;
        this.price = price;
        this.categories = categories;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StockCategories getCategories() {
        return categories;
    }

    public void setCategories(StockCategories categories) {
        this.categories = categories;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
