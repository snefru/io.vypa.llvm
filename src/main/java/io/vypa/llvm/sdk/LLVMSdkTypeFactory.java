package io.vypa.llvm.sdk;

import com.intellij.openapi.projectRoots.SdkType;
import com.intellij.openapi.util.SystemInfo;

public class LLVMSdkTypeFactory {

    static SdkType create() {
        if (SystemInfo.isMac) {
            return LLVMOSXSdkType.getInstance();
        }
        throw new UnsupportedOperationException("unsupported platform");
    }
}
