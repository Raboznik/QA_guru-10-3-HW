package dragAndDrop;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");

//      actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}
