package com.providers;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        this.chars = chars;
        this.data = data;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char[] getChars() {
        return chars;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("Characters: %s%nResult: %d", Arrays.toString(chars), data);
    }
}
