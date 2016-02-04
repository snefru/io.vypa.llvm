package io.vypa.llvm;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LLVMFile extends PsiFileBase {
    public LLVMFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LLVMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return LLVMFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "LLVM File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}