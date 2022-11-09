package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class testlist {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2222");
        list.add("3333");

        boolean b = list.stream().allMatch(a -> a.equals("2222") && a.equals("3333"));
        Stream<String> stringStream = list.stream().filter(a -> a.equals("2222") && a.equals("3333"));
        System.out.println(b);
        System.out.println(stringStream.toString());
    }

}
