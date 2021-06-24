package com.khauminhduy.calcengine;

@CommandKeyword(name = "div")
public class Divider implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal / rightVal;
    }
}
