import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static final String NAME_USER = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    public static Statement statement;
    public static Connection connection;

    static {
        try{
            connection = DriverManager.getConnection(URL,NAME_USER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try{
            statement = connection.createStatement();
        }catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}
