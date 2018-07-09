package io.vypa.llvm.sdk;

import com.intellij.openapi.projectRoots.*;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class LLVMSdkType extends SdkType {

    private static final String NAME = "DefaultLLVMSdkType";
    private final SdkType myDelegate;
    private Sdk mySdk;


    public LLVMSdkType() {
        super(NAME);
        this.myDelegate = LLVMSdkTypeFactory.create();
    }


    @Nullable
    @Override
    public String suggestHomePath() {
        return myDelegate.suggestHomePath();
    }

    @Override
    public boolean isValidSdkHome(final String path) {
        return myDelegate.isValidSdkHome(path);
    }

    @Override
    public String suggestSdkName(String currentSdkName, String sdkHome) {
        return myDelegate.suggestSdkName(currentSdkName, sdkHome);
    }

    @Nullable
    @Override
    public String getVersionString(String sdkHome) {
        return myDelegate.getVersionString(sdkHome);
    }

    @Nullable
    @Override
    public AdditionalDataConfigurable createAdditionalDataConfigurable(SdkModel sdkModel, SdkModificator sdkModificator) {
        return null;
    }

    @Override
    public String getPresentableName() {
        return myDelegate.getPresentableName();
    }

    @Override
    public void saveAdditionalData(@NotNull SdkAdditionalData additionalData, @NotNull Element additional) {
        myDelegate.saveAdditionalData(additionalData, additional);

    }

    @Override
    public void setupSdkPaths(@NotNull Sdk sdk) {
        myDelegate.setupSdkPaths(sdk);
        this.mySdk = sdk;
    }

    public Sdk getSdk() {
        return mySdk;
    }
}
