import configuration.DbConnector;
import entity.Employee;

import java.sql.*;

public class QuerryExecutor {

    private static final String UPDATE = "UPDATE pracownicy SET prac_imie=?, prac_nazwisko=?, " +
            "prac_wiek=?, prac_nr_telefonu=?, prac_email=?  WHERE prac_id=?";

    public static ResultSet executeSelect(String query) throws SQLException {
        Statement statement = null;
        try {
            Connection connection = DbConnector.connect();
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement.executeQuery(query);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = null;
        try {
            Connection connection = DbConnector.connect();
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        statement.execute(query);
    }

    public static void executeUpdate(String query) throws SQLException {
        Statement statement = null;
        try {
            Connection connection = DbConnector.connect();
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        statement.executeUpdate(query);
    }

    public static void updateExecute(int id, Employee employee) {

        try {
            PreparedStatement stmt = null;
            Connection connection = null;

            try {
                connection = DbConnector.connect();
                stmt = connection.prepareStatement(UPDATE);
                stmt.setString(1, employee.getName());
                stmt.setString(2, employee.getSurname());
                stmt.setInt(3, employee.getAge());
                stmt.setString(4, employee.getNr_phone());
                stmt.setString(5, employee.getEmail());
                stmt.setInt(6, id);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            stmt.executeUpdate();
            connection.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
