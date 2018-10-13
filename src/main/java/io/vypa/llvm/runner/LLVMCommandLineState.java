package io.vypa.llvm.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.filters.TextConsoleBuilder;
import com.intellij.execution.filters.TextConsoleBuilderImpl;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ProjectRootManager;
import org.jetbrains.annotations.NotNull;

public class LLVMCommandLineState extends CommandLineState {
    private static final Logger LOGGER = Logger.getInstance("io.vypa.llvm.LLVMParser");

    private final
    @NotNull
    String myFilePath;
    private final
    @NotNull
    String myVmOptions;
    private final
    @NotNull
    String myArguments;

    public LLVMCommandLineState(final @NotNull ExecutionEnvironment env,
                                final @NotNull String filePath,
                                final @NotNull String vmOptions,
                                final @NotNull String arguments) {
        super(env);
        myFilePath = filePath;
        myVmOptions = vmOptions;
        myArguments = arguments;
//        todo review
        final TextConsoleBuilder builder = getConsoleBuilder();
        if (builder instanceof TextConsoleBuilderImpl) {
            ((TextConsoleBuilderImpl) builder).setUsePredefinedMessageFilter(false);
        }
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = new GeneralCommandLine();
        final Sdk sdk = ProjectRootManager.getInstance(getEnvironment().getProject()).getProjectSdk();
        commandLine.setExePath(sdk.getHomePath() + "/bin/lli");
        commandLine.addParameter(myFilePath);
        final OSProcessHandler processHandler = new OSProcessHandler(commandLine.createProcess(), commandLine.getCommandLineString());
        ProcessTerminatedListener.attach(processHandler, getEnvironment().getProject());
        return processHandler;
    }
}
