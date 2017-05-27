package de.apage4u.powermock;

class StaticPrivateExample {
    String methodMakingPrivateMethodCall(String text) {
        return privateMethod(text);
    }

    String methodMakingStaticNonVoidMethodCall(String text) {
        return ExampleUtil.staticReturnHello(text);
    }

    String methodMakingStaticVoidMethodCall(String text) {
        ExampleUtil.staticPrintHello(text);
        return "printed " + text;
    }

    private String privateMethod(String helloMessage) {
        return "another " + helloMessage;
    }
}