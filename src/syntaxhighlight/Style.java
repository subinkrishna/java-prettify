// Copyright (C) 2012 Chan Wai Shing
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
package syntaxhighlight;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * The style used by {@link syntaxhiglight.Theme} as those of CSS styles.
 * 
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Style implements Cloneable {

  protected boolean changed;
  protected SimpleAttributeSet attributeSet;
  //
  protected boolean bold;
  protected Color color;
  /**
   * The background color, null means no background color is set.
   */
  protected Color background;
  protected boolean underline;
  protected boolean italic;

  /**
   * Constructor.
   * <p>
   * <b>Default values:</b><br />
   * <ul>
   * <li>bold: false;</li>
   * <li>color: black;</li>
   * <li>background: null;</li>
   * <li>underline: false;</li>
   * <li>italic: false;</li>
   * </ul>
   * </p>
   */
  public Style() {
    changed = true;
    attributeSet = null;

    bold = false;
    color = Color.black;
    background = null;
    underline = false;
    italic = false;
  }

  /**
   * Get the AttributeSet from this style.
   * @return the AttributeSet
   */
  public SimpleAttributeSet getAttributeSet() {
    if (changed) {
      attributeSet = new SimpleAttributeSet();
      StyleConstants.setBold(attributeSet, bold);
      StyleConstants.setForeground(attributeSet, color);
      if (background != null) {
        StyleConstants.setBackground(attributeSet, background);
      }
      StyleConstants.setUnderline(attributeSet, underline);
      StyleConstants.setItalic(attributeSet, italic);
      changed = false;
    }
    return attributeSet;
  }

  /**
   * Get the background color.
   * @return the background color or null if no color is set
   */
  public Color getBackground() {
    return background;
  }

  /**
   * Set the background color.
   * @param background input null means do not set the background
   */
  public void setBackground(Color background) {
    changed = true;
    this.background = background;
  }

  public boolean isBold() {
    return bold;
  }

  public void setBold(boolean bold) {
    changed = true;
    this.bold = bold;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    if (color == null) {
      throw new NullPointerException("argument 'color' cannot be null");
    }
    changed = true;
    this.color = color;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setItalic(boolean italic) {
    changed = true;
    this.italic = italic;
  }

  public boolean isUnderline() {
    return underline;
  }

  public void setUnderline(boolean underline) {
    changed = true;
    this.underline = underline;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + (this.bold ? 1 : 0);
    hash = 97 * hash + (this.color != null ? this.color.hashCode() : 0);
    hash = 97 * hash + (this.background != null ? this.background.hashCode() : 0);
    hash = 97 * hash + (this.underline ? 1 : 0);
    hash = 97 * hash + (this.italic ? 1 : 0);
    return hash;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Style)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Style _object = (Style) obj;
    return _object.bold == bold && _object.color.equals(color) && _object.background.equals(background)
            && _object.underline == underline && _object.italic == italic;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Style clone() {
    Style object = null;
    try {
      object = (Style) super.clone();
    } catch (CloneNotSupportedException ex) {
    }
    return object;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    sb.append(getClass().getName());
    sb.append(": ");
    sb.append("bold: ").append(bold);
    sb.append(", ");
    sb.append("color: ").append(color);
    sb.append(", ");
    sb.append("bg: ").append(background);
    sb.append(", ");
    sb.append("underline: ").append(underline);
    sb.append(", ");
    sb.append("italic: ").append(italic);
    sb.append("]");

    return sb.toString();
  }
}
