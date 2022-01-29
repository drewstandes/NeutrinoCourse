package com.andrewscompany.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee{
    protected int stockAvg;

    String CEORegex = "\\w+=(?<stockAvg>\\d{1,3})";
    Pattern CEOPat = Pattern.compile(CEORegex);

    public CEO(String record) {
        super(record);
        Matcher CEOMat = CEOPat.matcher(this.details);
        if (CEOMat.find()) {
            stockAvg = Integer.parseInt(CEOMat.group("stockAvg"));
        }
    }

    @Override
    public int getSalary() {
        return 4000 * stockAvg;
    }
}
