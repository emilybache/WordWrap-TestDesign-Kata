package codingdojo;

/**
 * Word Wrap Kata.
 * Copyright (c) 2011, Peter Kofler, licensed under BSD License.
 * adapted from: http://www.code-cop.org/sourcecode/wordwrap/a20110716/WordWrapLoop.java
 */
public class WordWrapKoflerLoop implements WordWrap {

    private static final char BLANK = ' ';
    private static final char NEWLINE = '\n';

    public String wrap(String line, int maxLineLen) {
        StringBuilder accumulator = new StringBuilder();
        String remainingLine = line;
        while (remainingLine.length() > maxLineLen) {

            final int indexOfBlank = remainingLine.lastIndexOf(BLANK, maxLineLen);
            final int split;
            final int offset;
            if (indexOfBlank > -1) {
                split = indexOfBlank;
                offset = 1;
            } else {
                split = maxLineLen;
                offset = 0;
            }

            accumulator.append(remainingLine.substring(0, split));
            accumulator.append(NEWLINE);
            remainingLine = remainingLine.substring(split + offset);
        }
        accumulator.append(remainingLine);
        return accumulator.toString();
    }

    /*
     * Like recursive solution, but
     * 2*n+1 Strings are created
     * 1 StringBuilders are created
     * -> half objects created
     */

}
