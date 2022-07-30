package com.it_academy.tests.rest_api.utils;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public final class EndPointUtils {

    private EndPointUtils() {
    }

    /**
     * Return the header configuration map
     *
     * @return header configuration map
     */
    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    public static Map<String, Object> endpointParams() {
        return ImmutableMap.of("sushi_typ[0]", "souce");
    }
}
