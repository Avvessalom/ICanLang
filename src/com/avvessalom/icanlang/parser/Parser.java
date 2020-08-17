package com.avvessalom.icanlang.parser;

import com.avvessalom.icanlang.parser.ast.BinaryExpression;
import com.avvessalom.icanlang.parser.ast.Expression;
import com.avvessalom.icanlang.parser.ast.NumberExpression;

import java.util.List;

public class Parser {
    private static final Token EOF = new Token(TokenType.EOF, "");

    private final List<Token> tokens;
    private int pos;
    private final int size;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        size = tokens.size();
    }

    public List<Exception> parse() {
        return null;
    }

    private Expression expression() {
        return additive();
    }

    private Expression additive() {
        Expression result = multiplicative();

        while (true) {
            if(match(TokenType.PLUS)) {
                result = new BinaryExpression('+', result, multiplicative());
                continue;
            }
            if(match(TokenType.MINUS)) {
                result = new BinaryExpression('-', result, multiplicative());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression multiplicative() {
        Expression result = unary();

        while (true) {
            if(match(TokenType.STAR)) {
                result = new BinaryExpression('*', result, unary());
                continue;
            }
            if(match(TokenType.SLASH)) {
                result = new BinaryExpression('/', result, unary());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression unary() {
        return primary();
    }

    private Expression primary() {
        final Token current = get(0);
        if (match(TokenType.NUMBER)) {
            return new NumberExpression(Double.parseDouble(current.getText()));
        }
        throw new RuntimeException("Unknown expression");
    }

    private boolean match(TokenType type) {
        final Token current = get(0);
        if (type != current.getType()) return false;
        pos++;
        return true;
    }

    private Token get(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= size) return EOF;
        return tokens.get(position);
    }
}
