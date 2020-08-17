package com.avvessalom.icanlang.parser.ast;

public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double eval(){
        return value;
    }
}
