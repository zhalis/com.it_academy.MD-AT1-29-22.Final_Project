package com.it_academy.tests.rest_api.endpoints;

import com.it_academy.tests.framework.PropertiesReader;

public class OnlinerEndpoints {

    /**
     * Returns endpoint from file property
     *
     * @return endpoint
     */
    public static String getCatalogSushiVeslaProductEndpoint() {
        return PropertiesReader.getEndpointProperty("catalog.products.sushivesla");
    }
}
