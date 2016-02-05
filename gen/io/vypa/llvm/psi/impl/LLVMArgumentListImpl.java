// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMArgument;
import io.vypa.llvm.psi.LLVMArgumentList;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LLVMArgumentListImpl extends ASTWrapperPsiElement implements LLVMArgumentList {

  public LLVMArgumentListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitArgumentList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMArgument> getArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMArgument.class);
  }

}
