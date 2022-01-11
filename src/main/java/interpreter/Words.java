package interpreter;

import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Words {
    // метод для выбора 5 слов из файла
    public static String[] randomWords(Properties property, int quantity) {
        // ключи из файла загружаю в массив
        String[] arrayProperty = property.stringPropertyNames().toArray(new String[property.size()]);
        Set<Integer> set = new HashSet<>(); // коллекция для хранения уникальных чисел
        while (set.size() < quantity) {
            int o = (int) (Math.random() * arrayProperty.length);
            set.add(o);
        }
        String[] arrayQuantity = new String[quantity]; // массив для хранения случайных ключей
        int r = 0;
        for(int key : set) { // каждое число из set присваивается key
            arrayQuantity[r] = arrayProperty[key]; // заполнение массива значениями
            r++;
        }
        return arrayQuantity;
    }

    // метод для проверки на правильность
    public static void check(Properties property, String[] arrayQuantity) {
        Scanner scanner = new Scanner(System.in);
        int error = 0;
        for (int i = 0; i < arrayQuantity.length; i++) {
            System.out.println("\n" + arrayQuantity[i]);
            String string = scanner.nextLine();
            if(property.getProperty(arrayQuantity[i]).equalsIgnoreCase(string)) {
                System.out.println("Верно!");
            } else {
                System.out.println("Не верно :(");
                System.out.println("Правильный ответ: " + property.getProperty(arrayQuantity[i]));
                error++;
            }
        }
        if(error > 0) {
            System.out.printf("\n" + "Количество допущенных ошибок: %s из %d слов%n", error, arrayQuantity.length);
        } else {
            System.out.println("\n" + "Поздравляю, Вы на всё ответили правильно!");
        }
    }
}
