package io.vypa.llvm.runner;


import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.DefaultProgramRunner;
import org.jetbrains.annotations.NotNull;

public class LLVMDefaultProgramRunner extends DefaultProgramRunner {

    @NotNull
    @Override
    public String getRunnerId() {
        return "LLVMCommandLineRunner";
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return DefaultRunExecutor.EXECUTOR_ID.equals(executorId) && profile instanceof LLVMApplicationConfiguration;
    }
}
