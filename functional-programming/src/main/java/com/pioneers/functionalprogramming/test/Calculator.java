package com.pioneers.functionalprogramming.test;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Calculator {
    /**
     * Add two integer numbers.
     *
     * @param a is the first argument for summation.
     * @param b is the second argument for summation.
     * @return is the result of adding the first and the second parameters.
     */
    public static Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static Float add(Float a, Float b, Float c) {
        return a + b + c;
    }

    public static Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public static Float subtract(Float a, Float b, Float c) {
        return a - b - c;
    }

    public static Integer multiply(Integer a, Integer b) {
        return a * b;
    }
    
    public static Float multiply(Float a, Float b, Float c) {
        return a * b * c;
    }

    public static Float divide(Integer a, Integer b) {
        return (float) a / (float) b;
    }

    public static Float divide(Float a, Float b, Float c) {
        return a / b / c;
    }

    public static Float square(Integer number) {
        return (float) number * number;
    }

    public static Integer applySquare(Integer number) {
        return number * number;
    }
    
    public static Integer addOne(Integer number) {
        return number + 1;
    }

    public static Float squareRoot(Integer number) {
        return (float) Math.sqrt(number);
    }
}
