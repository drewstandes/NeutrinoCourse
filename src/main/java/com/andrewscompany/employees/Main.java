package com.andrewscompany.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try {
            List<Employee> employees = Files.lines(Path.of("C:\\Users\\asmith\\IdeaProjects\\Employees\\src\\main\\java\\com" +
                            "\\andrewscompany\\employees\\employees.txt"))
                    .map(Employee::createEmployee)
                    .map(emp -> (Employee) emp)
                    .toList();

            employees.stream()
                    .forEach(System.out::println);

            int total = employees.stream()
                    .mapToInt(Employee::getSalary)
                    .sum();

            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            System.out.println(currencyFormatter.format(total));

        } catch (IOException e) {
            e.printStackTrace();
        }

//        Matcher recordMat = Employee.PERSON_PAT.matcher(people);
//
//        int totalPayment = 0;
//
//        while (recordMat.find()) {
//            IEmployee employee = Employee.createEmployee(recordMat.group());
//            System.out.println(employee.toString());
//            totalPayment += employee.getSalary();
//        }
//
//        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//        System.out.printf("The total payout is %s", currencyInstance.format(totalPayment));
    }

}
