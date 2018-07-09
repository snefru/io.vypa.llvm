// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LLVMFunctionHeader extends PsiElement {

  @Nullable
  LLVMAlignment getAlignment();

  @Nullable
  LLVMCallingConvention getCallingConvention();

  @Nullable
  LLVMComdat getComdat();

  @Nullable
  LLVMDllStorageClass getDllStorageClass();

  @NotNull
  List<LLVMFunctionAttribute> getFunctionAttributeList();

  @Nullable
  LLVMLinkage getLinkage();

  @Nullable
  LLVMParameterList getParameterList();

  @NotNull
  List<LLVMReturnAttribute> getReturnAttributeList();

  @Nullable
  LLVMSection getSection();

  @NotNull
  LLVMType getType();

  @NotNull
  List<LLVMTypedValue> getTypedValueList();

  @Nullable
  LLVMVisibility getVisibility();

  @NotNull
  PsiElement getGlobalIdentifier();

  @Nullable
  PsiElement getString();

}
