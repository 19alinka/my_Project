package interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> word = new HashMap<>();
        word.put("city", "город");
        word.put("country", "страна");
        word.put("monuments", "памятник");

        java.io.File file = new java.io.File(String.valueOf(word));

        Properties properties = new Properties();
        properties.load(new FileReader(file));

        for (String key : properties.stringPropertyNames()) {
            System.out.println(properties.get(key));
        }
    }

//        Map<String, String> word = new HashMap<>();
//        word.put("city", "город");
//        word.put("country", "страна");
//        word.put("monuments", "памятник");

//        public static String randomWord() {
//            Set<String> keys = word.keySet();
//            String[] arrayKeys = (String[]) keys.toArray();
//            int rnd = (int) (Math.random() * 2);
//            return Arrays.toString(new String[]{arrayKeys[rnd]});
//        }

//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
   // }
}
