package com.it_academy.tests.migris;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.tests.framework.driver.SelenideWebDriverDiscovery;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class MigrisCheckingVisitTimeTest {

    private static final String MIGRIS_URL = "https://www.migracija.lt/";
    private static final SelenideElement PERMISSION_TO_USE_COOKIES = $x("//a[text()='Sutinku']");
    private static final SelenideElement BOOK_A_VISIT_BUTTON = $x("//a[contains(text(),'Rezervuoti vizitą')]");
    private static final SelenideElement VISIT_TYPE_LIST = $x("//input[@id='mat-input-0']");
    private static final SelenideElement DOCUMENTS_ISSUED_TO_FOREIGNERS = $x("//span[contains(text(),'Užsieniečiams išduodami dokumentai – atsiėmimas')]");

    private static final SelenideElement INSTITUTION = $x("//input[@id='mat-input-1']");
    private static final SelenideElement ADDRESS = $x("//span[contains(text(),'Vilnius, Konstitucijos pr. 3')]");
    private static final SelenideElement SOONEST_POSSIBLE_VISIT_DATE = $x("//div[contains(text(),'Artimiausia galima vizito data:')]");

    @BeforeEach
    public void openMigrisWebSite() {
        Configuration.browser = SelenideWebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 200000;
        Configuration.startMaximized = true;
        Selenide.open(MIGRIS_URL);
    }

    @Test
    @Description("checking free date")
    public void testCheckFreeTime() {
        PERMISSION_TO_USE_COOKIES.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        BOOK_A_VISIT_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        VISIT_TYPE_LIST.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        DOCUMENTS_ISSUED_TO_FOREIGNERS.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        INSTITUTION.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        ADDRESS.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        Assertions.assertThat(SOONEST_POSSIBLE_VISIT_DATE.getText())
                .as("")
                .doesNotContain(dates());
    }

    public static List<String> dates() {
        return new ArrayList<String>(List.of(
                "2022-08-12", "2022-08-13", "2022-08-14", "2022-08-15", "2022-08-16",
                "2022-08-17", "2022-08-18", "2022-08-19", "2022-08-20", "2022-08-21", "2022-08-22", "2022-08-23", "2022-08-24",
                "2022-08-25", "2022-08-26", "2022-08-27", "2022-08-28", "2022-08-29", "2022-08-30", "2022-08-31"));
    }
}
