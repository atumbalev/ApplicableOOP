package model;

public class Employee {
    private static int lastID = 0;

    public final String ID;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
        ID = String.format("E-%03d", lastID++);
    }

    public Employee() {
        this("No Name", 1000);
    }

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, salary: %.2f, ID: %s", name, salary, ID);
    }
}
