package org.concordion.plugin.idea.lang;

import com.intellij.psi.tree.IElementType;

public class ConcordionElementType extends IElementType {

    public ConcordionElementType(String debugName) {
        super(debugName, ConcordionLanguage.INSTANCE);
    }
}
