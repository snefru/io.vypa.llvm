// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMType;
import io.vypa.llvm.psi.LLVMTypedValue;
import io.vypa.llvm.psi.LLVMValue;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMTypedValueImpl extends ASTWrapperPsiElement implements LLVMTypedValue {

  public LLVMTypedValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitTypedValue(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMType getType() {
    return findNotNullChildByClass(LLVMType.class);
  }

  @Override
  @NotNull
  public LLVMValue getValue() {
    return findNotNullChildByClass(LLVMValue.class);
  }

}
