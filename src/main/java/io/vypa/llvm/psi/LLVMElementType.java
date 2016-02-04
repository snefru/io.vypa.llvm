package io.vypa.llvm.psi;

import com.intellij.psi.tree.IElementType;
import io.vypa.llvm.LLVMLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LLVMElementType extends IElementType {
    public LLVMElementType(@NotNull @NonNls String debugName) {
        super(debugName, LLVMLanguage.INSTANCE);
    }
}