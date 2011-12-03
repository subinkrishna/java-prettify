// Copyright (C) 2011 Chan Wai Shing
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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * The style used by {@link prettify.theme} as those of CSS styles.
 * 
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Style {

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
    bold = false;
    color = Color.black;
    background = null;
    underline = false;
    italic = false;
  }

  /**
   * Apply the style to the AttributeSet.
   * Note that the AttributeSet should only be set by this function once or some unexpected style may appear.
   * @param attributeSet the AttributeSet to set the style on
   */
  public void setAttributeSet(SimpleAttributeSet attributeSet) {
    if (attributeSet == null) {
      return;
    }
    StyleConstants.setBold(attributeSet, bold);
    StyleConstants.setForeground(attributeSet, color);
    if (background != null) {
      StyleConstants.setBackground(attributeSet, background);
    } else {
      attributeSet.removeAttribute(StyleConstants.Background);
    }
    StyleConstants.setUnderline(attributeSet, underline);
    StyleConstants.setItalic(attributeSet, italic);
  }

  /**
   * Get the AttributeSet from this style.
   * @return the AttributeSet
   */
  public SimpleAttributeSet getAttributeSet() {
    SimpleAttributeSet attributeSet = new SimpleAttributeSet();
    StyleConstants.setBold(attributeSet, bold);
    StyleConstants.setForeground(attributeSet, color);
    if (background != null) {
      StyleConstants.setBackground(attributeSet, background);
    }
    StyleConstants.setUnderline(attributeSet, underline);
    StyleConstants.setItalic(attributeSet, italic);
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
    if (background == null) {
      throw new NullPointerException("argument 'background' cannot be null");
    }
    this.background = background;
  }

  public boolean isBold() {
    return bold;
  }

  public void setBold(boolean bold) {
    this.bold = bold;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    if (color == null) {
      throw new NullPointerException("argument 'color' cannot be null");
    }
    this.color = color;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setItalic(boolean italic) {
    this.italic = italic;
  }

  public boolean isUnderline() {
    return underline;
  }

  public void setUnderline(boolean underline) {
    this.underline = underline;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + (this.bold ? 1 : 0);
    hash = 59 * hash + (this.color != null ? this.color.hashCode() : 0);
    hash = 59 * hash + (this.background != null ? this.background.hashCode() : 0);
    hash = 59 * hash + (this.underline ? 1 : 0);
    hash = 59 * hash + (this.italic ? 1 : 0);
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
      object.bold = bold;
      object.color = color;
      object.background = background;
      object.underline = underline;
      object.italic = italic;
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

    return sb.toString();
  }
}