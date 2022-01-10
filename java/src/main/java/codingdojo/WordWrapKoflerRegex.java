package codingdojo;

/**
 * Word Wrap Kata.
 * Copyright (c) 2011, Peter Kofler, licensed under BSD License.
 * adapted from: http://www.code-cop.org/sourcecode/wordwrap/a20110716/WordWrapRegex.java
 */
public class WordWrapKoflerRegex implements WordWrap {

    private static final char NEWLINE = '\n';

    public String wrap(String line, int maxLineLen) {
        return line.replaceAll("([^ ]{" + maxLineLen + "})" + // force split after exact maxLineLen of non spaces
                        "(?=[^ ])" + //                                    which must be followed by a non space
                        "|" + //                                           or
                        "(?=.{" + maxLineLen + "}.)" + //                  if we have more than maxLineLen characters here, then
                        "(.{1," + maxLineLen + "})" + //                   wrap at most after maxLineLen characters
                        " ", //                                            and drop the space afterwards
                "$1$2" + NEWLINE);
    }

}
