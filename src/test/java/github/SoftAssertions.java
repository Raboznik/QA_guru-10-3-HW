package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


/**
 * Есть ли разница между $("h1 div"); и $("h1").$("div");
 *
 * Есть.
 * Если в DOM есть несколько элементов h1, а в первом h1 нету <div></div>,
 * то $("h1 div") посмотрит не только первый элемент h1.
 * А $("h1").$("div"); будет искать только в первом блоке h1.
 */
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
