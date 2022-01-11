package interpreter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private static  final String HELP_STRING = """
                Выберите режим (введите цифру 1 или 2):""";

    private static void help() {
        System.out.println("Режимы:");
        System.out.println("1. C английского на русский");
        System.out.println("2. C русского на английский");
        System.out.println(HELP_STRING);
    }

    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        help();
        Scanner scanner = new Scanner(System.in);
        String team = scanner.nextLine();
        System.out.println("Выберите количество слов: от 1 до 20");
        int quantity = scanner.nextInt();
        switch (team) {
            case "1":
                FileReader reader1 = new FileReader("src/main/resources/engWords.properties", StandardCharsets.UTF_8);
                property.load(reader1);
                Words.check(property, Words.randomWords(property, quantity));
                break;
            case "2":
                FileReader reader2 = new FileReader("src/main/resources/rusWords.properties", StandardCharsets.UTF_8);
                property.load(reader2);
                Words.check(property, Words.randomWords(property, quantity));
                break;
        }
    }
}
