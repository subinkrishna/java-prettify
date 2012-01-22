package syntaxhighlight;

import java.util.List;

/**
 * The parser interface for syntax highlight.
 * 
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public interface Parser {

  /**
   * Parse the {@code content} and return the parsed result.
   * @param fileExtension the file extension of the content, null means not provided
   * @param content the content
   * @return the parsed result
   */
  List<ParseResult> parse(String fileExtension, String content);
}
