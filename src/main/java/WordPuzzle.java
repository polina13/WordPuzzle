import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/main.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String userString = request.queryParams("word");
      String noVowelString = WordPuzzle.checkWord(userString);

      model.put("userString", userString);
      // model.put("noVowelString", noVowelString);
      // model.put("template", "templates/detector.vtl");

      Object results = WordPuzzle.checkWord(userString);
      model.put("results", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String checkWord(String word) {

    return word.replaceAll("[aeiouyAEIOUY]", "-");

  }

}
