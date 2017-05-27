package de.apage4u.stubbing;

public class DeepStubExample {

    private DeepStubDependent deepStubDependent;

    void setDeepStubDependent(DeepStubDependent deepStubDependent) {
        this.deepStubDependent = deepStubDependent;
    }

    DeepStubDependent getDeepStubDependent() {
        return deepStubDependent;
    }

    String methodUnderTest(String input) {
        return deepStubDependent.getDeepStubDependentDependent().getMessage(input);
    }

    public static void main(String[] args) {
        DeepStubExample deepStubExample = new DeepStubExample();
        deepStubExample.setDeepStubDependent(new DeepStubDependent());
        deepStubExample.getDeepStubDependent().setDeepStubDependentDependent(new DeepStubDependentDependent());
        System.out.println(deepStubExample.methodUnderTest("test"));
    }
}

class DeepStubDependent {

    DeepStubDependentDependent deepStubDependentDependent;

    void setDeepStubDependentDependent(DeepStubDependentDependent deepStubDependentDependent) {
        this.deepStubDependentDependent = deepStubDependentDependent;
    }

    DeepStubDependentDependent getDeepStubDependentDependent() {
        return deepStubDependentDependent;
    }
}

class DeepStubDependentDependent {
    String getMessage(String text) {
        return "message " + text;
    }
}
