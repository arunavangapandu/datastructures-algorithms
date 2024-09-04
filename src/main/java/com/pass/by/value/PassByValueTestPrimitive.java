package com.pass.by.value;

public class PassByValueTestPrimitive {

    public int passByValueCheck(int number){
        number = 10;

        return number;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println(new PassByValueTestPrimitive().passByValueCheck(number));
        System.out.println(number);

    }
}
