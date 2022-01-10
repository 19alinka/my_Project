package interpreter;

import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Words {
    // метод для выбора 5 слов из файла
    public static String[] random5Words(Properties property) {
        // ключи из файла загружаю в массив
        String[] arrayProperty = property.stringPropertyNames().toArray(new String[property.size()]);
        Set<Integer> set = new HashSet<>(); // коллекция для хранения уникальных чисел
        for (int i = 0; i < 10; i++) {
            int o = (int) (Math.random() * arrayProperty.length); // случайное число из размера массива
            if(set.size() < 5) { // пока set не заполниться 5 уникальными числами
                set.add(o); // добавляю числ в коллекцию
            }
        }
        String[] array5Property = new String[5]; // массив для хранения 5 случайных ключей
        int r = 0;
        for(int key : set) { // каждое число из set присваивается key
            array5Property[r] = arrayProperty[key]; // заполнение массива значениями
            r++;
        }
        return array5Property;
    }

    // метод для проверки на правильность
    public static void check(Properties property, String[] array5Property) {
        Scanner scanner = new Scanner(System.in);
        int error = 0;
        for (int i = 0; i < array5Property.length; i++) {
            System.out.println(array5Property[i]);
            String string = scanner.nextLine();
            if(property.getProperty(array5Property[i]).equalsIgnoreCase(string)) {
                System.out.println("Верно!");
                System.out.println();
            } else {
                System.out.println("Не верно :(");
                System.out.println("Правильный ответ: " + property.getProperty(array5Property[i]));
                System.out.println();
                error++;
            }
        }
        if(error > 0) {
            System.out.println("Количество допущенных ошибок: " + error);
        } else {
            System.out.println("Поздравляю, Вы на всё ответили правильно!");
        }
    }
}
