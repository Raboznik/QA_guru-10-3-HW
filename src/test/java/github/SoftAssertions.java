package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @Test
    void searchSoftAssertionsInGithubWiki() {

        Selenide.open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body .markdown-body").shouldHave(text("Soft assertions"));
        $x("//*[@id=\"wiki-body\"]/div/ul[1]/li[6]/a").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
