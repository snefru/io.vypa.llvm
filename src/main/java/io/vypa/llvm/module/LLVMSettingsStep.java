package io.vypa.llvm.module;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.SdkSettingsStep;
import com.intellij.ide.util.projectWizard.SettingsStep;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBCheckBox;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;

public class LLVMSettingsStep extends SdkSettingsStep {

    @NotNull
    @NonNls
    private static final String MODULE_SOURCE_ROOT_KEY = "java.module.default.source.root";
    @NotNull
    @NonNls
    private static final String DEFAULT_MODULE_SOURCE_ROOT_PATH = "src";

    private final ModuleBuilder myModuleBuilder;
    private JBCheckBox myCreateSourceRoot = new JBCheckBox();
    private TextFieldWithBrowseButton mySourcePath = new TextFieldWithBrowseButton();
    private JPanel myPanel = new JPanel();

    public LLVMSettingsStep(@NotNull SettingsStep settingsStep, @NotNull ModuleBuilder moduleBuilder, @NotNull Condition<SdkTypeId> sdkFilter) {
        super(settingsStep, moduleBuilder, sdkFilter);
        mySourcePath.setText(PropertiesComponent.getInstance().getValue(MODULE_SOURCE_ROOT_KEY, DEFAULT_MODULE_SOURCE_ROOT_PATH));
        myModuleBuilder = moduleBuilder;

        if (moduleBuilder instanceof LLVMModuleBuilder) {
            addSourcePath(settingsStep);
        }
    }

    private void addSourcePath(SettingsStep settingsStep) {
        Project project = settingsStep.getContext().getProject();
        FileChooserDescriptor descriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor();
        descriptor.setTitle(IdeBundle.message("prompt.select.source.directory"));
        mySourcePath.addBrowseFolderListener(new TextBrowseFolderListener(descriptor, project) {
            @NotNull
            @Override
            protected String chosenFileToResultingText(@NotNull VirtualFile chosenFile) {
                String contentEntryPath = myModuleBuilder.getContentEntryPath();
                String path = chosenFile.getPath();
                return contentEntryPath == null ? path : path.substring(StringUtil.commonPrefixLength(contentEntryPath, path));
            }
        });
        myCreateSourceRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mySourcePath.setEnabled(myCreateSourceRoot.isSelected());
            }
        });
        settingsStep.addExpertPanel(myPanel);
    }

    @Override
    public void updateDataModel() {
        super.updateDataModel();
        if (myModuleBuilder instanceof LLVMModuleBuilder) {
            if (myCreateSourceRoot.isSelected()) {
                String contentEntryPath = myModuleBuilder.getContentEntryPath();
                if (contentEntryPath != null) {
                    final String dirName = mySourcePath.getText().trim().replace(File.separatorChar, '/');
                    PropertiesComponent.getInstance().setValue(MODULE_SOURCE_ROOT_KEY, dirName);
                    String text = dirName.length() > 0 ? contentEntryPath + "/" + dirName : contentEntryPath;
                    ((LLVMModuleBuilder) myModuleBuilder).setSourcePaths(Collections.singletonList(Pair.create(text, "")));
                }
            } else {
                ((LLVMModuleBuilder) myModuleBuilder).setSourcePaths(Collections.<Pair<String, String>>emptyList());
            }
        }
    }
}
