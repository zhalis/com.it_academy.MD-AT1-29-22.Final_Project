package com.it_academy.tests.rest_api.service;

import com.it_academy.tests.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.tests.rest_api.model.SushiVeslaProduct;
import com.it_academy.tests.rest_api.utils.GetRequestUtils;
import com.it_academy.tests.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

public class SushiVeslaService {
    private static final String SUSHIVESLA_PRODUCTS_JSON_PATH = "products";

    /**
     * Returns a list of SushiVeslaProduct object
     *
     * @param configureHeaders configure headers
     * @param endpointParams   endpoint parameters
     * @return list SushiVeslaProduct object
     */
    public static List<SushiVeslaProduct> getSushiveslaProducts(
            Map<String, Object> configureHeaders,
            Map<String, Object> endpointParams) {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(
                OnlinerEndpoints.getCatalogSushiVeslaProductEndpoint(),
                configureHeaders, endpointParams);
        return ResponseBodyUtils.getObjectsByJsonPath(
                responseBody, SUSHIVESLA_PRODUCTS_JSON_PATH, SushiVeslaProduct.class);
    }
}
