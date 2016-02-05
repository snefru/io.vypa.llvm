package io.vypa.llvm.runner;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import io.vypa.llvm.LLVMFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class LLVMRunConfigurationProducer extends RunConfigurationProducer<LLVMApplicationConfiguration> {
    public LLVMRunConfigurationProducer() {
        super(LLVMApplicationConfigurationType.getInstance());
    }

    @Nullable
    public static VirtualFile findRunnableJuliaFile(final @NotNull ConfigurationContext context) {
        final PsiElement psiLocation = context.getPsiLocation();
        final PsiFile psiFile = psiLocation == null ? null : psiLocation.getContainingFile();
        final VirtualFile virtualFile = psiFile != null ? psiFile.getOriginalFile().getVirtualFile() : null;
//        todo review
        if (!(psiFile instanceof LLVMFile))
            return null;
        if (!ProjectRootManager.getInstance(context.getProject()).getFileIndex().isInContent(virtualFile))
            return null;
        return virtualFile;
    }

    @Override
    protected boolean setupConfigurationFromContext(final @NotNull LLVMApplicationConfiguration configuration,
                                                    final @NotNull ConfigurationContext context,
                                                    final @NotNull Ref<PsiElement> sourceElement) {
        final VirtualFile juliaFile = findRunnableJuliaFile(context);
        if (juliaFile == null)
            return false;
        configuration.setFilePath(juliaFile.getPath());
        configuration.setName(configuration.suggestedName());
        return true;
    }

    @Override
    public boolean isConfigurationFromContext(final @NotNull LLVMApplicationConfiguration configuration,
                                              final @NotNull ConfigurationContext context) {
        final VirtualFile JuliaFile = findRunnableJuliaFile(context);
        return JuliaFile != null && JuliaFile.getPath().equals(configuration.getFilePath());
    }
}