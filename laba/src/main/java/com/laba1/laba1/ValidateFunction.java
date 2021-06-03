package com.laba1.laba1;


public class ValidateFunction {

    public static int convertToInt(String variable){

        try{
            int variableTemp = Integer.parseInt(variable);
            return variableTemp;
        }catch(NumberFormatException e){
            throw new NumberFormatException("Error 500");
        }
    }

    public static int validateMas(String mas){

        if (convertToInt(mas) <= 0){
            throw new IllegalArgumentException("Error 400. Incorrect mass.");
        }
        return convertToInt(mas);

    }
    public static int validateSpeed(String speed){
        if (convertToInt(speed) < 0)
        {
            throw new IllegalArgumentException("Error 400. Incorrect speed.");
        }
        return convertToInt(speed);
    }

    public static Greeting validateObject(GreetingString objstr){

        int tempmas1 = validateMas(objstr.getMas1());
        int tempmas2 = validateMas(objstr.getMas2());
        int tempspeed1 = validateSpeed(objstr.getSpeed1());
        int tempspeed2 = validateSpeed(objstr.getSpeed2());

        Greeting obj = new Greeting(tempmas1, tempmas2,tempspeed1,tempspeed2);
        return obj;
    }

}
