package com.sut.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class SchoolApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(1,1);
        assertNotEquals(1,2);
    }

}
