/*
 * Copyright 2025 Gabriele Bolognese
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package Transformer.Model;

import java.util.*;

public class Tokenizer {

    /*
     * Main variables of the tokenizer:
     *
     * 1) char -> token (integer)
     * 2) token -> char
     */
    private final HashMap<Character, Integer> charToToken;
    private final HashMap<Integer, Character> tokenToChar;

    // Length of the English alphabet
    private static final int ALPH_LENGTH = 26;

    /*
     * GOAL:
     * Each character in the English alphabet must correspond to
     * one and only one token, and vice versa.
     *
     * No symbols, no numbers, only lowercase letters a-z.
     */

    // Seed is passed to enforce deterministic randomness
    public Tokenizer(int seed) {
        charToToken = new HashMap<>();
        tokenToChar = new HashMap<>();
        initializeMap(seed);
    }

    /*
     * Uses a deterministic Random to shuffle tokens.
     * Same seed -> same mapping.
     */
    private void initializeMap(int seed) {

        /*
         * PURPOSE OF THIS ARRAY:
         * Create tokens from 0 to 25, shuffle them deterministically,
         * then assign each token to a character.
         */
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < ALPH_LENGTH; i++) {
            numbers.add(i); // 0, 1, 2, ..., 25
        }

        Collections.shuffle(numbers, new Random(seed));

        /*
         * ASCII logic:
         * 'a' = 97
         * 'a' + i produces characters from 'a' to 'z'
         */
        for (int i = 0; i < ALPH_LENGTH; i++) {
            char c = (char) ('a' + i);
            int token = numbers.get(i);

            charToToken.put(c, token);
            tokenToChar.put(token, c); // FIXED: use token, not i
        }

        // Print mapping so it is visible in output, remove the comment to make the print appear at the start of the program
        // printCharToToken();
    }

    /*
     * Debug / visualization method
     * Shows the final char -> token mapping
     */
    private void printCharToToken() {
        System.out.println("Char -> Token mapping:");
        charToToken.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue())
                );
    }
    /*
    * PURPOSE: using the charToToken map, given an input, return an array of int, where each int is the token of the character
    *
    * We initialize the 2 arrays of the same dimention, and with a for loop, iterate for each char to get the token*/
    public int[] parseWord(String input) {
        input = input.toLowerCase(); //Uppercase characters are different from lowercase ones, therefore it would give an error
        char[] chars = input.toCharArray();
        int[] tokens = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            tokens[i] = charToToken.get(chars[i]);
            System.out.print(tokens[i] + " ");
        }
        return tokens; //Used in Input.java
    }

    /*
    * PURPOSE: convert back the tokens (array of ints) to a word (array of chars)
    *
    * This method is simplier because we don't have to split the word, we need to already have the array of tokens*/
    public char[] parseToken(int[] tokens) {
        char[] chars = new char[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            chars[i] = tokenToChar.get(tokens[i]);
        }
        return chars; //used in Input.Java
    }

    // Getters
    public HashMap<Character, Integer> getCharToToken() {
        return charToToken;
    }

    public HashMap<Integer, Character> getTokenToChar() {
        return tokenToChar;
    }
}
