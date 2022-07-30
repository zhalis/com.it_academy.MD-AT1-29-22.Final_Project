package com.it_academy.tests.rest_api.utils;

import io.restassured.response.ResponseBody;

import java.util.List;

public final class ResponseBodyUtils {

    private ResponseBodyUtils() {
    }

    /**
     * Converts response body to a list of objects of the given type by json path
     *
     * @param responseBody response body
     * @param jsonPath     json path
     * @param type         type
     * @param <T>          object class
     * @return list objects
     */
    public static <T> List<T> getObjectsByJsonPath(
            ResponseBody responseBody, String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }
}
