/*package DBConnector;

import Storage.Stock;
import java.sql.*;

public class DataBaseHandlerStock {
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

    public void addStock(Storage.Stock stock) {
        String insert = "INSERT INTO storage.product (id, title, price, categories, count) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, stock.getId());
            preparedStatement.setString(2, stock.getTitile());
            preparedStatement.setInt(3, stock.getPrice());
            preparedStatement.setString(4, stock.getStockCategories());
            preparedStatement.setInt(5,stock.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



 */

