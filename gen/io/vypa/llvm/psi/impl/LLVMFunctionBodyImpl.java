// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.vypa.llvm.psi.LLVMTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.vypa.llvm.psi.*;

public class LLVMFunctionBodyImpl extends ASTWrapperPsiElement implements LLVMFunctionBody {

  public LLVMFunctionBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LLVMVisitor visitor) {
    visitor.visitFunctionBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) accept((LLVMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMBasicBlock> getBasicBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMBasicBlock.class);
  }

}
