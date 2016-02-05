// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LLVMValue extends PsiElement {

  @Nullable
  LLVMFPPredicate getFPPredicate();

  @Nullable
  LLVMFloatLiteral getFloatLiteral();

  @NotNull
  List<LLVMIndex> getIndexList();

  @Nullable
  LLVMIntPredicate getIntPredicate();

  @Nullable
  LLVMType getType();

  @NotNull
  List<LLVMTypedValue> getTypedValueList();

  @NotNull
  List<LLVMValue> getValueList();

  @Nullable
  PsiElement getCharArrayLiteral();

  @Nullable
  PsiElement getGlobalIdentifier();

  @Nullable
  PsiElement getIntergerLiteral();

  @Nullable
  PsiElement getLocalIdentifier();

}
