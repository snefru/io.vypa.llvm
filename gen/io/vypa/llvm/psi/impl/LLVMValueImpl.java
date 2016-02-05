// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.*;

public class LLVMValueImpl extends ASTWrapperPsiElement implements LLVMValue {

  public LLVMValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitValue(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LLVMFPPredicate getFPPredicate() {
    return findChildByClass(LLVMFPPredicate.class);
  }

  @Override
  @Nullable
  public LLVMFloatLiteral getFloatLiteral() {
    return findChildByClass(LLVMFloatLiteral.class);
  }

  @Override
  @NotNull
  public List<LLVMIndex> getIndexList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMIndex.class);
  }

  @Override
  @Nullable
  public LLVMIntPredicate getIntPredicate() {
    return findChildByClass(LLVMIntPredicate.class);
  }

  @Override
  @Nullable
  public LLVMType getType() {
    return findChildByClass(LLVMType.class);
  }

  @Override
  @NotNull
  public List<LLVMTypedValue> getTypedValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMTypedValue.class);
  }

  @Override
  @NotNull
  public List<LLVMValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMValue.class);
  }

  @Override
  @Nullable
  public PsiElement getCharArrayLiteral() {
    return findChildByType(CHAR_ARRAY_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getGlobalIdentifier() {
    return findChildByType(GLOBAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getIntergerLiteral() {
    return findChildByType(INTERGER_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getLocalIdentifier() {
    return findChildByType(LOCAL_IDENTIFIER);
  }

}
