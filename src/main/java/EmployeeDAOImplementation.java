import dao.EmployeeDAO;
import entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImplementation extends EmployeeDAO {


    public void update(int id, Employee employee) {
        QuerryExecutor.updateExecute(id, employee);
    }


    public void delete(int id) {
        try {
            QuerryExecutor.executeUpdate("DELETE pracownicy WHERE prac_id = " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void insert(Employee employee) {
        try {
            QuerryExecutor.executeUpdate("INSERT INTO pracownicy(prac_imie, prac_nazwisko, prac_wiek, "
                    + "prac_nr_telefonu, prac_email) VALUES('" + employee.getName() + "', '" + employee.getSurname() + "', "
                    + employee.getAge() + ", '" + employee.getNr_phone() + "', '" + employee.getEmail() + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void findByEmail(String email) {
        try {
            ResultSet resultSet = QuerryExecutor.executeSelect("SELECT * FROM pracownicy WHERE prac_email = '" + email + "'");
            List<Employee> employees = EmployeeDAO.showAllEmployees(resultSet);

            for(Employee e : employees) {
                System.out.println(e.toString());
            }
        } catch (SQLException e) {
            System.out.println("Blad z baza danych");
            e.printStackTrace();
        }
    }


    public void findBySurname(String surname) {
        try {
            ResultSet resultSet = QuerryExecutor.executeSelect("SELECT * FROM pracownicy WHERE prac_nazwisko = '" + surname + "'");
            List<Employee> employees = EmployeeDAO.showAllEmployees(resultSet);

            for(Employee e : employees) {
                System.out.println(e.toString());
            }
        } catch (SQLException e) {
            System.out.println("Blad z baza danych");
            e.printStackTrace();
        }
    }


    public void findById(int id) {
        try {
            ResultSet resultSet = QuerryExecutor.executeSelect("SELECT * FROM pracownicy WHERE prac_id = " + id);
            EmployeeDAO.showAllEmployees(id, resultSet);
        } catch (SQLException e) {
            System.out.println("Blad z baza danych");
            e.printStackTrace();
        }
    }


    public void findAllEmployees(String query) {
        try {
            ResultSet resultSet = QuerryExecutor.executeSelect(query);
            List<Employee> employees = EmployeeDAO.showAllEmployees(resultSet);

            for(Employee e : employees) {
                System.out.println(e.toString());
            }
        } catch (SQLException e) {
            System.out.println("Blad z baza danych");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeDAOImplementation employeeDaoImpl = new EmployeeDAOImplementation();
        System.out.println("Baza danych PRACOWNICY");
        System.out.println("OPCJE: " + "\n" +
                "1. Wykaz wszystkich pracowników" + "\n" +
                "2. Pobranie pracownika po adresie email" + "\n" +
                "3. Pobieranie pracownika po nazwisku" + "\n" +
                "4. Pobieranie pracownika po id" + "\n" +
                "5. Dodanie pracownika do bazy" + "\n" +
                "6. Aktualizacja istniejącego pracownika" + "\n" +
                "7. Usuwanie pracownika z bazy" + "\n" +
                "8. Wyjscie"
        );

        while (true) {
            Employee employee = new Employee();
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            System.out.println("********************************************");
            System.out.print("Twoj wybor : ");
            int option = scan.nextInt();
            switch (option) {
                case 1: {
                    /******   POBIERANIE WSZYSTKICH PRACOWNIKOW   ******/
                    employeeDaoImpl.findAllEmployees("SELECT * FROM pracownicy");
                    break;
                }
                case 2: {
                    /******   POBIERANIE PRACOWNIKA PO ADRESIE EMAIL   ******/
                    System.out.print("Pobranie pracownika po adresie email. \nPodaj email : ");
                    employeeDaoImpl.findByEmail(scan2.nextLine());
                    break;
                }
                case 3: {
                    /******   POBIERANIE PRACOWNIKA PO NAZWISKU   ******/
                    System.out.print("Pobranie pracownika po nazwisku. \nPodaj nazwisko : ");
                    employeeDaoImpl.findBySurname(scan2.nextLine());
                    break;
                }
                case 4: {
                    /******   POBIERANIE PO ID   ******/
                    System.out.print("Pobranie pracownika po id. Podaj id : ");
                    employeeDaoImpl.findById(scan.nextInt());
                    break;
                }
                case 5: {
                    /******   DODAWANIE   ******/
                    System.out.println("Dodawanie pracownika. Wpisz potrzebne pola.");
                    dataEmployee(employee, scan, scan2);

                    employeeDaoImpl.insert(employee);
                    break;
                }
                case 6: {
                    /******   AKTUALIZOWANIE   ******/
                    System.out.println("Aktualizowanie pracownika. Wpisz potrzebne pola.");
                    System.out.print("Id : ");
                    int id = scan.nextInt();
                    dataEmployee(employee, scan, scan2);

                    employeeDaoImpl.update(id, employee);
                    break;
                }
                case 7: {
                    /******   USUWANIE   ******/
                    System.out.println("Usuwanie po ID. Podaj ID : ");
                    int id = scan.nextInt();
                    employeeDaoImpl.delete(id);
                    break;
                }
                case 8:
                    return;
                default: {
                    System.out.println("Wybrano zla opcje.");
                }
            }
        }
    }

    private static void dataEmployee(Employee employee, Scanner scan, Scanner scan2) {
        System.out.print("Imie : ");
        employee.setName(scan2.nextLine());
        System.out.print("Nazwisko : ");
        employee.setSurname(scan2.nextLine());
        System.out.print("Wiek : ");
        employee.setAge(scan.nextInt());
        System.out.print("Nr telefonu : ");
        employee.setNr_phone(scan2.nextLine());
        System.out.print("Email : ");
        employee.setEmail(scan2.nextLine());
    }
}
