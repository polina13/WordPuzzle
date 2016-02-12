import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordPuzzleTest {

  @Test
  public void checkPuzzle_checkForWordsWithNoVowels() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    String userInput = "brrr";
    assertEquals(userInput, testWordPuzzle.checkWord("brrr"));
  }

  @Test
  public void checkPuzzle_checkForWordsWithVowelsandReplaceVowelsWithDashes() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("H-ll-fr--nds", testWordPuzzle.checkWord("Hellofriends"));
  }
}
