import WordWrap from "./WordWrap";


export class WordWrapMartin implements WordWrap {

    public wrap(line: string, maxLineLen: number): string {
        return Wrapper.wrap(line, maxLineLen);
    }
}

/**
 * This code is copied from https://thecleancoder.blogspot.com/2010/10/craftsman-62-dark-path.html
 */
class Wrapper {
    public static wrap(s: string, col: number): string {
        return new Wrapper(col).wrap(s);
    }

    private col: number;

    private constructor(col: number) {
        this.col = col;
    }

    private wrap(s: string): string {
        if (s.length <= this.col)
            return s;
        const space: number = (s.substring(0, this.col).lastIndexOf(' '));
        if (space != -1)
            return this.breakLine(s, space, 1);
        else if (s.charAt(this.col) == ' ')
            return this.breakLine(s, this.col, 1);
        else
            return this.breakLine(s, this.col, 0);
    }

    private breakLine(s: string, pos: number, gap: number): string {
        return s.substring(0, pos) + "\n" + Wrapper.wrap(s.substring(pos + gap), this.col);
    }
}
