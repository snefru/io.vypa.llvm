// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMPrimitiveType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.TYPE_LITERAL;

public class LLVMPrimitiveTypeImpl extends LLVMTypeImpl implements LLVMPrimitiveType {

  public LLVMPrimitiveTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitPrimitiveType(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getTypeLiteral() {
    return findNotNullChildByType(TYPE_LITERAL);
  }

}
