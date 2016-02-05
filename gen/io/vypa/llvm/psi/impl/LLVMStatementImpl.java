// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMInstruction;
import io.vypa.llvm.psi.LLVMMetadata;
import io.vypa.llvm.psi.LLVMStatement;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.LOCAL_IDENTIFIER;

public class LLVMStatementImpl extends ASTWrapperPsiElement implements LLVMStatement {

  public LLVMStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LLVMInstruction getInstruction() {
    return findNotNullChildByClass(LLVMInstruction.class);
  }

  @Override
  @NotNull
  public List<LLVMMetadata> getMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMMetadata.class);
  }

  @Override
  @Nullable
  public PsiElement getLocalIdentifier() {
    return findChildByType(LOCAL_IDENTIFIER);
  }

}
