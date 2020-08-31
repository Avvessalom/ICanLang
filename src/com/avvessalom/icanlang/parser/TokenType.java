package com.avvessalom.icanlang.parser;

public enum TokenType {

    NUMBER,      // 10th numbers
    HEX_NUMBER,  // 16th numbers
    BIN_NUMBER,  //2th numbers
    WORD,   // constant or words

    PLUS,   // +
    MINUS,  // -
    STAR,   // *
    SLASH,  // /

    LPAREN, // (
    RPAREN, // )

    EOF     // End Of File
}
