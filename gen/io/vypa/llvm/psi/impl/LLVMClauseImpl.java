// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMClause;
import io.vypa.llvm.psi.LLVMTypedValue;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMClauseImpl extends ASTWrapperPsiElement implements LLVMClause {

  public LLVMClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitClause(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMTypedValue getTypedValue() {
    return findNotNullChildByClass(LLVMTypedValue.class);
  }

}
