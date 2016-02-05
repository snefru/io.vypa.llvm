// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMParameterAttribute;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static io.vypa.llvm.psi.LLVMTypes.INTERGER_LITERAL;
import static io.vypa.llvm.psi.LLVMTypes.STRING;

public class LLVMParameterAttributeImpl extends ASTWrapperPsiElement implements LLVMParameterAttribute {

  public LLVMParameterAttributeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitParameterAttribute(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getIntergerLiteral() {
    return findChildByType(INTERGER_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
