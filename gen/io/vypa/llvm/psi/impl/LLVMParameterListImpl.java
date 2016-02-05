// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMParameter;
import io.vypa.llvm.psi.LLVMParameterList;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LLVMParameterListImpl extends ASTWrapperPsiElement implements LLVMParameterList {

  public LLVMParameterListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitParameterList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMParameter> getParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMParameter.class);
  }

}
