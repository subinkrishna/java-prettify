// Copyright (C) 2011 David Leibovic
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package prettify.theme;

import java.awt.Color;
import java.awt.Font;

/**
 * Sunbrust theme.
 * Vim sunburst theme by David Leibovic.
 * 
 * @author David Leibovic
 */
public class ThemeSunburst extends Theme {

  public ThemeSunburst() {
    super();

    /* Vim sunburst theme by David Leibovic */

    setFont(new Font("Consolas", Font.PLAIN, 12));
    setBackground(Color.black);

    setHighlightedBackground(Color.decode("0x444444"));

    setGutterText(Color.decode("0xffffff"));
    setGutterBorderColor(Color.decode("0x777777"));
    setGutterBorderWidth(3);
    setGutterTextFont(new Font("Verdana", Font.PLAIN, 11));
    setGutterTextPaddingLeft(7);
    setGutterTextPaddingRight(7);

    Style plainStyle = new Style();
    plainStyle.setColor(Color.decode("0xffffff"));
    setPlain(plainStyle);

    Style style;

    style = new Style();
    style.setColor(Color.decode("0x65B042")); /* string  - green */
    setString(style);

    style = new Style();
    style.setColor(Color.decode("0xE28964")); /* keyword - dark pink */
    setKeyword(style);

    style = new Style();
    style.setColor(Color.decode("0xAEAEAE")); /* comment - gray */
    style.setItalic(true);
    setComment(style);

    style = new Style();
    style.setColor(Color.decode("0x89bdff")); /* type - light blue */
    setType(style);

    style = new Style();
    style.setColor(Color.decode("0x3387CC")); /* literal - blue */
    setLiteral(style);

    style = new Style();
    style.setColor(Color.decode("0xffffff")); /* punctuation - white */
    setPunctuation(style);

    style = new Style();
    style.setColor(Color.decode("0x89bdff")); /* html/xml tag    - light blue */
    setTag(style);

    style = new Style();
    style.setColor(Color.decode("0x3387CC")); /* decimal - blue */
    setDeclaration(style);

    style = new Style();
    style.setColor(Color.decode("0xbdb76b")); /* html/xml attribute name  - khaki */
    setAttributeName(style);

    style = new Style();
    style.setColor(Color.decode("0x65B042")); /* html/xml attribute value - green */
    setAttributeValue(style);

    setNoCode(plainStyle);

    setOpenBracket(plainStyle);

    setCloseBracket(plainStyle);

    setVariable(plainStyle);

    setFunction(plainStyle);
  }
}
