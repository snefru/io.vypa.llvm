// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
