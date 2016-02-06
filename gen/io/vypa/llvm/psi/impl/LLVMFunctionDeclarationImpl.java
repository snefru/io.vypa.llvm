// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMFunctionDeclaration;
import io.vypa.llvm.psi.LLVMFunctionHeader;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMFunctionDeclarationImpl extends ASTWrapperPsiElement implements LLVMFunctionDeclaration {

  public LLVMFunctionDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor) visitor).visitFunctionDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMFunctionHeader getFunctionHeader() {
    return findNotNullChildByClass(LLVMFunctionHeader.class);
  }

}
