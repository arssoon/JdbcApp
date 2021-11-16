package dao;

import entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EmployeeDAO {
    public abstract void findAllEmployees(String query);

    public abstract void findById(int id);

    public abstract void findByEmail(String email);

    public abstract void findBySurname(String surname);

    public abstract void insert(Employee employee);

    public abstract void delete(int id);

    public abstract void update(int id, Employee employee);

    public static void showAllEmployees(int id, ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String userName = resultSet.getString("prac_imie");
                String userSurname = resultSet.getString("prac_nazwisko");
                int userAge = resultSet.getInt("prac_wiek");
                String userPhoneNr = resultSet.getString("prac_nr_telefonu");
                String userEmail = resultSet.getString("prac_email");
                System.out.println(id + " " + userName + " " + userSurname + " " + userAge + " " + userPhoneNr + " " + userEmail);
            }

        } catch (SQLException throwables) {
            System.out.println("Blad przy pobieraniu danych");
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (Exception ignore) {
            }
        }
    }

    public static List<Employee> showAllEmployees(ResultSet resultSet) {
        List<Employee> employees = new ArrayList();
        try {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getString("prac_id"));
                employee.setName(resultSet.getString("prac_imie"));
                employee.setSurname(resultSet.getString("prac_nazwisko"));
                employee.setAge(resultSet.getInt("prac_wiek"));
                employee.setNr_phone(resultSet.getString("prac_nr_telefonu"));
                employee.setEmail(resultSet.getString("prac_email"));
                employees.add(employee);
            }

        } catch (SQLException throwables) {
            System.out.println("Blad przy pobieraniu danych");
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (Exception ignore) {
            }
        }
        return employees;
    }
}
