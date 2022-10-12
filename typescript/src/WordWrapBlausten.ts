/**
 * This code is adapted from https://github.com/sblausten/word-wrap-kata
 */
import WordWrap from "./WordWrap";

export class WordWrapBlausten implements WordWrap {

    public wrap(text: string, columnLength: number): string {
        const textLength = text.length;
        if (textLength < columnLength) return text;
        const charsArray = text.split('');
        const textSections: string[] = [];
        const sectionCount = textLength / columnLength;
        let charIndex = 0;

        for (let i = 0; i < sectionCount; i++) {
            let section = "";
            let lengthTillLastSpace = charIndex + columnLength;
            console.log("1st length " + lengthTillLastSpace);
            while (charsArray[lengthTillLastSpace] != ' ') {
                if (charsArray[lengthTillLastSpace] === undefined) {
                    throw Error("ArrayIndexOutOfBoundsException : " +
                        "Index " + lengthTillLastSpace + " out of bounds for length " + charsArray.length)
                }
                lengthTillLastSpace -= 1;
            }
            const charsInThisSection = lengthTillLastSpace - charIndex;
            console.log("2nd length " + lengthTillLastSpace);
            for (let n = 0; n < charsInThisSection; n++) {
                section += charsArray[charIndex];
                charIndex++;
            }
            console.log("Index " + charIndex);
            //console.log(textSection);
            textSections.push(section.trim());
        }
        console.log("Near index " + charIndex);
        console.log("Text Length " + textLength);
        const remainingChars = textLength % charIndex;
        console.log("Remaining " + remainingChars);
        if (remainingChars > 0) {
            let section = "";
            for (let n = 0; n < remainingChars; n++) {
                section += charsArray[charIndex];
                charIndex++;
            }
            console.log("Final index " + charIndex);
            console.log("TotalChars " + charsArray.length);
            textSections.push(section.trim());
        }
        console.log(textSections[1]);
        return textSections.join("\n")
    }
}
