package com.it_academy.tests.page_object;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePage extends BasePage {

    private static final String ONLINER_URL = "https://www.onliner.by/";

    private static final SelenideElement ONLINER_SEARCH = $x("//input[contains(@class,'fast-search')]");

    private static final SelenideElement SEARCH_PLACEHOLDER = $x("//header/div[3]/div[1]/div[2]/div[1]/form[1]/input[1]");

    public HomePage navigateToOnlinerHomePage() {
        open(ONLINER_URL);
        return this;
    }

    public SearchPage enteringTextInTheSearchBar(String text) {
        ONLINER_SEARCH.should(visible, Duration.ofSeconds(20)).val("BMW");
        return new SearchPage();
    }

    public SelenideElement getPlaceholder() {
        return SEARCH_PLACEHOLDER.shouldBe(visible, Duration.ofSeconds(60));
    }
}
