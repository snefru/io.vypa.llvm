package io.vypa.llvm.runner;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.ui.RawCommandLineEditor;
import io.vypa.llvm.LLVMBundle;
import io.vypa.llvm.LLVMFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LLVMApplicationConfigurable extends SettingsEditor<LLVMApplicationConfiguration> {
    private JPanel myMainPanel;
    private TextFieldWithBrowseButton myFileField;
    private RawCommandLineEditor myVMOptions;
    private RawCommandLineEditor myArguments;

    public LLVMApplicationConfigurable(final Project project) {
        myFileField.getButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreeFileChooser fileChooser = TreeFileChooserFactory.getInstance(project).createFileChooser(
                        LLVMBundle.message("choose.LLVM.main.file"),
                        null,
                        LLVMFileType.INSTANCE,
                        new TreeFileChooser.PsiFileFilter() {
                            public boolean accept(PsiFile file) {
                                return true;
                            }
                        }
                );

                fileChooser.showDialog();
                final PsiFile selectedFile = fileChooser.getSelectedFile();
                final VirtualFile virtualFile = selectedFile == null ? null : selectedFile.getVirtualFile();
                if (virtualFile != null) {
                    final String path = FileUtil.toSystemDependentName(virtualFile.getPath());
                    myFileField.setText(path);
                }
            }
        });
    }

    @Override
    protected void resetEditorFrom(LLVMApplicationConfiguration configuration) {
        myFileField.setText(FileUtil.toSystemDependentName(StringUtil.notNullize(configuration.getFilePath())));
        myArguments.setText(StringUtil.notNullize(configuration.getArguments()));
        myVMOptions.setText(StringUtil.notNullize(configuration.getVMOptions()));
    }

    @Override
    protected void applyEditorTo(LLVMApplicationConfiguration configuration) throws ConfigurationException {
        configuration.setFilePath(StringUtil.nullize(FileUtil.toSystemIndependentName(myFileField.getText()), true));
        configuration.setArguments(StringUtil.nullize(myArguments.getText(), true));
        configuration.setVMOptions(StringUtil.nullize(myVMOptions.getText(), true));
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return myMainPanel;
    }
}
