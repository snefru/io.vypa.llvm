package io.vypa.llvm.editor;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import io.vypa.llvm.psi.LLVMTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LLVMBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(LLVMTypes.LEFT_BRACE, LLVMTypes.RIGHT_BRACE, true),
            new BracePair(LLVMTypes.LEFT_BRACKET, LLVMTypes.RIGHT_BRACKET, false),
            new BracePair(LLVMTypes.LEFT_PARENTHESIS, LLVMTypes.RIGHT_PARENTHESIS, false),
    };

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType type) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
