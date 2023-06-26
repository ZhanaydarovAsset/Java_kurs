package org.example;

import java.lang.reflect.Array;

/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
 их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map <String, ArrayList> abonent = new HashMap<>();
    public static void main(String[] args) {
        addAbonent("Петя", "777-777-777");
        addAbonent("Петя", "888-888-888");
        addAbonent("Вася", "876-855-578");
        addAbonent("Юля", "771-258-786");
        addAbonent("Коля", "701-888-898");
        addAbonent("Коля", "702-898-888");
        addAbonent("Коля", "702-666-888");
        
        sortAndPrint();
    }

    public static void addAbonent (String name, String phone){
        if(abonent.containsKey(name)){
            abonent.get(name).add(phone);
        }
        else{
            ArrayList list = new ArrayList<>();
            list.add (phone);
            abonent.put(name, list);
        }
    }
    public static void sortAndPrint() {
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList<>(abonent.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            public int compare (Map.Entry<String, ArrayList> arg1, Map.Entry<String, ArrayList> arg2){
                return arg2.getValue().size() - arg1.getValue().size();
            }
        });
        for (Map.Entry<String,ArrayList> entry : list) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}