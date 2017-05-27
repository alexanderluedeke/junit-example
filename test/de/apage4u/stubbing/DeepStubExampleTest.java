package de.apage4u.stubbing;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * When you’ve situations where your class under test has multiple levels of dependencies, Deep Stubs comes in handy.
 * In this example, the class under text DeepStubExample is dependent on DeepStubDependent which is in turn dependent
 * on DeepStubDependentDependent.
 *
 * Thanks to i do dev jobs!
 */

@RunWith(PowerMockRunner.class)
public class DeepStubExampleTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private DeepStubDependent deepStubDependentMock;

    @Test
    public void testMethodUnderTest() {
        DeepStubExample deepStubExample = new DeepStubExample();
        deepStubExample.setDeepStubDependent(deepStubDependentMock);
        given(deepStubDependentMock.getDeepStubDependentDependent().getMessage(anyString())).willReturn("some text");

        String output = deepStubExample.methodUnderTest("test");

        assertEquals("some text", output);
    }
}