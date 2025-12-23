package Test1;

import Test1.Model.Dataset;
import Test1.Model.Networker;
import Test1.Model.Tokenizer;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ai algorithm test n1");
        Manager manager = new Manager();

        System.out.println("Insert the word you want to tokenize: ");
        String word = scanner.nextLine();
        manager.callTokenizer(word);
        manager.callWord(manager.getTokens());
        manager.printTokens(manager.getTokens(), manager.getWord());


        int[] architecture = {3, 50, 10, 600, 300, 200, 100, 300, 5, 30, 10, 1};

        Networker networker = new Networker();

        networker.createNetwork(architecture);

        networker.forwardPass(manager.getTokens());
    }
}
