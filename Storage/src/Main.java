import java.util.ArrayList;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Stock> stocks = new ArrayList<>();
    static ArrayList<Supplier> suppliers = new ArrayList<>();

    public static void main(String[] args) {}

    public static void initData() {
        suppliers.add(new Supplier(1,"ОАО Outbreaks", 749523210,"outbreaks_iw@gmail.com", 534641035 ,367621972,103162820));

        customers.add(new Customer(1,"Михал Палыч", 798026742,"old_young@outlook.com",1846521251, 54 , "М"));
        customers.add(new Customer(2,"Жак Фреско", 791523541,"scincebr@gmail.com",275945216,68,"M"));

        stocks.add(new Stock(1,"Видеокарта Asus GTX 1650 4Gb", 17650,StockCategories.PCcomponents));
        stocks.add(new Stock(2,"Процессор AMD 5 2600 OEM",8250,StockCategories.PCcomponents));
        stocks.add(new Stock(3,"Apple Iphone 14 256gb",74200,StockCategories.SmartPhones));
        stocks.add(new Stock(4,"OnePlus 10Pro 256Gb",60990,StockCategories.SmartPhones));
        stocks.add(new Stock(5,"Робот пылесос Xiaomi", 13750,StockCategories.Appilance));
        stocks.add(new Stock(6,"Камера видеонаблюдения", 1820,StockCategories.ProtectiveSystem));
        stocks.add(new Stock(7,"Дисплей Redmi note 11", 7280,StockCategories.SpareParts));
        stocks.add(new Stock(8,"Двигатель для стиральной машины Bosh 1782", 11250,StockCategories.SpareParts));

        products.add(new Product(1,1,1,new long[]{1,6,7,4}));
        products.add(new Product(2,2,1,new long[]{2,3,8,5}));

    }
}