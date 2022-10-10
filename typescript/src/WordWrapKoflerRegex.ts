/**
 * Word Wrap Kata.
 * Copyright (c) 2011, Peter Kofler, licensed under BSD License.
 * adapted from: http://www.code-cop.org/sourcecode/wordwrap/a20110716/WordWrapRegex.java
 */
import WordWrap from "./WordWrap";


const  NEWLINE = '\n';

export  class WordWrapKoflerRegex implements WordWrap {


    public wrap(line:string, maxLineLen:number):string {
        return line.replaceAll("([^ ]{" + maxLineLen + "})" + // force split after exact maxLineLen of non spaces
                        "(?=[^ ])" + //                                    which must be followed by a non space
                        "|" + //                                           or
                        "(?=.{" + maxLineLen + "}.)" + //                  if we have more than maxLineLen characters here, then
                        "(.{1," + maxLineLen + "})" + //                   wrap at most after maxLineLen characters
                        " ", //                                            and drop the space afterwards
                "$1$2" + NEWLINE);
    }

}
