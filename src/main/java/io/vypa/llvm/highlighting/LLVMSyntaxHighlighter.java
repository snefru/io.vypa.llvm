package io.vypa.llvm.highlighting;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import io.vypa.llvm.LLVMLexerAdapter;
import io.vypa.llvm.LLVMParserDefinition;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Map.Entry;

public class LLVMSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<TokenSet, TextAttributesKey[]> TOKENSET_ATTRIBUTES =
            ImmutableMap.<TokenSet, TextAttributesKey[]>builder()
                    .put(LLVMParserDefinition.BRACES, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.BRACES))
                    .put(LLVMParserDefinition.BRACKETS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.BRACKETS))
                    .put(LLVMParserDefinition.COMMA, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.COMMA))
                    .put(LLVMParserDefinition.COMMENTS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.LINE_COMMENT))
                    .put(LLVMParserDefinition.IDENTIFIERS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.IDENTIFIER))
                    .put(LLVMParserDefinition.KEYWORDS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.KEYWORD))
                    .put(LLVMParserDefinition.LABEL, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.LABEL))
                    .put(LLVMParserDefinition.LOCAL_IDENTIFIERS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.LOCAL_VARIABLE))
                    .put(LLVMParserDefinition.NUMBERS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.NUMBER))
                    .put(LLVMParserDefinition.PARENTHESES, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.PARENTHESES))
                    .put(LLVMParserDefinition.STRING_LITERALS, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.STRING))
                    .put(LLVMParserDefinition.TYPE_REFERENCE, SyntaxHighlighterBase.pack(LLVMSyntaxHighlightingAttributes.BUILTIN_TYPE_REFERENCE))
                    .build();
    private static final Map<IElementType, TextAttributesKey[]> ELEMENT_ATTRIBUTES = map(TOKENSET_ATTRIBUTES);
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static Map<IElementType, TextAttributesKey[]> map(Map<TokenSet, TextAttributesKey[]> tokenSetAttributes) {
        final Builder<IElementType, TextAttributesKey[]> builder = ImmutableMap.<IElementType, TextAttributesKey[]>builder();
        for (Entry<TokenSet, TextAttributesKey[]> entry : tokenSetAttributes.entrySet()) {
            final IElementType[] types = entry.getKey().getTypes();
            for (final IElementType elementType : types) {
                builder.put(elementType, entry.getValue());
            }
        }
        builder.put(TokenType.BAD_CHARACTER, pack(LLVMSyntaxHighlightingAttributes.BAD_CHARACTER));
        return builder.build();
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LLVMLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        final TextAttributesKey[] attributesKeys = ELEMENT_ATTRIBUTES.get(tokenType);
        if (attributesKeys == null)
            return EMPTY_KEYS;
        return attributesKeys;
    }
}