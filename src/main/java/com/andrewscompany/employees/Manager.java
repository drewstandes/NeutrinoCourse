package com.andrewscompany.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee{

    protected int projectCount;

    String managerRegex = "\\w+=(?<projCount>\\d{1,3})";
    Pattern managerPat = Pattern.compile(managerRegex);

    public Manager(String record) {
        super(record);
        Matcher managerMat = managerPat.matcher(this.details);
        if (managerMat.find()) {
            projectCount = Integer.parseInt(managerMat.group("projCount"));
        }
    }

    @Override
    public int getSalary() {
        return 2000 * projectCount;
    }
}
