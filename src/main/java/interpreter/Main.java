package interpreter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private static  final String HELP_STRING = """
                выбирай режим (введите цифру 1 или 2):""";

    private static void help() {
        System.out.println("Режимы:");
        System.out.println("1. с английского на русский");
        System.out.println("2. с русского на английский");
        System.out.println(HELP_STRING);
    }

    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        help();
        Scanner scanner = new Scanner(System.in);
        String team = scanner.nextLine();
        switch (team) {
            case "1":
                FileReader reader1 = new FileReader("src/main/resources/engWords.properties", StandardCharsets.UTF_8);
                property.load(reader1);
                Words.check(property, Words.random5Words(property));
                break;
            case "2":
                FileReader reader2 = new FileReader("src/main/resources/rusWords.properties", StandardCharsets.UTF_8);
                property.load(reader2);
                Words.check(property, Words.random5Words(property));
                break;
        }
    }
}
