package codingdojo;

import java.util.ArrayList;

/**
 * This code is adapted from https://github.com/sblausten/word-wrap-kata
 */
public class WordWrapBlausten implements WordWrap {

    public String wrap(String text, int columnLength) {
        int textLength = text.length();
        if(textLength < columnLength) return text;
        char[] charsArray = text.toCharArray();
        ArrayList<String> textSections = new ArrayList<String>();
        int sectionCount = textLength / columnLength;
        int charIndex = 0;

        for (int i = 0; i < sectionCount; i++) {
            String section = "";
            int lengthTillLastSpace = charIndex + columnLength;
            System.out.println("1st length " + lengthTillLastSpace);
            while (charsArray[lengthTillLastSpace] != ' ') {
                lengthTillLastSpace -= 1;
            }
            int charsInThisSection = lengthTillLastSpace - charIndex;
            System.out.println("2nd length " + lengthTillLastSpace);
            for (int n = 0; n < charsInThisSection; n++) {
                section += charsArray[charIndex];
                charIndex++;
            }
            System.out.println("Index " + charIndex);
            //System.out.println(textSection);
            textSections.add(section.trim());
        }
        System.out.println("Near index " + charIndex);
        System.out.println("Text Length " + textLength);
        int remainingChars = textLength % charIndex;
        System.out.println("Remaining " + remainingChars);
        if(remainingChars > 0) {
            String section = "";
            for (int n = 0; n < remainingChars; n++) {
                section += charsArray[charIndex];
                charIndex++;
            }
            System.out.println("Final index " + charIndex);
            System.out.println("TotalChars " + charsArray.length);
            textSections.add(section.trim());
        }
        System.out.println(textSections.get(1));
        return text.join("\n", textSections);
    }
}
