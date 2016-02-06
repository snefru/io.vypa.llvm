// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMFunctionBody;
import io.vypa.llvm.psi.LLVMFunctionDefinition;
import io.vypa.llvm.psi.LLVMFunctionHeader;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMFunctionDefinitionImpl extends ASTWrapperPsiElement implements LLVMFunctionDefinition {

  public LLVMFunctionDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor) visitor).visitFunctionDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMFunctionBody getFunctionBody() {
    return findNotNullChildByClass(LLVMFunctionBody.class);
  }

  @Override
  @NotNull
  public LLVMFunctionHeader getFunctionHeader() {
    return findNotNullChildByClass(LLVMFunctionHeader.class);
  }

}
