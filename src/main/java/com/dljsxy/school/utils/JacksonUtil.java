package com.dljsxy.school.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.springframework.beans.factory.annotation.Autowired;

public final class JacksonUtil {
    @Autowired
    ObjectMapper objectMapper;

    public static final ObjectMapper MAPPER = new ObjectMapper()
            //
            .setDateFormat(new StdDateFormat())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

}
