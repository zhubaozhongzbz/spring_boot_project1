package com.zbz.boot.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test {
    public static void main(String[] args) {

        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(3);
        Iterator<Integer> iterator = h.iterator();
        while (iterator.hasNext()){
            if(iterator.next()==2){
                iterator.remove();
            }
        }
    }
}
