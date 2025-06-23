package com.pioneers.functionalprogramming.test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

import static com.pioneers.functionalprogramming.test.StudentHandler.getStudentInfo;

public class FirstClassCitizen {

    public static void main(String[] args) {
        float squareNumber = processFunction(Calculator::square, 10);
        System.out.println("squareNumber = " + squareNumber);
        
        float squareRoot = processFunction(Calculator::squareRoot, 100);
        System.out.println("squareRoot = " + squareRoot);

        int num = applyOperation(Calculator::subtract, 2, 3);
        System.out.println("num = " + num);

        TripleFunction myOwnFunction = (a, b, c) -> (a + b) * c;

        float result = applyTripleOperation(myOwnFunction, 1.0f, 2.0f, 3.0f);
        System.out.println("result = " + result);

        float multiplyResult = applyTripleOperation(Calculator::multiply, 3.0f, 4.0f, 5.0f);
        System.out.println("multiplyResult = " + multiplyResult);

        Function<Function<Integer, Integer>, Integer> function = returnCustomFunction(Calculator::subtract, 2, 4);
        int square = function.apply(Calculator::addOne);
        System.out.println("square = " + square);

        Function<Integer, Integer> function1 = Calculator::addOne;
        Function<Integer, Integer> function2 = Calculator::applySquare;

        Function<Integer, Integer> function3 = function1.compose(function2);

        System.out.println("function3.apply(3) = " + function3.apply(3));


        Student student = new Student("Salma", "Khaled", 22, "salma.khaled@techpioneershub.com");
        String fullName = getStudentInfo(StudentHandler::concatenateFullName, student);
        System.out.println("fullName = " + fullName);
        String email = getStudentInfo(StudentHandler::getStudentEmail, student);
        System.out.println("email = " + email);
    }

    public static Float processFunction(IntFunction<Float> function, int number) {
        return function.apply(number);
    }

    public static Integer applyOperation(BiFunction<Integer, Integer, Integer> function, int a, int b) {
        return function.apply(a, b);
    }

    // Todo: Modify this method
    /*public static BiFunction<Integer, Integer, Integer> applyTheOperation(BiFunction<Integer, Integer, Integer> function, int a, int b) {
        return function.apply(a, b);
    }*/

    public static Float applyTripleOperation(TripleFunction function, Float a, Float b, Float c) {
        return function.doApply(a, b, c);
    }

    public static Function<Function<Integer, Integer>, Integer> returnCustomFunction(
            BiFunction<Integer, Integer, Integer> function,
            int num1,
            int num2
    ) {

        int result = function.apply(num1, num2);

       return function1 -> function1.apply(result);
    }
}
