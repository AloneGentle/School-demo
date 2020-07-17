package com.dljsxy.school;

import java.time.LocalDate;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        System.out.println(new Date(2020, 5, 31));
        System.out.println(LocalDate.of(2020, 6, 31));
    }
}
