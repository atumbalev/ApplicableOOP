package com.providers;

import com.services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;
    public Wrapper(int size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Cipherable makeFixedSelection() {
        return new FixedRandom();
    }

    private class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random(seed);

            char[] result = new char[size];

            for (int i = 0; i < size; i++) {
                // Random range is non inclusive so we add 1 to include the 'Z'
                result[i] = (char) (random.nextInt('Z' - 'A' + 1) + 'A');
            }

            return result;
        }
    }

    public Cipherable makeFixedRandom() {
        return new FixedSelection();
    }

    private class FixedSelection implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random();

            char[] bankOfCharacters = new char[seed];

            for (int i = 0; i < seed; i++) {
                // Random range is non inclusive so we add 1 to include the 'Z'
                bankOfCharacters[i] = (char) (random.nextInt('Z' - 'A' + 1) + 'A');
            }

            char[] result = new char[size];

            for (int i = 0; i < size; i++) {
                result[i] = bankOfCharacters[random.nextInt(bankOfCharacters.length)];
            }

            return result;

        }
    }

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(5);
        System.out.println(wrapper.makeFixedRandom().getSecretChars(15));
    }
}
