// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMFloatLiteral;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static io.vypa.llvm.psi.LLVMTypes.*;

public class LLVMFloatLiteralImpl extends ASTWrapperPsiElement implements LLVMFloatLiteral {

  public LLVMFloatLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitFloatLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDecimalFpliteral() {
    return findChildByType(DECIMAL_FPLITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexFp128literal() {
    return findChildByType(HEX_FP128LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexFp80literal() {
    return findChildByType(HEX_FP80LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexFpliteral() {
    return findChildByType(HEX_FPLITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexHalfLiteral() {
    return findChildByType(HEX_HALF_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexPpc128literal() {
    return findChildByType(HEX_PPC128LITERAL);
  }

}
