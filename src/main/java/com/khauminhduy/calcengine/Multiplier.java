package com.khauminhduy.calcengine;

@CommandKeyword(name = "mul")
public class Multiplier implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal * rightVal;
    }
}
