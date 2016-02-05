// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMMetadata;
import io.vypa.llvm.psi.LLVMTypedValue;
import io.vypa.llvm.psi.LLVMValue;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.METADATA_IDENTIFIER;
import static io.vypa.llvm.psi.LLVMTypes.METADATA_STRING;

public class LLVMMetadataImpl extends ASTWrapperPsiElement implements LLVMMetadata {

  public LLVMMetadataImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitMetadata(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMMetadata> getMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMMetadata.class);
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
  public PsiElement getMetadataIdentifier() {
    return findChildByType(METADATA_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getMetadataString() {
    return findChildByType(METADATA_STRING);
  }

}
