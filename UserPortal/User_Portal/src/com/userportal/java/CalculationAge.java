package com.userportal.java;

import java.time.LocalDate;
import java.time.Period;

public class CalculationAge {

 public static int getAge(int day, int month, int year) {

        LocalDate birth = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period diffYear = Period.between(birth, now);
        return diffYear.getYears();

    }
	
}
