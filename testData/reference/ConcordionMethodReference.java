package com.test;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ConcordionMethodReference {

    public int methodToResolve() {
        return 42;
    }
}
