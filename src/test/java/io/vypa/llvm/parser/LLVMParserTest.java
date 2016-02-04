package io.vypa.llvm.parser;

import com.intellij.testFramework.ParsingTestCase;
import io.vypa.llvm.LLVMParserDefinition;
import org.jetbrains.annotations.NotNull;

public class LLVMParserTest extends ParsingTestCase {
    public LLVMParserTest() {
        super("parser", "ll", new LLVMParserDefinition());
    }

    @NotNull
    @Override
    protected String getTestDataPath() {
        return "src/test/resources";
    }

    @Override
    protected boolean skipSpaces() {
        return true;
    }

    protected void doTest(boolean checkErrors) {
        super.doTest(true);
        if (checkErrors) {
            assertFalse(
                    "PsiFile contains error elements",
                    toParseTreeText(myFile, skipSpaces(), includeRanges()).contains("PsiErrorElement")
            );
        }
    }

    public void testEntity() {
        doTest(true);
    }

}
