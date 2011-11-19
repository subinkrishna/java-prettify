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
package prettify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Common Utilities.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Util {

    /**
     * Get all the matches for {@code string} compiled by {@code pattern}. If {@code isGlobal}
     * is true, the return results will only include the group 0 match.
     * @param pattern the regexp
     * @param string the string
     * @param isGlobal similar to JavaScript /g flag
     * @return all matches
     */
    public static String[] match(Pattern pattern, String string, boolean isGlobal) {
        List<String> matchesList = new ArrayList<String>();

        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matchesList.add(matcher.group(0));
            if (!isGlobal) {
                for (int i = 1, iEnd = matcher.groupCount(); i <= iEnd; i++) {
                    matchesList.add(matcher.group(i));
                }
            }
        }

        return matchesList.toArray(new String[matchesList.size()]);
    }

    /**
     * Test whether the {@code string} has at least one match by {@code pattern}.
     * @param pattern the regexp to test
     * @param string the string to test
     * @return true if at least one match, false if not any
     */
    public static boolean test(Pattern pattern, String string) {
        return pattern.matcher(string).find();
    }

    /**
     * Join the {@code strings} into one string.
     * @param strings the string objects
     * @return the joined string
     */
    public static String join(List<String> strings) {
        return join(strings.toArray(new String[strings.size()]));
    }

    /**
     * Join the {@code strings} into one string with {@code delimiter} in between.
     * @param strings the string objects
     * @return the joined string
     */
    public static String join(List<String> strings, String delimiter) {
        return join(strings.toArray(new String[strings.size()]), delimiter);
    }

    /**
     * Join the {@code strings} into one string.
     * @param strings the string objects
     * @return the joined string
     */
    public static String join(String[] strings) {
        return join(strings, null);
    }

    /**
     * Join the {@code strings} into one string with {@code delimiter} in between.
     * @param strings the string objects
     * @return the joined string
     */
    public static String join(String[] strings, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (delimiter != null && sb.length() != 0) {
                sb.append(delimiter);
            }
            sb.append(string);
        }
        return sb.toString();
    }

    /**
     * Remove identical adjacent tags from {@code decorations}.
     * @param decorations see {@link prettify.Job#decorations}
     * @param source the source code
     * @return the {@code decorations} after treatment
     */
    public static List<Object> removeDuplicates(List<Object> decorations, String source) {
        List<Object> returnList = new ArrayList<Object>();

        // use TreeMap to remove entrys with same pos
        Map<Integer, Object> orderedMap = new TreeMap<Integer, Object>();
        for (int i = 0, iEnd = decorations.size(); i < iEnd; i++) {
            orderedMap.put((Integer) decorations.get(i), decorations.get(i + 1));
            i++;
        }

        // remove adjacent style
        String previousStyle = null;
        for (Integer _pos : orderedMap.keySet()) {
            String style = (String) orderedMap.get(_pos);
            if (previousStyle != null && previousStyle.equals(style)) {
                continue;
            }
            returnList.add(_pos);
            returnList.add(style);
            previousStyle = style;
        }

        // remove last zero length tag
        int returnListSize = returnList.size();
        if (returnListSize >= 2 && returnList.get(returnListSize - 2).equals(source.length())) {
            returnList.remove(returnListSize - 2);
            returnList.remove(returnListSize - 2);
        }

        return returnList;
    }
}
