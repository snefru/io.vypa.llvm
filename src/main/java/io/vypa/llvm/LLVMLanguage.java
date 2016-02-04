package io.vypa.llvm;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LLVMLanguage extends Language {
    public static final Language INSTANCE = new LLVMLanguage();

    private LLVMLanguage() {
        super("llvm");
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return LLVM.LLVM_DISPLAY_NAME;
    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType() {
        return LLVMFileType.INSTANCE;
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
