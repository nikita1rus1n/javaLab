package com.laba1.laba1;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Null;


@Data
public class GreetingString {

    private String mas1;
    private String mas2;
    private String speed1;
    private String speed2;

    public GreetingString(String mas1, String mas2, String speed1 , String speed2) {

        this.mas1 = mas1;
        this.mas2 = mas2;
        this.speed1 = speed1;
        this.speed2 = speed2;
    }


}