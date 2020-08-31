package com.avvessalom.icanlang.parser.ast;

import com.avvessalom.icanlang.lib.Constants;

public class ConstantExpression implements Expression {

    private final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public double eval() {
        if (!Constants.isExists(name)) throw new RuntimeException("Constant does not exist");
        return Constants.get(name);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
