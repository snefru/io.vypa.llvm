// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LLVMArgument extends PsiElement {

  @NotNull
  List<LLVMParameterAttribute> getParameterAttributeList();

  @NotNull
  LLVMType getType();

  @Nullable
  LLVMValue getValue();

  @Nullable
  PsiElement getMetadataIdentifier();

}
