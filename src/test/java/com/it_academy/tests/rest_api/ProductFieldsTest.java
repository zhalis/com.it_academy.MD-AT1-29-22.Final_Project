package com.it_academy.tests.rest_api;

import com.it_academy.tests.rest_api.endpoints.OnlinerEndpoints;
import com.it_academy.tests.rest_api.service.SushiVeslaService;
import com.it_academy.tests.rest_api.utils.EndPointUtils;
import com.it_academy.tests.rest_api.utils.GetRequestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class ProductFieldsTest {

    private static final String PRODUCTS_NAME_PREFIX_JSON_PATH
            = "products.name_prefix";

    @Test
    public void testAllSushiVeslaProductFieldsAreNotEmpty() {
        assertThat(SushiVeslaService.getSushiveslaProducts(
                EndPointUtils.configureHeaders(), null))
                .as("The received name is empty")
                .allMatch(product -> product.getId() != null
                        && product.getFull_name() != null
                        && product.getKey() != null
                        && product.getName() != null);
    }

    @Test
    public void testAllElementsOfTheSaucesFilterHaveTheNamePrefixSauces() {
        List<String> namePrefix = GetRequestUtils.makeRequestAndGetResponseBody(
                        OnlinerEndpoints.getCatalogSushiVeslaProductEndpoint(),
                        EndPointUtils.configureHeaders(),
                        EndPointUtils.endpointParams())
                .jsonPath()
                .getList(PRODUCTS_NAME_PREFIX_JSON_PATH);
        assertThat(namePrefix).as("Not all name_prefix contain the selected filter 'Соус'")
                .allMatch(element -> element.equals("Соус"));
    }
}
