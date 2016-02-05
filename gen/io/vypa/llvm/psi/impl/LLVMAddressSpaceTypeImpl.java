// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMAddressSpaceType;
import io.vypa.llvm.psi.LLVMType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.INTERGER_LITERAL;

public class LLVMAddressSpaceTypeImpl extends LLVMTypeImpl implements LLVMAddressSpaceType {

  public LLVMAddressSpaceTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitAddressSpaceType(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMType getType() {
    return findNotNullChildByClass(LLVMType.class);
  }

  @Override
  @NotNull
  public PsiElement getIntergerLiteral() {
    return findNotNullChildByType(INTERGER_LITERAL);
  }

}
