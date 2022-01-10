package codingdojo;

public class WordWrapMartin implements WordWrap {

    @Override
    public String wrap(String line, int maxLineLen) {
        return Wrapper.wrap(line, maxLineLen);
    }
}

/**
 * This code is copied from https://thecleancoder.blogspot.com/2010/10/craftsman-62-dark-path.html
 */
class Wrapper {
    public static String wrap(String s, int col) {
        return new Wrapper(col).wrap(s);
    }

    private int col;

    private Wrapper(int col) {
        this.col = col;
    }

    private String wrap(String s) {
        if (s.length() <= col)
            return s;
        int space = (s.substring(0, col).lastIndexOf(' '));
        if (space != -1)
            return breakLine(s, space, 1);
        else if (s.charAt(col) == ' ')
            return breakLine(s, col, 1);
        else
            return breakLine(s, col, 0);
    }

    private String breakLine(String s, int pos, int gap) {
        return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap), col);
    }
}
