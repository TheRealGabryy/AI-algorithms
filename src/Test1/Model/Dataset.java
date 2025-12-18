package Test1.Model;

import java.util.HashMap;
import java.util.Random;

public class Dataset {
    private final HashMap<Character, Integer> charToToken = new HashMap<>();
    private static final int ALPHABET_LENGTH = 26;

    public void initializeMap(int seed) {
        int[] nums = new int[ALPHABET_LENGTH];

        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            nums[i] = i;
        }

        // deterministic shuffle
        Random rand = new Random(seed);
        for (int i = ALPHABET_LENGTH - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // map a..z to shuffled tokens
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            char c = (char) ('a' + i);
            charToToken.put(c, nums[i]);
            System.out.println(c + " -> " + nums[i]);
        }
    }
}
