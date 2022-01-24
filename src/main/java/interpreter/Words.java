package interpreter;

import java.io.IOException;
import java.util.*;

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
    public static void check(Properties property, String[] arrayQuantity) throws IOException, ClassNotFoundException {
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
                SavingErrors.fixingErrors(arrayQuantity[i]); // добавляю каждую ошибку в map
                error++;
            }
        }
        if(error > 0) {
            System.out.printf("\n" + "Количество допущенных ошибок: %s", error);
        } else {
            System.out.println("\n" + "Поздравляю, Вы на всё ответили правильно!");
        }
    }
}
