package com.dljsxy.school.utils;

public class CacheUtil {
    public static final String STUDENT_CACHE_PREFIX = "school:student:";

    public static String studentCacheKey(String name) {
        return STUDENT_CACHE_PREFIX + name;
    }
}
