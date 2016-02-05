// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMOperandBundle;
import io.vypa.llvm.psi.LLVMTypedValue;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.STRING;

public class LLVMOperandBundleImpl extends ASTWrapperPsiElement implements LLVMOperandBundle {

  public LLVMOperandBundleImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitOperandBundle(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMTypedValue> getTypedValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMTypedValue.class);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

}
