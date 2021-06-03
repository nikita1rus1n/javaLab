package com.laba1.laba1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class Counter extends Thread {                //Счётчик запросов
    private int counter;
    final Thread Counter;

    public Counter(){                                //Запуск потока
        this.Counter = new Thread();
        this.Counter.start();
    }

    @Override
    public void run(){
        log.info("Thread start()");
    }

    public synchronized void incrementCounter(){
        this.counter++;
    }
    public int getCounter() { return counter; }
}