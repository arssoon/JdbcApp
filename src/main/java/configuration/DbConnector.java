package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

//    private static String URL = "jdbc:sqlserver://localhost:54233;databaseName=work";
    private static String URL = "jdbc:sqlserver://ARSON\\MSSQLEXPRESS:54233; databaseName=work";
    private static String login = "arson";
    private static String password = "marker25";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
