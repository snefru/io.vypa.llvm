package io.vypa.llvm;

import com.intellij.lexer.FlexAdapter;
import io.vypa.llvm.lexer._LLVMLexer;

public class LLVMLexerAdapter extends FlexAdapter {
    public LLVMLexerAdapter() {
        super(new _LLVMLexer(null));
    }
}
