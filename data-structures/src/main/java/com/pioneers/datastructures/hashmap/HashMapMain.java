package com.pioneers.datastructures.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "three");
        map.put(3, "Three");
        System.out.println(map);

        System.out.println("map.size() = " + map.size());

        map.clear();
        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println(map);

        System.out.println("map.size() = " + map.size());

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "three");
        map.put(3, "Three");

        Map<Integer, String> map2 = new HashMap<>(map);
        map2.put(4, "Four");
        map2.put(5, "Five");

        System.out.println("map2 = " + map2);

        String value1 = map2.get(1);
        System.out.println("value1 = " + value1);

        System.out.println("map2.remove(1) = " + map2.remove(1));
        System.out.println("map2 = " + map2);

        System.out.println("map2.isEmpty() = " + map2.isEmpty());

        map2.putAll(map);

        System.out.println("map2 = " + map2);

        map2.putIfAbsent(6, "Six");
        System.out.println("map2 = " + map2);

        map2.putIfAbsent(6, "Six Number");
        System.out.println("map2 = " + map2);

        System.out.println("map2.containsKey(7) = " + map2.containsKey(7));

        map2.replace(6, "Six Number");
        System.out.println("map2 = " + map2);

        map2.replace(6, "Six Number", "Six");
        System.out.println("map2 = " + map2);

        System.out.println("hhhhhhh");
        // Iterate over keys by indexed for (wrong practice to iterate with indexed for)
        for (int i = 0; i < map2.size(); i++) {
            System.out.println(map2.get(i));
        }

        // Iterate over keys by enhanced for
        for (Integer key : map2.keySet()) {
            System.out.println("key = " + key);
        }

        System.out.println("---------------------");

        // Iterate over keys by forEach
        map2.keySet().forEach(System.out::println);

        System.out.println("---------------------");

        // Iterate over values by enhanced for
        for (String value : map2.values()) {
            System.out.println(value);
        }

        System.out.println("---------------------");

        // Iterate over values by forEach
        map2.values().forEach(System.out::println);

        System.out.println("---------------------");

        // Find all values that starts with T letter
        map2.values().stream()
                .filter(element -> isEqual(element, "T"))
                .forEach(System.out::println);

        Set<Map.Entry<Integer, String>> mapEntry = map2.entrySet();

        mapEntry.forEach(element -> {
            System.out.println(element.getKey());
            System.out.println(element.getValue());
            System.out.println("==================");
        });

        map2.put(7, "Six");
        map2.put(8, "Six");

        System.out.println("map2 = " + map2);

        List<Integer> filteredKeys = map2.entrySet()
                .stream()
                .filter(element -> isEqual(element, "Six"))
                .map(Map.Entry::getKey)
                .toList();

        filteredKeys.forEach(System.out::println);
    }

    private static boolean isEqual(final Map.Entry<Integer, String> element, final String value) {
        return element.getValue().equals(value);
    }

    public static boolean isEqual(final String element, final String value) {
        return element.equals(value);
    }
}
