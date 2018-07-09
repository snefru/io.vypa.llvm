// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
