// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMFastMathsFlag;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMFastMathsFlagImpl extends ASTWrapperPsiElement implements LLVMFastMathsFlag {

  public LLVMFastMathsFlagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitFastMathsFlag(this);
    else super.accept(visitor);
  }

}
