package Storage;

import DBConnector.DataBaseHandlerPerson;
import DBConnector.DataBaseHandlerStock;

public class Main {
    public static void main(String[] args) {

        DataBaseHandlerPerson dbCustomer = new DataBaseHandlerPerson();
        DataBaseHandlerPerson dbSupplier = new DataBaseHandlerPerson();
        DataBaseHandlerPerson dbStockWorkers = new DataBaseHandlerPerson();
        DataBaseHandlerStock dbStock = new DataBaseHandlerStock();

        /*
        Customer customer = new Customer("GigachadBigFloppa","79205460893","BigFloppa@yandex.ru","1452142545","1999.11.11", Customer.Gender.Mahle);
        dbCustomer.signUpUserCustomer(customer);
         */

         /*
        Supplier supplier = new Supplier(6 ,"Пал Мамонтыч","79805553535","netouge@bk.com","7915 1235 2142 6245","14525545", "464542");
        dbSupplier.signUpUserSupplier(supplier);
         */

        /*
        StockWorker stockWorker = new StockWorker("Антон","79507815954","working15@mail.ru","Грузчик");
        dbStockWorkers.signUpUserCustomer(stockWorker);
        */

        /*
        Stock stock = new Stock(9,"Xiaomi Redmi 12T 256Gb",27820,24, Stock.StockCategories.SmartPhones);
        dbStock.addStock(stock);
         */

        dbCustomer.ConslusionOfCustomer();
        dbSupplier.ConclusionOfSupplier();
        dbStockWorkers.ConclusionOfStockWorkers();
        dbStock.ConslusionOfStock();
    }
}