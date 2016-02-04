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

public class LLVMEntityImpl extends ASTWrapperPsiElement implements LLVMEntity {

  public LLVMEntityImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitEntity(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LLVMAddressSpace getAddressSpace() {
    return findChildByClass(LLVMAddressSpace.class);
  }

  @Override
  @Nullable
  public LLVMAlignment getAlignment() {
    return findChildByClass(LLVMAlignment.class);
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
  public LLVMFunctionBody getFunctionBody() {
    return findChildByClass(LLVMFunctionBody.class);
  }

  @Override
  @Nullable
  public LLVMFunctionHeader getFunctionHeader() {
    return findChildByClass(LLVMFunctionHeader.class);
  }

  @Override
  @Nullable
  public LLVMLinkage getLinkage() {
    return findChildByClass(LLVMLinkage.class);
  }

  @Override
  @Nullable
  public LLVMMetadata getMetadata() {
    return findChildByClass(LLVMMetadata.class);
  }

  @Override
  @Nullable
  public LLVMScope getScope() {
    return findChildByClass(LLVMScope.class);
  }

  @Override
  @Nullable
  public LLVMSection getSection() {
    return findChildByClass(LLVMSection.class);
  }

  @Override
  @Nullable
  public LLVMSelectionKind getSelectionKind() {
    return findChildByClass(LLVMSelectionKind.class);
  }

  @Override
  @Nullable
  public LLVMThreadLocalStorage getThreadLocalStorage() {
    return findChildByClass(LLVMThreadLocalStorage.class);
  }

  @Override
  @Nullable
  public LLVMType getType() {
    return findChildByClass(LLVMType.class);
  }

  @Override
  @Nullable
  public LLVMTypedValue getTypedValue() {
    return findChildByClass(LLVMTypedValue.class);
  }

  @Override
  @Nullable
  public LLVMValue getValue() {
    return findChildByClass(LLVMValue.class);
  }

  @Override
  @Nullable
  public LLVMVisibility getVisibility() {
    return findChildByClass(LLVMVisibility.class);
  }

  @Override
  @Nullable
  public PsiElement getAttGroupId() {
    return findChildByType(ATT_GROUP_ID);
  }

  @Override
  @Nullable
  public PsiElement getComdatIdentifier() {
    return findChildByType(COMDAT_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getGlobalIdentifier() {
    return findChildByType(GLOBAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getLocalIdentifier() {
    return findChildByType(LOCAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getMetadataIdentifier() {
    return findChildByType(METADATA_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
