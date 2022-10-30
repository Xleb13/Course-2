package Storage;

import DBConnector.DataBaseHandlerPerson;

public class Main {
    public static void main(String[] args) {

        DataBaseHandlerPerson dbCustomer = new DataBaseHandlerPerson(); /*
        Customer customer = new Customer(6,"Лаевич","2434052","nikola777@yandex.ru","1465192546965","1967.12.28","mahle");
        dbCustomer.signUpUserCustomer(customer); */

        DataBaseHandlerPerson dbSupplier = new DataBaseHandlerPerson(); /*
        Supplier supplier = new Supplier(6 ,"Пал Мамонтыч","79805553535","netouge@bk.com","7915 1235 2142 6245","14525545", "464542");
        dbSupplier.signUpUserSupplier(supplier);
         */
        DataBaseHandlerPerson dbStockWorkers = new DataBaseHandlerPerson();

        dbCustomer.ConslusionOfCustomer();
        dbSupplier.ConclusionOfSupplier();
        dbStockWorkers.ConclusionOfStockWorkers();
    }
}