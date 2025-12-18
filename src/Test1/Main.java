package Test1;

import Test1.Model.Dataset;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ai algorithm test n1");

        System.out.println("Insert the word you want to tokenize: ");
        String word = scanner.nextLine();
        Dataset dataset = new Dataset();
        dataset.initializeMap(1);

    }
}
