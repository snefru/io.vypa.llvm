// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMAlignment;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.INTERGER_LITERAL;

public class LLVMAlignmentImpl extends ASTWrapperPsiElement implements LLVMAlignment {

  public LLVMAlignmentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitAlignment(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIntergerLiteral() {
    return findNotNullChildByType(INTERGER_LITERAL);
  }

}
