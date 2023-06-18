package org.example;

import java.util.*;

public class Main {
    static ArrayList numbers = new ArrayList();

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            numbers.add(new Random().nextInt(20));
        }
        System.out.println(numbers);

        getMinMaxElement();
        double average = average(numbers);
        System.out.println("среднее значение ="+average);
        delEvenNumb();
    }
    public static void delEvenNumb(){
        Iterator iterator = numbers.iterator();
        while (iterator.hasNext()){
            int i = (Integer) iterator.next();
            if (i % 2 == 0){
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }
    public static void getMinMaxElement(){
        int min = (int) Collections.min(numbers);
        int max = (int) Collections.max(numbers);
        System.out.println("min="+ min);
        System.out.println("max="+max);
    }

    public static double average (ArrayList<Integer> list){
        int summ = 0;
        for (int elem : list) {
            summ += elem;
        }
        return summ/list.size();
    }
}