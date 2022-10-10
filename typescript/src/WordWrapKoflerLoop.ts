/**
 * Word Wrap Kata.
 * Copyright (c) 2011, Peter Kofler, licensed under BSD License.
 * adapted from: http://www.code-cop.org/sourcecode/wordwrap/a20110716/WordWrapLoop.java
 */
import WordWrap from "./WordWrap";


const BLANK = ' ';
const NEWLINE = '\n';


export class WordWrapKoflerLoop implements WordWrap {

    public wrap(line: string, maxLineLen: number): string {
        const accumulator = new StringBuilder();
        let remainingLine = line;
        while (remainingLine.length > maxLineLen) {

            const indexOfBlank = remainingLine.lastIndexOf(BLANK, maxLineLen);
            let split: number;
            let offset: number;
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

// Adapted from https://codereview.stackexchange.com/questions/230865/stringbuilder-to-build-or-not-to-build
export class StringBuilder {
    strArray: Array<string> = new Array<string>();

    constructor() {

    }

    get(nIndex: number): string {
        let str: string = null;
        if ((this.strArray.length > nIndex) && (nIndex >= 0)) {
            str = this.strArray[nIndex];
        }
        return (str);
    }

    isEmpty(): boolean {
        if (this.strArray.length == 0) return true;
        return (false);
    }

    append(str: string): void {
        if (str != null)
            this.strArray.push(str);
    }

    toString(): string {
        let str: string = this.strArray.join("");
        return (str);
    }

    toArrayString(delimeter: string): string {
        let str: string = this.strArray.join(delimeter);
        return (str);
    }

    clear() {
        this.strArray.length = 0;
    }
}