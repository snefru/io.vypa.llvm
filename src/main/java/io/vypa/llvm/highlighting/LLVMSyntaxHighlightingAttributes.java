package io.vypa.llvm.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.options.colors.AttributesDescriptor;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LLVMSyntaxHighlightingAttributes {

    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("LLVM_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("LLVM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = createTextAttributesKey("LLVM_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("LLVM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("LLVM_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("LLVM_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BRACES = createTextAttributesKey("LLVM_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("LLVM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey COMMA = createTextAttributesKey("LLVM_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("LLVM_BAD_TOKEN", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey BUILTIN_TYPE_REFERENCE = createTextAttributesKey("LLVM_BUILTIN_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey LABEL = createTextAttributesKey("LLVM_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey LOCAL_VARIABLE = createTextAttributesKey("LLVM_LOCAL_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("LLVM_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey TYPE_SPECIFICATION = createTextAttributesKey("LLVM_TYPE_SPECIFICATION", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey TYPE_REFERENCE = createTextAttributesKey("LLVM_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey EXPORTED_FUNCTION = createTextAttributesKey("LLVM_EXPORTED_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey FUNCTION_PARAMETER = createTextAttributesKey("LLVM_FUNCTION_PARAMETER", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey LOCAL_CONSTANT = createTextAttributesKey("LLVM_LOCAL_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("LLVM_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey DOT = createTextAttributesKey("LLVM_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("LLVM_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey COLON = createTextAttributesKey("LLVM_COLON", HighlighterColors.TEXT);

    public static final AttributesDescriptor[] ATTRIBUTES_DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Bad Character", BAD_CHARACTER),
            new AttributesDescriptor("Braces", BRACES),
            new AttributesDescriptor("Brackets", BRACKETS),
            new AttributesDescriptor("Comma", COMMA),
            new AttributesDescriptor("Identifier", IDENTIFIER),
            new AttributesDescriptor("Keyword", KEYWORD),
            new AttributesDescriptor("Label", LABEL),
            new AttributesDescriptor("LocalVariable", LOCAL_VARIABLE),
            new AttributesDescriptor("Parentheses", PARENTHESES),
            new AttributesDescriptor("Number", NUMBER),
            new AttributesDescriptor("String", STRING),
            new AttributesDescriptor("Type Reference", BUILTIN_TYPE_REFERENCE),
    };

}