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

public class LLVMFunctionHeaderImpl extends ASTWrapperPsiElement implements LLVMFunctionHeader {

  public LLVMFunctionHeaderImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LLVMVisitor visitor) {
    visitor.visitFunctionHeader(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) accept((LLVMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LLVMAlignment getAlignment() {
    return findChildByClass(LLVMAlignment.class);
  }

  @Override
  @Nullable
  public LLVMCallingConvention getCallingConvention() {
    return findChildByClass(LLVMCallingConvention.class);
  }

  @Override
  @Nullable
  public LLVMComdat getComdat() {
    return findChildByClass(LLVMComdat.class);
  }

  @Override
  @Nullable
  public LLVMDllStorageClass getDllStorageClass() {
    return findChildByClass(LLVMDllStorageClass.class);
  }

  @Override
  @NotNull
  public List<LLVMFunctionAttribute> getFunctionAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMFunctionAttribute.class);
  }

  @Override
  @Nullable
  public LLVMLinkage getLinkage() {
    return findChildByClass(LLVMLinkage.class);
  }

  @Override
  @Nullable
  public LLVMParameterList getParameterList() {
    return findChildByClass(LLVMParameterList.class);
  }

  @Override
  @NotNull
  public List<LLVMReturnAttribute> getReturnAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMReturnAttribute.class);
  }

  @Override
  @Nullable
  public LLVMSection getSection() {
    return findChildByClass(LLVMSection.class);
  }

  @Override
  @NotNull
  public LLVMType getType() {
    return findNotNullChildByClass(LLVMType.class);
  }

  @Override
  @NotNull
  public List<LLVMTypedValue> getTypedValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMTypedValue.class);
  }

  @Override
  @Nullable
  public LLVMVisibility getVisibility() {
    return findChildByClass(LLVMVisibility.class);
  }

  @Override
  @NotNull
  public PsiElement getGlobalIdentifier() {
    return findNotNullChildByType(GLOBAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
