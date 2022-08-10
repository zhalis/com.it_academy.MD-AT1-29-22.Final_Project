package com.it_academy.tests;

import com.it_academy.tests.ui.OnlinerSearchTest;
import com.it_academy.tests.rest_api.ProductFieldsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({OnlinerSearchTest.class, ProductFieldsTest.class})

public class JUnitSuite {

}
