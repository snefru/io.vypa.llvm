// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LLVMEntity extends PsiElement {

  @Nullable
  LLVMAddressSpace getAddressSpace();

  @Nullable
  LLVMAlignment getAlignment();

  @Nullable
  LLVMComdat getComdat();

  @Nullable
  LLVMDllStorageClass getDllStorageClass();

  @NotNull
  List<LLVMFunctionAttribute> getFunctionAttributeList();

  @Nullable
  LLVMFunctionDeclaration getFunctionDeclaration();

  @Nullable
  LLVMFunctionDefinition getFunctionDefinition();

  @Nullable
  LLVMLinkage getLinkage();

  @Nullable
  LLVMMetadata getMetadata();

  @Nullable
  LLVMScope getScope();

  @Nullable
  LLVMSection getSection();

  @Nullable
  LLVMSelectionKind getSelectionKind();

  @Nullable
  LLVMThreadLocalStorage getThreadLocalStorage();

  @Nullable
  LLVMType getType();

  @Nullable
  LLVMTypedValue getTypedValue();

  @Nullable
  LLVMValue getValue();

  @Nullable
  LLVMVisibility getVisibility();

  @Nullable
  PsiElement getAttGroupId();

  @Nullable
  PsiElement getComdatIdentifier();

  @Nullable
  PsiElement getGlobalIdentifier();

  @Nullable
  PsiElement getLocalIdentifier();

  @Nullable
  PsiElement getMetadataIdentifier();

  @Nullable
  PsiElement getString();

}
