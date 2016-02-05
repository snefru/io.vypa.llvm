// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMStructureType;
import io.vypa.llvm.psi.LLVMType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LLVMStructureTypeImpl extends LLVMTypeImpl implements LLVMStructureType {

  public LLVMStructureTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitStructureType(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMType.class);
  }

}
