import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Word Puzzle");
  }

  @Test
  public void checkForAWord() {
    goTo("http://localhost:4567/");
    fill("#word").with("cat");
    submit(".btn");
    assertThat(pageSource()).contains("c-t");
  }

  @Test
  public void checkForAMultipleWords() {
    goTo("http://localhost:4567/");
    fill("#word").with("hello epicodus");
    submit(".btn");
    assertThat(pageSource()).contains("h-ll- -p-c-d-s");
  }

  @Test
  public void checkForASentenceWithPunctuation() {
    goTo("http://localhost:4567/");
    fill("#word").with("I like learning about programming!");
    submit(".btn");
    assertThat(pageSource()).contains("- l-k- l--rn-ng -b--t pr-gr-mm-ng!");
  }
}
