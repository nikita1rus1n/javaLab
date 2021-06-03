package com.laba1.laba1;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.Null;
import java.util.OptionalDouble;




@Data


public class Greeting {


    private int mas1;
    private int mas2;
    private int speed1;
    private int speed2;
    private int result;
    //private int min;
    //private int max;
    //private OptionalDouble average;


    public Greeting(int mas1, int mas2, int speed1 , int speed2) {

        this.mas1 = mas1;
        this.mas2 = mas2;
        this.speed1 = speed1;
        this.speed2 = speed2;
        this.result= (mas1*speed1+mas2*speed2)/(mas1+mas2);
    }
}
