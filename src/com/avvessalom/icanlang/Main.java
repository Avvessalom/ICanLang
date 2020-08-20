package com.avvessalom.icanlang;

import com.avvessalom.icanlang.parser.Lexer;
import com.avvessalom.icanlang.parser.Parser;
import com.avvessalom.icanlang.parser.Token;
import com.avvessalom.icanlang.parser.ast.Expression;

import java.util.List;

public class Main {
    public static void main(String[] args){

        final String input = "#0F";
        final List<Token> tokens = new Lexer(input).tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }

        final List<Expression> expressions = new Parser(tokens).parse();
        for (Expression expr : expressions) {
            System.out.println(expr + " = " + expr.eval());
        }
    }
}
