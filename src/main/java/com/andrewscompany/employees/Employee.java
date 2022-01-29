package com.andrewscompany.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee implements IEmployee {

    protected String firstName;
    protected String lastName;
    protected LocalDate dob;
    protected String details;

    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    public static String PERSON_REGEX = "(?<firstName>\\w+),\\s*(?<lastName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<details>.+?)}";
    public static Pattern PERSON_PAT = Pattern.compile(PERSON_REGEX);
    protected Matcher personMat;

    public Employee() {
        firstName = "N/A";
        lastName = "N/A";
    }

    public Employee(String record) {
        personMat = PERSON_PAT.matcher(record);

        if (personMat.find()) {
            firstName = personMat.group("firstName");
            lastName = personMat.group("lastName");
            dob = LocalDate.from(dtFormatter.parse(personMat.group("dob")));
            details = personMat.group("details");
        }
    }

    public static final IEmployee createEmployee(String record) {
        Matcher personMat = PERSON_PAT.matcher(record);
        if (!personMat.find()) {
            new DummyEmployee();
        }
        return switch (personMat.group("role")) {
            case "Programmer" -> new Programmer(personMat.group());
            case "Manager" -> new Manager(personMat.group());
            case "Analyst" -> new Analyst(personMat.group());
            case "CEO" -> new CEO(personMat.group());
            default -> new DummyEmployee();
        };
    }

    @Override
    public int getSalary() {
        return 0;
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        StringBuilder str = new StringBuilder();
        str.append(this.firstName).append(" ").append(this.lastName).append(" ").append(currencyFormat.format(this.getSalary()));
        return str.toString();
    }

        private static final class DummyEmployee extends Employee {
            @Override
            public int getSalary() {
                return 0;
            }
        }
}
