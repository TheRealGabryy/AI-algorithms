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

package Transformer.Utils;

import Transformer.Model.Tokenizer;

/*
* PURPOSE OF THE CLASS:
*
* Handle all the information about the input of the user:
* The word as a string
* as an array of chars
* as an array of tokens
* as an embedding vector (TODO)*/
public class Input {

    //final because we initialize it and not modify it anymore.
    //basically: instead of passing a word to the tokenizer, we wrap it in this class, that has all possible representations. encapsulating the word
    private final String wordAsString;
    private final char[] wordAsChar;
    private final int[] wordAsTokens;

    /*EXPLANATION: when we call the constructor in the MAIN, passing the word as parameter we do this in ORDER:
    *
    * 1) initialize a manager (to get the tokenizer, automatically initializing it)
    * 2) parse the word into the tokenizer, returning the array of tokens.
    * 3) automatically, we then call the opposite algorithm: from token to char (since we already have the array of tokens)
    * 4) rebuild the word as a string using the new array of chars.*/
    public Input(String input) {
        Manager manager = new Manager();
        wordAsTokens = manager.getTokenizer().parseWord(input);
        wordAsChar = manager.getTokenizer().parseToken(wordAsTokens);
        wordAsString = new String(wordAsChar);
    }

    //Getters: to easily access every representation of the word from the main
    public String getWordAsString() {
        return wordAsString;
    }

    public char[] getWordAsChar() {
        return wordAsChar;
    }

    public int[] getWordAsTokens() {
        return wordAsTokens;
    }
}
