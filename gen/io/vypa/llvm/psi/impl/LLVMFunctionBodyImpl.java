// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMBasicBlock;
import io.vypa.llvm.psi.LLVMFunctionBody;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LLVMFunctionBodyImpl extends ASTWrapperPsiElement implements LLVMFunctionBody {

  public LLVMFunctionBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitFunctionBody(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMBasicBlock> getBasicBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMBasicBlock.class);
  }

}
