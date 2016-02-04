package io.vypa.llvm.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.vypa.llvm.LLVMLexerAdapter;
import io.vypa.llvm.psi.LLVMTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LLVMSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("LLVM_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("LLVM_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE = createTextAttributesKey("LLVM_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("LLVM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("LLVM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("LLVM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("LLVM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey TYPE_REFERENCE = createTextAttributesKey("LLVM_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);

    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] TYPE_REFERENCE_KEYS = new TextAttributesKey[]{TYPE_REFERENCE};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LLVMLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(LLVMTypes.KEYWORD))
            return KEY_KEYS;
        if (tokenType.equals(LLVMTypes.LOCAL_IDENTIFIER))
            return IDENTIFIER_KEYS;
        if (tokenType.equals(LLVMTypes.GLOBAL_IDENTIFIER))
            return IDENTIFIER_KEYS;
        if (tokenType.equals(LLVMTypes.METADATA_IDENTIFIER))
            return IDENTIFIER_KEYS;
        if (tokenType.equals(LLVMTypes.TYPE_LITERAL))
            return TYPE_REFERENCE_KEYS;
        if (tokenType.equals(LLVMTypes.LABEL_ID)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(LLVMTypes.METADATA)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(LLVMTypes.FLOAT_LITERAL)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(LLVMTypes.INTERGER_LITERAL)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(LLVMTypes.CHAR_ARRAY_LITERAL)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(LLVMTypes.COMMA)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(LLVMTypes.VALUE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(LLVMTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}