// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMAddressSpace;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.INTERGER_LITERAL;

public class LLVMAddressSpaceImpl extends ASTWrapperPsiElement implements LLVMAddressSpace {

  public LLVMAddressSpaceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitAddressSpace(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIntergerLiteral() {
    return findNotNullChildByType(INTERGER_LITERAL);
  }

}
