/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author eck
 */
class Employee {

    public static enum Gender {

        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
    private final UUID employeeID;

    private Employee(String name, Gender gender, LocalDate dob,
            double income) {
        
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        employeeID = UUID.randomUUID();
    }

    public Employee() {
        this("Default name", Gender.MALE, LocalDate.now(), 0);
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        List<Employee> employees = persons();

        double totalIncome = employees.stream().mapToDouble(e -> e.income).sum();
        System.out.printf("The total sum of all the employees' income is : %.2f%n", totalIncome);
    }

    public void personsStatsByGenderCount() {
        List<Employee> employees = persons();

        Map<Gender, Long> employeesCountGroupedByGender = employees.stream().collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));

        for (Gender g : employeesCountGroupedByGender.keySet()) {
            System.out.printf("The number of employees with gender: %-6s is %d%n", g, employeesCountGroupedByGender.get(g));
        }
    }

    public void personsStatsByGenderList() {
        List<Employee> employees = persons();

        Map<Gender, List<Employee>> employeesByGender = employees.stream().collect(Collectors.groupingBy(e -> e.gender, Collectors.toList()));

        for (Gender g : employeesByGender.keySet()) {
            System.out.printf("Employees with gender: %s%n", g);
            for (Employee e : employeesByGender.get(g)) {
                System.out.print('\t');
                System.out.println(e.toString());
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Gender: %s, date: %s, income: %.2f, employeeID: %s", name, gender, dob.toString(), income, employeeID.toString());
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Pe60", Gender.MALE, LocalDate.now(), 1500);
        System.out.println(employee.toString());
        statistics();
        employee.personsStatsByGenderCount();
        employee.personsStatsByGenderList();
    }
}

