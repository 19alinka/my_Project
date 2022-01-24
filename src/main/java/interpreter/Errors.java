package interpreter;

import java.io.IOException;
import java.util.*;

public class Errors {

    private static Object[] sortOfErrors(Map<String, Integer> map) throws IOException, ClassNotFoundException {
        SavingErrors.readMap(map); // считываю map
        Object[] values = new Object[map.size()]; // массив для хранения значений map
        int index = 0;
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) { // цикл для заполнения массива всеми значениями
            values[index] = mapEntry.getValue();
            index++;
        }
        Arrays.sort(values); // сортирую в порядке возрастания
        return values;
    }

    public static Set<String> numberOfErrors(Map<String, Integer> map) throws IOException, ClassNotFoundException {
        Set<String> set = new HashSet<>();
        if(sortOfErrors(map).length == 0) {
            System.out.println("Ошибок нет");
        } else if(sortOfErrors(map).length < 5) {
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                set.add(pair.getKey());
            }
        } else {
            // копирование в массив наибольших 5 значений
            Object[] copy = Arrays.copyOfRange(sortOfErrors(map), sortOfErrors(map).length - 5, sortOfErrors(map).length);
            for (Object o : copy) { // цикл для сохранения слов с наибольшими значениями в set
                for (Map.Entry<String, Integer> pair : map.entrySet()) {
                    if (pair.getValue() == o) {
                        set.add(pair.getKey());
                    }
                }
            }
        }
        return set;
    }
}
