package io.vypa.llvm.structure;

import com.intellij.icons.AllIcons.Nodes;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

public class LLVMStructure extends StructureViewModelBase {

    public LLVMStructure(final PsiFile psiFile, final Editor editor) {
        super(psiFile, editor, new Element(psiFile, psiFile.getName(), Nodes.Package));
    }
}
