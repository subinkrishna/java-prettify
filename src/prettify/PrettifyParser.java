package prettify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import prettify.parser.Job;
import prettify.parser.Prettify;
import syntaxhighlight.ParseResult;
import syntaxhighlight.Parser;

/**
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class PrettifyParser implements Parser {

  protected Prettify prettify;

  public PrettifyParser() {
    prettify = new Prettify();
  }

  @Override
  public List<ParseResult> parse(String fileExtension, String content) {
    Job job = new Job(0, content);
    prettify.langHandlerForExtension(fileExtension, content).decorate(job);
    List<Object> decorations = job.getDecorations();


    List<ParseResult> returnList = new ArrayList<ParseResult>();

    Integer startPos = 0, endPos = 0;
    // apply style according to the style list
    for (int i = 0, iEnd = decorations.size(); i < iEnd; i += 2) {
      endPos = i + 2 < iEnd ? (Integer) decorations.get(i + 2) : content.length();
      startPos = (Integer) decorations.get(i);
      returnList.add(new ParseResult(startPos, endPos - startPos, Arrays.asList(new String[]{(String) decorations.get(i + 1)})));
    }

    return returnList;
  }
}
