package com.dljsxy.school.web.reqRes;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AddStudentReq {
    @NotNull
    @NotEmpty
    private String name;

    @Positive
    @Max(2030)
    @Min(2000)
    private int startYear;
}
