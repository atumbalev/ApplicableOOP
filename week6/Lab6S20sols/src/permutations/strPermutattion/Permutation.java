/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.strPermutattion;

import java.util.Arrays;

/**
 *
 * @author echrk
 */
public class Permutation {

    private char[] chars;

    public Permutation(String string) {
        if (string != null) {
            setChars(string.toCharArray());
        } else {
            setChars(new char[0]);
        }
    }

    /**
     * Get the value of chars
     *
     * @return the value of chars
     */
    public char[] getChars() {
        return chars;
    }

    /**
     * Set the value of chars
     *
     * @param chars new value of chars
     */
    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public static void makePermutations(String str) {
        String sorted = sort(str);
        makePermutations(sorted, "");
    }

    private static void makePermutations(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i > 0) {
                    if (str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                }
                makePermutations(str.substring(0, i) + str.substring(i + 1, str.length()), prefix + str.charAt(i));

            }
        }
    }

    private char[] sort() {// required to deal with duplicates!!!
        char[] sorted = Arrays.copyOf(chars, chars.length);
        Arrays.sort(sorted);
        return sorted;
    }

    public String makePermutations() {
        char[] sorted = sort();
        System.out.println(Arrays.toString(sorted));
        return Permutation.this.makePermutations(sorted, "");
    }
    static int c = 0;

    private String makePermutations(char[] sorted, String prefix) {
        System.out.println("c:     " + (c++));
        String result = "";
        if (sorted.length == 0) {
            return new String(prefix) + "\n";
        } else {
            for (int i = 0; i < sorted.length; i++) {
                if (i > 0) {
                    if (sorted[i] == sorted[i - 1]) {
                        continue;// ignore duplicates
                    }
                }
                System.out.println("sorted:" + new String(mergeChars(sorted, 0, i, i + 1, sorted.length)));
                System.out.println("prefix:" + prefix + sorted[i]);
                // make permutaion of prefix + sorted[i] with 
                // the rest of the arrayergeChars(sorted,0, i,i + 1, sorted.length)
                result += Permutation.this.makePermutations(mergeChars(sorted, 0, i, i + 1, sorted.length), prefix + sorted[i]);
            }
        }
        return result;
    }

    private char[] mergeChars(char[] chars, int begin1, int end1, int begin2, int end2) {
        char[] result = new char[end1 - begin1 + end2 - begin2];
        int index = begin1;
        for (int i = begin1; i < end1; i++) {
            result[index++] = chars[i];
        }
        for (int i = begin2; i < end2; i++) {
            result[index++] = chars[i];
        }
        return result;
    }

    private static String sort(String str) {// required to deal with duplicates!!!
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    public static void main(String[] args) {
        String test = "abc";
        Permutation permutation = new Permutation(test);
        System.out.println(permutation.makePermutations());
        //       Permutation.makePermutations(test);

    }
}
