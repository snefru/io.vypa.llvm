package io.vypa.llvm.module;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.SettingsStep;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.util.Condition;
import io.vypa.llvm.LLVMBundle;
import io.vypa.llvm.LLVMIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LLVMModuleType extends ModuleType<LLVMModuleBuilder> {
    @NonNls
    public static final String LLVM_MODULE = "LLVM_MODULE";

    public LLVMModuleType() {
        super(LLVM_MODULE);
    }

    public static ModuleType getInstance() {
        return ModuleTypeManager.getInstance().findByID(LLVM_MODULE);
    }

    @NotNull
    public String getName() {
        return LLVMBundle.message("module.type.name");
    }

    @NotNull
    public String getDescription() {
        return LLVMBundle.message("module.type.description");
    }

    public Icon getBigIcon() {
        return LLVMIcons.LLVM24;
    }

    public Icon getNodeIcon(final boolean isOpened) {
        return LLVMIcons.LLVM24;
    }

    @NotNull
    public LLVMModuleBuilder createModuleBuilder() {
        return new LLVMModuleBuilder();
    }

    @Nullable
    public ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep, @NotNull final ModuleBuilder moduleBuilder) {
        final Condition<SdkTypeId> condition = new Condition<SdkTypeId>() {
            @Override
            public boolean value(SdkTypeId sdkType) {
                return moduleBuilder.isSuitableSdkType(sdkType);
            }
        };
        return new LLVMSettingsStep(settingsStep, moduleBuilder, condition);
    }

}

