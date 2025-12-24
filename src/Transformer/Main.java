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

package Transformer;

import Transformer.Model.Dataset;
import Transformer.Model.Tokenizer;
import Transformer.Utils.Manager;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test for the second algorithm of ai");
        Manager manager = new Manager();
        Tokenizer tokenizer = manager.getTokenizer();
        Dataset dataset = manager.getDataset();

        /*
        * When entering a word, ensure with a rule based algorithm that the word isn't empty,
        * or that the word doesn't contain numbers or special symbols, because the tokenizer can't
        * tokenize such symbols.*/
        System.out.println("Type a word to complete: ");
        String word;
        do {
            System.out.print("-> ");
            word = scanner.next();
            if (checkInput(word)) {
                System.out.println("You typed a wrong word. Try again.");
            }
        } while (checkInput(word));
        tokenizer.parseWord(word);

    }

    public static boolean checkInput(String word) {
        if (word.isBlank()) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
