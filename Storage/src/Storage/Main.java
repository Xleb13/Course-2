package Storage;

import DB.DataBaseHandlerPerson;

public class Main {
    public static void main(String[] args) {
        DataBaseHandlerPerson dbCustomer = new DataBaseHandlerPerson();
        Customer customer = new Customer('5',"29562548105","gachiboy@gmail.ua","1564 2341 1964","10","2010.01.01","mahle");
        dbCustomer.signUpUserCustomer(customer);
        //https://habr.com/ru/sandbox/146588/
    }
}