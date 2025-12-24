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
    private HashMap<Character, Integer> charToToken;
    private HashMap<Integer, Character> tokenToChar;

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

        // Print mapping so it is visible in output
        printCharToToken();
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

    // Getters
    public HashMap<Character, Integer> getCharToToken() {
        return charToToken;
    }

    public HashMap<Integer, Character> getTokenToChar() {
        return tokenToChar;
    }
}
