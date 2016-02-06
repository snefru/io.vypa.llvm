package io.vypa.llvm.structure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.intellij.icons.AllIcons.Nodes;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import io.vypa.llvm.LLVMFile;
import io.vypa.llvm.psi.LLVMEntity;
import io.vypa.llvm.psi.LLVMFunctionDeclaration;
import io.vypa.llvm.psi.LLVMFunctionDefinition;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;

public class CollectionBuilder extends LLVMVisitor {

    private final PsiElement root;

    private final Builder<StructureViewTreeElement> builder = ImmutableList.builder();

    public CollectionBuilder(PsiElement root) {
        this.root = root;
    }

    public void visitFunctionDeclaration(@NotNull final LLVMFunctionDeclaration declaration) {
        builder.add(new Element(declaration, declaration.getFunctionHeader().getText(), Nodes.MethodReference));
    }

    @Override
    public void visitFunctionDefinition(@NotNull final LLVMFunctionDefinition definition) {
        builder.add(new Element(definition, definition.getFunctionHeader().getText(), Nodes.Method));
    }

    @Override
    public void visitEntity(@NotNull final LLVMEntity entity) {
        Arrays.stream(entity.getChildren()).forEach(e -> e.accept(this));
    }

    @Override
    public void visitFile(final PsiFile file) {
        final LLVMFile llvmFile = (LLVMFile) file;
        Arrays.stream(llvmFile.getChildren()).forEach(e -> e.accept(this));
    }

    public Collection<StructureViewTreeElement> build() {
        root.acceptChildren(this);
        return builder.build();
    }
}
