package DBConnector;

import java.sql.*;

public class DataBaseHandlerStock extends Config {
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public ResultSet getStocks(String data) {
        String getStock = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getStock);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}

    /* public void addStock(Stock stock) {
        String insert = "INSERT INTO storage.product (id, title, price, categories, count) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, stock.getId());
            preparedStatement.setString(2, stock.getTitile());
            preparedStatement.setInt(3, stock.getPrice());
            preparedStatement.setString(4, String.valueOf(stock.getStockCategories()));
            preparedStatement.setInt(5, stock.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStock() {
        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM storage.product WHERE id=5");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ConslusionOfStock() {
        try {
            getDbConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id, title, price, categories, count FROM storage.product");
            System.out.println("\nProduct");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String categories = resultSet.getString(4);
                int count = resultSet.getInt(5);

                System.out.println("id:" + id + " title: " + title + " price: " + price + " categories: [" + categories +"]" + " count: [" + count + "]");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

     */