package DBConnector;

import java.sql.*;

public class DataBaseHandlerPerson extends Config {
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void signUpUserCustomer(Storage.Customer customer) {
        String insert = "INSERT INTO storage.customer (name,phone_number,email,payment_details,date_of_birthday,gender) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhonenumber());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPaymentdeteails());
            preparedStatement.setString(5, customer.getDate_of_birthday());
            preparedStatement.setString(6, String.valueOf(customer.getGender()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteCustomer() {
        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM customer WHERE id_customer = 3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ConslusionOfCustomer() {
        try {
            getDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_customer, name, phone_number, email, payment_details, date_of_birthday, gender FROM storage.customer");

            System.out.println("\nCustomer");
            while (resultSet.next()) {
                int id_customer = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone_numbers = resultSet.getString(3);
                String email = resultSet.getString(4);
                String payment_details = resultSet.getString(5);
                String date_of_birthday = resultSet.getString(6);
                String gender = resultSet.getString(7);

                System.out.println("id: " + id_customer + " |name: " + name + " |phone_number: " + phone_numbers + " |email: " + email + " |payment_details: " + payment_details + " |date_of_birthday: " + date_of_birthday + " |gender: " + gender);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpUserSupplier(Storage.Supplier supplier) {
        String insert = "INSERT INTO storage.supplier ( name, phone_number, email, payment_details, INN, OGRN) VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,supplier.getName());
            preparedStatement.setString(2,supplier.getPhonenumber());
            preparedStatement.setString(3,supplier.getEmail());
            preparedStatement.setString(4,supplier.getPaymentdeteails());
            preparedStatement.setString(5,supplier.getINN());
            preparedStatement.setString(6,supplier.getOGRN());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteSupplier(){
        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM supplier WHERE id_supplier = 4");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ConclusionOfSupplier(){
        try {
            getDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_supplier, name, phone_number, email, payment_details, INN, OGRN FROM storage.supplier");

            System.out.println("\nSupplier");
            while (resultSet.next()) {
                int id_supplier = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone_number = resultSet.getString(3);
                String email = resultSet.getString(4);
                String payment_details = resultSet.getString(5);
                String INN = resultSet.getString(6);
                String OGRN = resultSet.getString(7);

                System.out.println("id: " + id_supplier + " |name: " + name + " |phone_number: " + phone_number + " |email: " + email + " |payment_details: " + payment_details + " |INN:" + INN + " |OGRN: " + OGRN);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpUserStockWorkers(Storage.StockWorker stockWorker) {
        String insert = "INSERT INTO storage.stockworkers (name, phone_number, email, job_title) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,stockWorker.getName());
            preparedStatement.setString(2,stockWorker.getPhonenumber());
            preparedStatement.setString(3,stockWorker.getEmail());
            preparedStatement.setString(4,stockWorker.getJobtitle());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteStockWorkers() {
        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM stockworkers WHERE id_workers = 4");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ConclusionOfStockWorkers(){
        try {
            getDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_worker, name, phone_numbers, email, job_title FROM storage.stockworkers");

            System.out.println("\nStock Workers");
            while (resultSet.next()) {
                int id_worker = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone_numbers = resultSet.getString(3);
                String email = resultSet.getString(4);
                String job_title = resultSet.getString(5);

                System.out.println("id: " + id_worker + " |name: " + name + " |phone_numbers: " + phone_numbers + " |email: " + email + " |job_title: " + job_title);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}