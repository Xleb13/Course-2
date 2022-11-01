package Storage;

public class Stock {
    private int id; // id товара
    private String titile; // Название товара
    private int price; // Цена товара
    private int count; //количество товара

    enum StockCategories {
        SmartPhones, //Мобильные телефоны
        PCcomponents, //Комплектующие для пк
        Appilance, //Бытовая техника
        ProtectiveSystem, //Защитные системы
        SpareParts, //Ремонтные детали
    }

    private StockCategories stockCategories; //Категория товара

    public Stock(int id, String titile, int price, int count, StockCategories stockCategories) {
        this.id = id;
        this.titile = titile;
        this.price = price;
        this.count = count;
        this.stockCategories = stockCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StockCategories getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(StockCategories stockCategories) {
        this.stockCategories = stockCategories;
    }


}
