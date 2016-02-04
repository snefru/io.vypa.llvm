package io.vypa.llvm;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LLVMFileType extends LanguageFileType {
    public static final LLVMFileType INSTANCE = new LLVMFileType();

    private LLVMFileType() {
        super(LLVMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "LLVM file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "LLVM language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ll";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return LLVMIcons.FILE;
    }


}