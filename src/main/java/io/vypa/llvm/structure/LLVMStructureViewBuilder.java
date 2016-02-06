package io.vypa.llvm.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LLVMStructureViewBuilder extends TreeBasedStructureViewBuilder {
    private final PsiFile psiFile;

    public LLVMStructureViewBuilder(final PsiFile psiFile) {
        this.psiFile = psiFile;
    }

    @NotNull
    @Override
    public StructureViewModel createStructureViewModel(@Nullable final Editor editor) {
        return new LLVMStructure(psiFile, editor);
    }

}
