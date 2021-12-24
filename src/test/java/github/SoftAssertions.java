package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


/**
 * Есть ли разница между $("h1 div"); и $("h1").$("div");
 * <p>
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
        $(".js-wiki-more-pages-link").click();

        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
