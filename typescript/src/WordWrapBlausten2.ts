import WordWrap from "./WordWrap";

export class WordWrapBlausten2 implements WordWrap {
    public wrap(line: string, maxLineLen: number): string {
        return wrap_static(line, maxLineLen);
    }
}

function wrap_static(text: string, cols: number): string {
    if (cols >= text.length) return text;
    const colsToSpace = text.substring(0, cols).lastIndexOf(' ');
    let actualCols = colsToSpace == -1 ? cols : colsToSpace + 1;
    if (text.charAt(cols) == ' ') actualCols = cols + 1;
    return (text.substring(0, actualCols) + "\n" + wrap_static(text.substring(actualCols), cols));
}