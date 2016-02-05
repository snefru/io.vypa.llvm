// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import io.vypa.llvm.psi.LLVMUserDefinedType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;

import static io.vypa.llvm.psi.LLVMTypes.LOCAL_IDENTIFIER;

public class LLVMUserDefinedTypeImpl extends LLVMTypeImpl implements LLVMUserDefinedType {

  public LLVMUserDefinedTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitUserDefinedType(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getLocalIdentifier() {
    return findNotNullChildByType(LOCAL_IDENTIFIER);
  }

}
