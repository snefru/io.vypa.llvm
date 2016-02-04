// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
