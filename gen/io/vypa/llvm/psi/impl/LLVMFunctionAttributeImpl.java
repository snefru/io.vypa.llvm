// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMFunctionAttribute;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.ATT_GROUP_ID;
import static io.vypa.llvm.psi.LLVMTypes.INTERGER_LITERAL;

public class LLVMFunctionAttributeImpl extends ASTWrapperPsiElement implements LLVMFunctionAttribute {

  public LLVMFunctionAttributeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitFunctionAttribute(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMFunctionAttribute> getFunctionAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMFunctionAttribute.class);
  }

  @Override
  @Nullable
  public PsiElement getAttGroupId() {
    return findChildByType(ATT_GROUP_ID);
  }

  @Override
  @Nullable
  public PsiElement getIntergerLiteral() {
    return findChildByType(INTERGER_LITERAL);
  }

}
