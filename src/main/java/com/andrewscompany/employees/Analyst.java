package com.andrewscompany.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee {
    protected int orgSize;
    protected int dr;

    String analystRegex = "\\w+=(?<orgSize>\\d{1,3}),\\w+=(?<dr>\\d{1,2})";
    Pattern analystPat = Pattern.compile(analystRegex);

    public Analyst(String record) {
        super(record);
        Matcher analystMat = analystPat.matcher(this.details);
        if (analystMat.find()) {
            orgSize = Integer.parseInt(analystMat.group("orgSize"));
            dr = Integer.parseInt(analystMat.group("dr"));
        }
    }

    @Override
    public int getSalary() {
        return 2000 + orgSize * dr;
    }
}
