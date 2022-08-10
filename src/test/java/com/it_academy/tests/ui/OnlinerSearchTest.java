package com.it_academy.tests.ui;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.tests.page_object.BasePage;
import com.it_academy.tests.page_object.HomePage;
import com.it_academy.tests.page_object.SearchPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
@Execution(ExecutionMode.CONCURRENT)
public class OnlinerSearchTest extends BasePage {


    private HomePage homePage;
    private SearchPage searchPage;


    @BeforeEach
    public void onlinerHomePageNavigation() {
        searchPage = new SearchPage();
        homePage = new HomePage();
        homePage.navigateToOnlinerHomePage();
    }

    @ParameterizedTest
    @ValueSource(strings = "Поиск в Каталоге")
    @Description("test placeholder")
    public void testPlaceholder(String placeholderText) {
        assertThat(homePage.getPlaceholder().getAttribute("placeholder"))
                .as("Placeholder does not contain" + placeholderText)
                .contains(placeholderText);
    }

    @ParameterizedTest
    @ValueSource(strings = "text")
    @Description("test the search popup close")
    public void testSearchPopupClose(String searchQuery) {
        homePage.enteringTextInTheSearchBar(searchQuery);
        searchPage.switchToFrame();
        searchPage.closeSearchPopup();

    }

    @ParameterizedTest
    @ValueSource(strings = "BMW")
    @Description("test all search result objects contain the search query")
    public void testAllSearchResultObjectsContainTheSearchQuery(String searchQuery) {
        assertThat(homePage
                .enteringTextInTheSearchBar(searchQuery)
                .switchToFrame()
                .getSearchResult())
                .as("The product name does not contain the name of the query in the search bar")
                .map(SelenideElement::getText)
                .allMatch(selenideElement -> selenideElement.contains(searchQuery));
    }

    @Test
    @Description("test the search contains a submenu")
    public void testTheSearchPopupContainsASubmenu() {
        assertThat(homePage
                .enteringTextInTheSearchBar("text")
                .switchToFrame()
                .getSearchTabsList())
                .as("Submenu items are not correct")
                .map(SelenideElement::getText)
                .containsOnly("в каталоге", "в новостях", "на барахолке", "на форуме");
    }
}
