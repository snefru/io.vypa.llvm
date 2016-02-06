/*
 * Copyright 2013-2015 Sergey Ignatov, Alexander Zolotov, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vypa.llvm.action;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import io.vypa.llvm.LLVMFile;
import io.vypa.llvm.LLVMIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LLVMCreateModuleAction extends CreateFileFromTemplateAction implements DumbAware {
    public static final String MODULE_TEMPLATE = "LLVM Module";

    private static final String NEW_LLVM_MODULE = "New LLVM Module";
    private static final String DEFAULT_LLVM_TEMPLATE_PROPERTY = "DefaultLLVMTemplateProperty";

    public LLVMCreateModuleAction() {
        super(NEW_LLVM_MODULE, "", LLVMIcons.LLVM16);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, @NotNull CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle(NEW_LLVM_MODULE)
                .addKind("Empty Module", LLVMIcons.LLVM16, MODULE_TEMPLATE);
    }

    @Nullable
    @Override
    protected String getDefaultTemplateProperty() {
        return DEFAULT_LLVM_TEMPLATE_PROPERTY;
    }

    @NotNull
    @Override
    protected String getActionName(PsiDirectory directory, String newName, String templateName) {
        return NEW_LLVM_MODULE;
    }


    @Override
    protected void postProcess(PsiFile createdElement, String templateName, Map<String, String> customProperties) {
        if (createdElement instanceof LLVMFile) {
            Project project = createdElement.getProject();
            Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
            if (editor == null) {
                return;
            }
            VirtualFile virtualFile = createdElement.getContainingFile().getVirtualFile();
            if (virtualFile == null) {
                return;
            }
        }
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof LLVMCreateModuleAction;
    }
}