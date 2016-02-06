package io.vypa.llvm.sdk;

import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import io.vypa.llvm.LLVMBundle;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class LLVMOsxSdkType extends SdkType {
    public static final String ROOT_DIR = "/usr/local";
    private static final String DEAULT_NAME = "LLVMOSXSdk";
    private static final LLVMOsxSdkType INSTANCE = new LLVMOsxSdkType();
    private static final Predicate<String> IS_VERSION = Pattern.compile("[0-9]\\.[0-9]\\.[0-9].*").asPredicate();


    public LLVMOsxSdkType() {
        this(DEAULT_NAME);
    }

    public LLVMOsxSdkType(String name) {
        super(name);
    }

    static LLVMOsxSdkType getInstance() {
        return INSTANCE;
    }

    @Nullable
    private static VirtualFile root(File file, final String relativePath) {
        file = new File(file.getAbsolutePath() + File.separator + relativePath.replace('/', File.separatorChar));
        if (!file.exists() || !file.isDirectory()) return null;
        final String path = file.getAbsolutePath().replace(File.separatorChar, '/');
        return LocalFileSystem.getInstance().findFileByPath(path);
    }

    @Nullable
    @Override
    public String suggestHomePath() {
        final File[] applications = new File(ROOT_DIR).listFiles();
        for (File application : applications) {
            if (application.getName().toLowerCase().contains("llvm"))
                return application.getAbsolutePath();
        }
        return ROOT_DIR;
    }

    @Override
    public boolean isValidSdkHome(String path) {
        return path.toLowerCase().contains("llvm");

    }

    @Override
    public String suggestSdkName(String currentSdkName, String sdkHome) {
        return LLVMBundle.message("sdk.name");

    }

    @Nullable
    @Override
    public AdditionalDataConfigurable createAdditionalDataConfigurable(SdkModel sdkModel, SdkModificator sdkModificator) {
        return null;
    }

    @Override
    public String getPresentableName() {
        return LLVMBundle.message("sdk.name");
    }

    @Override
    public void saveAdditionalData(SdkAdditionalData additionalData, Element additional) {

    }

    @Nullable
    @Override
    public String getVersionString(String sdkhome) {
        return Arrays.stream(sdkhome.split("/")).filter(IS_VERSION).findFirst().orElse("undefined");
    }

}

