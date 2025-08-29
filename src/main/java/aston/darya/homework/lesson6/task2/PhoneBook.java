package aston.darya.homework.lesson6.task2;

import java.util.*;

public class PhoneBook {

    private Map<String, ArrayList<Long>> storage = new HashMap<>();

    public void add(String s, long number) {
        if (storage.containsKey(s)) {
            storage.get(s).add(number);
        } else {
            ArrayList<Long> list = new ArrayList<>();
            list.add(number);
            storage.put(s, list);
        }
    }

    public List<Long> get(String s) {
        return storage.get(s);
    }

    public void printAllContactsSorted() {
        List<String> surnames = new ArrayList<>(storage.keySet());
        Collections.sort(surnames);

        for (String surname : surnames) {
            System.out.println(surname + " : " + get(surname));
        }
    }
}
