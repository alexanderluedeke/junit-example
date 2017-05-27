package de.apage4u.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * This test tries to explain how to use Powermock to mock static and private methods.
 * Powermock is an framework that extends mock frameworks like Mockito etc.
 *
 * When you’ve situations where you need to mock static or private methods, Powermock comes
 * handy and useful. It’s better than modifying code under test.
 *\
 * Thanks to i do dev jobs!
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StaticPrivateExample.class, ExampleUtil.class })
public class StaticPrivateExampleTest {

    @Test
    public void testMethodMakingPrivateMethodCall() throws Exception {
        StaticPrivateExample spyStaticPrivateExample = PowerMockito.spy(new StaticPrivateExample());
        when(spyStaticPrivateExample, method(StaticPrivateExample.class, "privateMethod", String.class)).withArguments(anyString()).thenReturn("test test");

        String result = spyStaticPrivateExample.methodMakingPrivateMethodCall("test");

        assertEquals("test test", result);
    }

    @Test
    public void testMethodMakingStaticNonVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        when(ExampleUtil.staticReturnHello(anyString())).thenReturn("test test");

        String result = new StaticPrivateExample().methodMakingStaticNonVoidMethodCall("test");

        assertEquals("test test", result);
    }

    @Test
    public void testMethodMakingStaticVoidMethodCall() throws Exception {
        mockStatic(ExampleUtil.class);
        //doNothing().when(ExampleUtil.class);

        new StaticPrivateExample().methodMakingStaticVoidMethodCall("test");
    }
}