package io.vypa.llvm.runner;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import io.vypa.llvm.LLVMBundle;
import io.vypa.llvm.LLVMFileType;
import io.vypa.llvm.LLVMIcons;
import org.jetbrains.annotations.NotNull;

public class LLVMApplicationConfigurationType extends ConfigurationTypeBase {
    public LLVMApplicationConfigurationType() {
        super("LLVMCommandLineRunConfigurationType",
                LLVMBundle.message("runner.command.line.configuration.name"),
                LLVMBundle.message("runner.command.line.configuration.name"),
                LLVMIcons.LLVM16);
        addFactory(new ConfigurationFactory(this) {
            @Override
            public RunConfiguration createTemplateConfiguration(Project project) {
                return new LLVMApplicationConfiguration("llvm", project, LLVMApplicationConfigurationType.this);
            }

            @Override
            public boolean isApplicable(@NotNull Project project) {
                return FileTypeIndex.containsFileOfType(LLVMFileType.INSTANCE, GlobalSearchScope.projectScope(project));
            }
        });
    }

    public static LLVMApplicationConfigurationType getInstance() {
        return Extensions.findExtension(CONFIGURATION_TYPE_EP, LLVMApplicationConfigurationType.class);
    }
}
