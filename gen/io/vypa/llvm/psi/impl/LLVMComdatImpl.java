// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMComdat;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static io.vypa.llvm.psi.LLVMTypes.COMDAT_IDENTIFIER;

public class LLVMComdatImpl extends ASTWrapperPsiElement implements LLVMComdat {

  public LLVMComdatImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitComdat(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getComdatIdentifier() {
    return findChildByType(COMDAT_IDENTIFIER);
  }

}
