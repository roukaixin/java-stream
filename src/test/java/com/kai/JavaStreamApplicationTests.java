package com.kai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest(classes = JavaStreamApplication.class)
class JavaStreamApplicationTests {


    @Test
    void list(){
        List<String> author = Producer.getAuthor();
        Stream<String> stream = author.stream();
    }

    @Test
    void array(){
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream = Stream.of(arr);
    }

    @Test
    void map(){
        Map<String, Integer> map = new HashMap<>();
        map.put("王者荣耀",18);
        map.put("和平精英",19);
        map.put("金铲铲",16);

        // entry 对象 ， key - value
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream = entries.stream();

        // map key 集合
        Set<String> keySet = map.keySet();
        Stream<String> stringStream = keySet.stream();
    }

    @Test
    void test01(){
        List<String> author = Producer.getAuthor();

        Stream<String> stringStream = author.parallelStream();
    }

    @Test
    void test02(){
        List<String> author = Producer.getAuthor();
        Stream<String> stream = author.stream();
        Stream<String> parallel = stream.parallel();
    }

}
