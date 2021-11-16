package entity;

public class Employee {
    private String id;
    private String name;
    private String surname;
    private int age;
    private String nr_phone;
    private String email;

    public Employee() {
    }

    public Employee(String id, String name, String surname, int age, String nr_phone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nr_phone = nr_phone;
        this.email = email;
    }

    public Employee(String name, String surname, int age, String nr_phone, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nr_phone = nr_phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNr_phone() {
        return nr_phone;
    }

    public void setNr_phone(String nr_phone) {
        this.nr_phone = nr_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id = " + id + " | " +
                "name = " + name + " | " +
                "surname = " + surname + " | " +
                "age = " + age + " | " +
                "nr_phone = " + nr_phone  + " | " +
                "email = " + email
                + "\n------------------------------------------------------------------------------------------------";
    }
}
