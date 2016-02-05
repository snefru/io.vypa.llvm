// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMPointerType;
import io.vypa.llvm.psi.LLVMType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

public class LLVMPointerTypeImpl extends LLVMTypeImpl implements LLVMPointerType {

  public LLVMPointerTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitPointerType(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMType getType() {
    return findNotNullChildByClass(LLVMType.class);
  }

}
