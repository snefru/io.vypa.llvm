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

public class LLVMInstructionImpl extends ASTWrapperPsiElement implements LLVMInstruction {

  public LLVMInstructionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) ((LLVMVisitor)visitor).visitInstruction(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LLVMArgumentList getArgumentList() {
    return findChildByClass(LLVMArgumentList.class);
  }

  @Override
  @Nullable
  public LLVMAtomicOrdering getAtomicOrdering() {
    return findChildByClass(LLVMAtomicOrdering.class);
  }

  @Override
  @Nullable
  public LLVMCallingConvention getCallingConvention() {
    return findChildByClass(LLVMCallingConvention.class);
  }

  @Override
  @NotNull
  public List<LLVMClause> getClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMClause.class);
  }

  @Override
  @Nullable
  public LLVMFPPredicate getFPPredicate() {
    return findChildByClass(LLVMFPPredicate.class);
  }

  @Override
  @NotNull
  public List<LLVMFastMathsFlag> getFastMathsFlagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMFastMathsFlag.class);
  }

  @Override
  @NotNull
  public List<LLVMFunctionAttribute> getFunctionAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMFunctionAttribute.class);
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
  @NotNull
  public List<LLVMOperandBundle> getOperandBundleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMOperandBundle.class);
  }

  @Override
  @Nullable
  public LLVMOperation getOperation() {
    return findChildByClass(LLVMOperation.class);
  }

  @Override
  @NotNull
  public List<LLVMReturnAttribute> getReturnAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LLVMReturnAttribute.class);
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
  public PsiElement getGlobalIdentifier() {
    return findChildByType(GLOBAL_IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getIntergerLiteral() {
    return findChildByType(INTERGER_LITERAL);
  }

}
