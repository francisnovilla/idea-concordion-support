package org.concordion.plugin.idea.inspection;

import org.concordion.plugin.idea.patterns.ConcordionElementPattern;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import static org.concordion.plugin.idea.patterns.ConcordionElementPattern.*;
import static org.concordion.plugin.idea.patterns.ConcordionPatterns.*;

public class TestFixtureIsNotAnnotatedWithConcordionRunner extends LocalInspectionTool {

    private static final ConcordionElementPattern.Capture<PsiIdentifier> MISCONFIGURED_TEST_FIXTURE =
            concordionElement(PsiIdentifier.class)
                    .withParent(PsiClass.class)
                    .withSuperParent(PARENT_OF_THE_PARENT, PsiFile.class)
                    .withFoundSpecOfAnyType()
                    .withTestFixtureConfigured(false);

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new ConcordionInspectionVisitor<>(
                MISCONFIGURED_TEST_FIXTURE,
                holder,
                "Test fixture is not annotated with @RunWith(ConcordionRunner.class)",
                null
        );
    }
}
