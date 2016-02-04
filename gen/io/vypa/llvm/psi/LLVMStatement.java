// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LLVMStatement extends PsiElement {

  @NotNull
  LLVMInstruction getInstruction();

  @NotNull
  List<LLVMMetadata> getMetadataList();

  @Nullable
  PsiElement getLocalIdentifier();

}
