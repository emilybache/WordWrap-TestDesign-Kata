package codingdojo;

/**
 * This code is adapted from https://github.com/sblausten/word-wrap-kata
 */
public class WordWrapBlausten2 implements WordWrap {
    @Override
    public String wrap(String line, int maxLineLen) {
        return WordWrapBlausten2.wrap_static(line, maxLineLen);
    }

    private static String wrap_static(String text, int cols) {
        if (cols >= text.length()) return text;
        int colsToSpace = text.substring(0, cols).lastIndexOf(' ');
        int actualCols = colsToSpace == -1 ? cols : colsToSpace + 1;
        if (text.charAt(cols) == ' ') actualCols = cols + 1;
        return (text.substring(0, actualCols) + "\n" + WordWrapBlausten2.wrap_static(text.substring(actualCols), cols));
    }
}
