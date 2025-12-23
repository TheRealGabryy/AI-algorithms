package Test1.Model;

public class Tokenizer {
    private Dataset dataset = new Dataset();
    public Tokenizer(int seed) {
        dataset.initializeMap(seed);
    }

    public int[] tokenize(String input) {
        int[] tokens = new int[input.length()];
        char[] chars = input.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = dataset.getToken(chars[i]);
        }
        return tokens;
    }

    public char[] characterize(int[] tokens) {
        char[] chars = new char[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            chars[i] = dataset.getChar(tokens[i]);
        }
        return chars;
    }


}
