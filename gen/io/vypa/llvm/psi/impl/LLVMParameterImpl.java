// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import io.vypa.llvm.psi.LLVMParameter;
import io.vypa.llvm.psi.LLVMParameterAttribute;
import io.vypa.llvm.psi.LLVMType;
import io.vypa.llvm.psi.LLVMVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static io.vypa.llvm.psi.LLVMTypes.LOCAL_IDENTIFIER;

public class LLVMParameterImpl extends ASTWrapperPsiElement implements LLVMParameter {

  public LLVMParameterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitParameter(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LLVMParameterAttribute> getParameterAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMParameterAttribute.class);
  }

  @Override
  @Nullable
  public LLVMType getType() {
    return findChildByClass(LLVMType.class);
  }

  @Override
  @Nullable
  public PsiElement getLocalIdentifier() {
    return findChildByType(LOCAL_IDENTIFIER);
  }

}
