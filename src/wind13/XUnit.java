package wind13;

import java.util.HashMap;
import java.util.Map;

public class XUnit {
    private Map<String, Runnable> methods = new HashMap<>();

    public TestSuitResult runTests() {
        Runnable runTests = this::runTests;
        return new TestSuitResult();
    }

    public Runnable regTestMethod(String name, Runnable method) {
        return this.methods.put(name, method);
    }

    public void setMethods(Map<String, Runnable> methods) {
        this.methods = methods;
    }

    public Map<String, Runnable> getMethods() {
        return this.methods;
    }
}
