package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSearch {

    @Test
    void searchSelenideTest() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("input#wiki-pages-filter").setValue("SoftAssertions");
        $("ul.filterable-active").shouldHave(text("SoftAssertions"));
        $("ul.filterable-active").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5"));


    }

}
