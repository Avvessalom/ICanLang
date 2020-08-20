package com.avvessalom.icanlang.parser.ast;

public class UnaryExpression implements Expression {
    private final char operation;
    private final Expression expr;

    public UnaryExpression(char operation, Expression expr){
        this.operation = operation;
        this.expr = expr;
    }

    @Override
    public double eval() {
        switch (operation) {
            case '-': return -expr.eval();
            case '+':
            default: return expr.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("%c %s", operation, expr);
    }
}
