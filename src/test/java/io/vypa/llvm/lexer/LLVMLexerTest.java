package io.vypa.llvm.lexer;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.testFramework.LexerTestCase;
import io.vypa.llvm.LLVMLexerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class LLVMLexerTest extends LexerTestCase {
    private static final String PATH = "src/test/resources/lexer";

    public void testKeywords() {
        doTest();
    }

    private void doTest() {
        try {
            String text = FileUtil.loadFile(new File("./" + PATH + "/" + getTestName(true) + ".ll"));
            String actual = printTokens(StringUtil.convertLineSeparators(text.trim()), 0);
            assertSameLinesWithFile(new File(PATH + "/" + getTestName(true) + ".txt").getAbsolutePath(), actual);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    protected Lexer createLexer() {
        return new LLVMLexerAdapter();
    }

    @NotNull
    @Override
    protected String getDirPath() {
        return "../" + PATH;
    }
}
