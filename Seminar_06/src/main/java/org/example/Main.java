package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSetSimuliant<Integer> set = new HashSetSimuliant<>();
        System.out.println(set.add(12));
        System.out.println(set.add(12));
        System.out.println(set.add(122));
        System.out.println(set.add(123));
        System.out.println(set.size());

        System.out.println(set.remove(12));


        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(set.toString());
    }
}

class HashSetSimuliant<E>{
    private HashMap<E, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();
    public boolean add (E num){
        return map.put(num, OBJECT) == null;
    }
    public boolean remove (E num){
        return map.remove(num) != num;
    }
    public int size(){
        return map.size();
    }
    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }
    public  String toString(){
        return map.keySet().toString();
    }
}