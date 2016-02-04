package io.vypa.llvm;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.vypa.llvm.highlighting.LLVMSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class LLVMColourSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Key", LLVMSyntaxHighlighter.KEY),
            new AttributesDescriptor("Separator", LLVMSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Value", LLVMSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Bad Character", LLVMSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("Number", LLVMSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Type Reference", LLVMSyntaxHighlighter.TYPE_REFERENCE),
            new AttributesDescriptor("Type Reference", LLVMSyntaxHighlighter.TYPE_REFERENCE),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return LLVMIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new LLVMSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "define i8 @identity(i8 %x) {" +
                "  ret i8 %x" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "LLVM";
    }
}