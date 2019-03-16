package com.liumapp;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestDemo {

    @Test
    public void index() {

        List<String> list = new CopyOnWriteArrayList<>();

        list.add("123456789");
        list.add("147852963");
        String str = "";

        for (int i=0; i<list.size()-1; i++) {

            str=str + list.get(0) +",";
        }
        str+=list.get(list.size()-1);

        System.out.println(str);
    }
}
