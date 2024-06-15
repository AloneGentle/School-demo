package com.sut.school.web.reqRes;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class AddStudentReq {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String email;

    @Positive
    @Max(2030)
    @Min(2000)
    private short startYear;

    @NotNull
    @NotEmpty
    private LocalDate birthday;

}
