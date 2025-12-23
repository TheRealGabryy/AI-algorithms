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


        int[] architecture = {3, 3, 3};

        Networker networker = new Networker();

        networker.createNetwork(architecture);

    }
}
