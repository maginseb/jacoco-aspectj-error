package de.example;

import java.util.Arrays;

public class CharArrayContainer {

    private char[] charArray = new char[0];

    public char[] getCharArray() {
        return Arrays.copyOf(charArray, charArray.length);
    }

    public void setCharArray(char[] charArray) {
        this.charArray = charArray;
    }

}
