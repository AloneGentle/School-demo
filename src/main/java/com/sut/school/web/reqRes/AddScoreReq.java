package com.sut.school.web.reqRes;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Data
public class AddScoreReq {

    @NotNull
    private Long studentId;

    @NotNull
    private Long courseId;

    @NotNull
    @Min(value = 0, message = "Score must be greater than or equal to 0")
    @Max(value = 100, message = "Score must be less than or equal to 100")
    private Long score;

}
