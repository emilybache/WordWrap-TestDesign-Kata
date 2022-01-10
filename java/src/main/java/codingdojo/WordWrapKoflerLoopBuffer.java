package codingdojo;

/**
 * Word Wrap Kata.
 * Copyright (c) 2011, Peter Kofler, licensed under BSD License.
 * adapted from: http://www.code-cop.org/sourcecode/wordwrap/a20110716/WordWrapLoopBuffer.java
 */
public class WordWrapKoflerLoopBuffer implements WordWrap {

    private static final char BLANK = ' ';
    private static final char NEWLINE = '\n';

    public String wrap(String line, int maxLineLen) {
        StringBuilder accumulator = new StringBuilder(calcMaxSize(line.length(), maxLineLen));
        accumulator.append(line);

        int pos = 0;
        int inserted = 0;
        while (pos + maxLineLen < line.length()) {
            final int indexOfBlank = line.lastIndexOf(BLANK, pos + maxLineLen);
            if (indexOfBlank > pos - 1) {
                accumulator.setCharAt(inserted + indexOfBlank, NEWLINE);
                pos = indexOfBlank + 1;
            } else {
                accumulator.insert(inserted + pos + maxLineLen, NEWLINE);
                pos = pos + maxLineLen;
                inserted++;
            }
        }

        return accumulator.toString();
    }

    /**
     * Calc a bigger buffer so we never resize.
     */
    private static int calcMaxSize(int lineLen, int maxLineLen) {
        final int maxCharsAdded = lineLen / maxLineLen;
        return lineLen + maxCharsAdded;
    }

    /*
     * Like optimized loop solution, but
     * 1 Strings are created
     * 1 StringBuilders are created
     * -> constant objects created
     */

}
