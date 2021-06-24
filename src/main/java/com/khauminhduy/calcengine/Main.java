package com.khauminhduy.calcengine;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" ");
        String keyword = parts[0];
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);

        process(keyword, leftVal, rightVal);
    }

    private static void process(String keyword, double leftVal, double rightVal) {
        Object processor = retrieveProcessor(keyword);
        double result = 0d;
        if(processor instanceof MathProcessing) {
            result = ((MathProcessing) processor).doCalculation(leftVal, rightVal);
        } else {
            result = handlerCalculate(processor, leftVal, rightVal);
        }
        System.out.println("result = " + result);
    }

    private static double handlerCalculate(Object processor, double leftVal, double rightVal) {
        double result = 0d;

        try {
            CommandKeyword annotation = processor.getClass().getAnnotation(CommandKeyword.class);
            String method = annotation.method();
            Method calculate = processor.getClass().getMethod(method, double.class, double.class);
            result = (double) calculate.invoke(processor, leftVal, rightVal);

        } catch (Exception e) {
            System.out.println("Error accessing method - " + e.getMessage());
        }

        return result;
    }

    private static Object retrieveProcessor(String keyword) {
        Object[] processors = {new Adder(), new Subtracter(), new Multiplier(), new Divider(), new PowerOf()};

        for (Object processor : processors) {
            CommandKeyword annotation = processor.getClass().getAnnotation(CommandKeyword.class);
            String name = annotation.value();
            if (keyword.equalsIgnoreCase(name)) {
                return processor;
            }
        }

        return null;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if (value == -1d)
            value = Double.parseDouble(word);

        return value;
    }

}









