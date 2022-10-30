package DB;

import java.sql.*;

public class DataBaseHandlerPerson extends Config{
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void signUpUserCustomer(Storage.Customer customer) {
        String insert = "INSERT INTO customer.customer (idcustomer,name,phonenumber,email,paymetdetails,dateofbirthday,gender) VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getPhonenumber());
            preparedStatement.setString(4,customer.getEmail());
            preparedStatement.setString(5,customer.getPaymentdeteails());
            preparedStatement.setString(6,customer.getAge());
            preparedStatement.setString(7,customer.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpUserSupplier(Storage.Supplier supplier) {
        String insert = "INSERT INTO supplier.supplier (idsupplier, name, phonenumber, email, paymentsdetails, INN, OGRN) VALUES (?,?,?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,supplier.getId());
            preparedStatement.setString(2,supplier.getName());
            preparedStatement.setString(3,supplier.getPhonenumber());
            preparedStatement.setString(4,supplier.getEmail());
            preparedStatement.setString(5,supplier.getPaymentdeteails());
            preparedStatement.setString(5,supplier.getINN());
            preparedStatement.setString(6,supplier.getOGRN());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpUserStockWorkers(Storage.StockWorker stockWorker) {
        String insert = "INSERT INTO stockworkers.stockworkers (idworker, name, phonenumber, email, job_title) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, stockWorker.getId());
            preparedStatement.setString(2,stockWorker.getName());
            preparedStatement.setString(3,stockWorker.getPhonenumber());
            preparedStatement.setString(4,stockWorker.getEmail());
            preparedStatement.setString(5,stockWorker.getJobtitle());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
