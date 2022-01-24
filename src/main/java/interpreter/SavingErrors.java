package interpreter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SavingErrors {

    private static Map<String, Integer> engMap = new HashMap();
    private static Map<String, Integer> rusMap = new HashMap();

    public static Map<String, Integer> getEngMap() {
        return engMap;
    }

    public static void setEngMap(Map<String, Integer> engMap) {
        SavingErrors.engMap = engMap;
    }

    public static Map<String, Integer> getRusMap() {
        return rusMap;
    }

    public static void setRusMap(Map<String, Integer> rusMap) {
        SavingErrors.rusMap = rusMap;
    }

    public static void fixingErrors(String str) throws IOException, ClassNotFoundException {
        switch (Main.getTeam()) {
            case "1" -> {
                if (readMap(getEngMap()) != null) {
                    setEngMap(readMap(getEngMap()));
                }
                setEngMap(fixing(getEngMap(), str));
                setEngMap(writeMap(getEngMap()));
            }
            case "2" -> {
                if (readMap(getRusMap()) != null) {
                    setEngMap(readMap(getRusMap()));
                }
                setRusMap(fixing(getRusMap(), str));
                setRusMap(writeMap(getRusMap()));
            }
        }
    }

    private static Map<String, Integer> fixing(Map<String, Integer> map, String str) {
        if(map.containsKey(str)) { // проверяю есть ли str в map среди ключей
            map.replace(str, map.get(str) + 1); // увеличиваю значение
        } else {
            map.put(str, 1);
        }
        return map;
    }

    public static Map<String, Integer> writeMap(Map<String, Integer> map) throws IOException {
        switch (Main.getTeam()) {
            case "1" -> {
                FileOutputStream fs1 = new FileOutputStream("src/main/resources/engErrors.ser");
                ObjectOutputStream os1 = new ObjectOutputStream(fs1);
                os1.writeObject(map);
                os1.close();
            }
            case "2" -> {
                FileOutputStream fs2 = new FileOutputStream("src/main/resources/rusErrors.ser");
                ObjectOutputStream os2 = new ObjectOutputStream(fs2);
                os2.writeObject(map);
                os2.close();
            }
        }
        return map;
    }

    public static Map<String, Integer> readMap(Map<String, Integer> map) throws IOException, ClassNotFoundException {
        switch (Main.getTeam()) {
            case "1" -> {
                FileInputStream fs1 = new FileInputStream("src/main/resources/engErrors.ser");
                ObjectInputStream os1 = new ObjectInputStream(fs1);
                map = (Map<String, Integer>) os1.readObject();
                os1.close();
            }
            case "2" -> {
                FileInputStream fs2 = new FileInputStream("src/main/resources/rusErrors.ser");
                ObjectInputStream os2 = new ObjectInputStream(fs2);
                map = (Map<String, Integer>) os2.readObject();
                os2.close();
            }
        }
        return map;
    }
}
