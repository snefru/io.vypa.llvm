// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LLVMStatement extends PsiElement {

  @NotNull
  LLVMInstruction getInstruction();

  @NotNull
  List<LLVMMetadata> getMetadataList();

  @Nullable
  PsiElement getLocalIdentifier();

}
