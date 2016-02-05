// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMBasicBlock;
import io.vypa.llvm.psi.LLVMStatement;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.LABEL_ID;

public class LLVMBasicBlockImpl extends ASTWrapperPsiElement implements LLVMBasicBlock {

  public LLVMBasicBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitBasicBlock(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getLabelId() {
    return findChildByType(LABEL_ID);
  }

}
