package com.andrewscompany.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private int locpd;
    private int yoe;
    private int iq;

    String programmerRegex = "\\w+=(?<locpd>\\d{1,4}),\\w+=(?<yoe>\\d{1,2}),\\w+=(?<iq>\\d{2,3})";
    Pattern progPat = Pattern.compile(programmerRegex);

    public Programmer(String record) {
        super(record);
        Matcher coderMat = progPat.matcher(this.details);
        if (coderMat.find()) {
            locpd = Integer.parseInt(coderMat.group("locpd"));
            yoe = Integer.parseInt(coderMat.group("yoe"));
            iq = Integer.parseInt(coderMat.group("iq"));
        }
    }

    @Override
    public int getSalary() {
        return 3000 + locpd * yoe * iq;
    }
}
