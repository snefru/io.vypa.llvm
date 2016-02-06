package io.vypa.llvm.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;

public class Element extends PsiTreeElementBase<PsiElement> {

    private final String presentableText;
    private final Icon icon;

    protected Element(final PsiElement element, final String presentableText, Icon icon) {
        super(element);
        this.presentableText = presentableText;
        this.icon = icon;
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        return new CollectionBuilder(getElement()).build();

    }

    @Nullable
    @Override
    public String getPresentableText() {
        return presentableText;
    }

    @Override
    public Icon getIcon(final boolean open) {
        return icon;
    }
}
