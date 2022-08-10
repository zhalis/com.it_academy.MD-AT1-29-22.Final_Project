package com.it_academy.tests.page_object;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class SearchPage extends BasePage {
    private static final ElementsCollection ONLINER_SEARCH_RESULT = $$x(
    "//a[@target='_parent' and @class='product__title-link']");
    private static final ElementsCollection SEARCH_TABS_LIST = $$x("//*[contains(@class,'search__tabs-item')]");
    private static final SelenideElement SEARCH_CLOSE = $x("//*[@class='search__close']");
    private static final SelenideElement IFRAME = $x("//iframe[@class='modal-iframe']");

    public SearchPage switchToFrame() {
        switchTo().frame(IFRAME);
        return this;
    }

    public void closeSearchPopup() {
        SEARCH_CLOSE.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
    }

    public ElementsCollection getSearchResult() {
        return ONLINER_SEARCH_RESULT.shouldHave(CollectionCondition.sizeGreaterThan(0),Duration.ofSeconds(20));
    }


    public ElementsCollection getSearchTabsList() {
        return SEARCH_TABS_LIST.shouldHave(CollectionCondition.sizeGreaterThan(0),Duration.ofSeconds(20));
    }
}
