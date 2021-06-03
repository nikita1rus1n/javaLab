package com.laba1.laba1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;
import java.util.OptionalDouble;


@Slf4j
@Data
public class MinMaxAverage {

    private static int minResult;
    private static int maxResult;
    private static OptionalDouble averageResult;
    private  static ArrayList<Integer> resultList = new ArrayList<>();

    public static void setList(Cache cache){
        for (Map.Entry<String, Greeting> e: cache.setCacheMap()){
            resultList.add(e.getValue().getResult());
        }
    }

    public static int min(){

        minResult = resultList.stream().min(Integer::compareTo).get();
        return minResult;
    }

    public static int max(){
        maxResult = resultList.stream().max(Integer::compareTo).get();
        return maxResult;
    }

    public static OptionalDouble average(){
        averageResult = resultList.stream().mapToInt((x)->x).average();
        return averageResult;
    }

    public static int callMin(Cache cache){
        setList(cache);
        return min();
    }
    public static int callMax(Cache cache){
        setList(cache);
        return max();
    }
    public static OptionalDouble callAverage(Cache cache){
        setList(cache);
        return  average();
    }
}
