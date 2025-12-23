package Test1;

import Test1.Model.Dataset;
import Test1.Model.Tokenizer;

public class Manager {
    private Tokenizer tokenizer = new Tokenizer(1);
    private int[] tokens;
    private char[] word;

    public void callTokenizer(String input) {
        tokens = tokenizer.tokenize(input);
    }

    public void callWord(int[] tokens) {
        word = tokenizer.characterize(tokens);
    }

    public void printTokens(int[] tokens, char[] word) {
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(word[i] + " " + tokens[i]);
        }
    }




    public int[] getTokens() {
        return tokens;
    }

    public void setTokens(int[] tokens) {
        this.tokens = tokens;
    }

    public char[] getWord() {
        return word;
    }

    public void setWord(char[] word) {
        this.word = word;
    }
}
