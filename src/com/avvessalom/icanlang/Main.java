package com.avvessalom.icanlang;

import com.avvessalom.icanlang.parser.Lexer;
import com.avvessalom.icanlang.parser.Token;

import java.util.List;

public class Main {
    public static void main(String[] args){

        final String input = "2 + 2 - 3";
        final List<Token> tokens = new Lexer(input).tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
