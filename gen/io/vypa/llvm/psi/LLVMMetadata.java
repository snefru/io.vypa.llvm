// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LLVMMetadata extends PsiElement {

  @NotNull
  List<LLVMMetadata> getMetadataList();

  @Nullable
  LLVMTypedValue getTypedValue();

  @Nullable
  LLVMValue getValue();

  @Nullable
  PsiElement getMetadataIdentifier();

  @Nullable
  PsiElement getMetadataString();

}
