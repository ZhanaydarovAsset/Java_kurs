package org.example;

/*
1.Организовать ввод и хранение данных пользователей. ФИО возраст и пол
2.вывод в формате Фамилия И.О. возраст пол
3.добавить возможность выхода или вывода списка отсортированного по возрасту!)
4.*реализовать сортировку по возрасту с использованием индексов
5.*реализовать сортировку по возрасту и полу с использованием индексов
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<String[]> humans = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> lastname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();

        System.out.println("ВВедите ФИО, возраст и пол через пробел: ");

        while (true){
            String ofUser = input.nextLine();
            if(ofUser.equals("q")){
                break;
            }
            else{
                humans.add(ofUser.split(" "));
            }
        }
        for (String[] elem : humans) {
            System.out.printf("%s %s. %s. %s %s\n", elem[0], elem[1].toUpperCase().charAt(0),
                    elem[2].toUpperCase().charAt(0), elem[3], elem[4]);
        }
        System.out.println("--------------");

        for (String[] man : humans) {
            surname.add(man[0]);
            name.add(man[1]);
            lastname.add(man[2]);
            age.add(Integer.parseInt(man[3]));
            gender.add(man[4].toLowerCase().contains("м"));
        }

        Integer[] indexes = new Integer[age.size()];

        for (int i = 0; i < age.size(); i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(age.get(a), age.get(b));
            }
        });

        Arrays.sort(indexes, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Boolean.compare(gender.get(a), gender.get(b));
            }
        });

        for (Integer i : indexes) {
            System.out.printf("%s %s. %s. %s %s\n", humans.get(i)[0], humans.get(i)[1].toUpperCase().charAt(0),
                        humans.get(i)[2].toUpperCase().charAt(0), humans.get(i)[3], humans.get(i)[4]);
        }
        System.out.println("Для выхода нажмите 'q'");
        String exit = input.nextLine();
        if(exit.equals("q")){
            System.exit(0);
        }
    }
}
/*
Саматов Cамат Саматович 23 м
Косжанова Айгул Максатовна 21 ж
Петров Петр Давидович 45 м
Иванов Иван Иванович 12 м
Смирнова Инна Ивановна 45 ж
 */