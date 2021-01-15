package wind13;

import java.util.ArrayList;
import java.util.List;

public class XUnitTest {

    public static final String FAILED_ASSERT_TRUE = "Expect true but got false.";

    public static void assertTrue(boolean b) {
        if(!b) {
            throw new RuntimeException(FAILED_ASSERT_TRUE);
        }
    }

    private List<TestCase> methods = new ArrayList<>();

    public void registerTestCase(String name, Runnable method) {
        this.methods.add(new TestCase(name, method));
    }

    public List<TestCase> getTestMethods() {
        return this.methods;
    }

    public TestCase getTestCase(String name) {
        return this.methods.parallelStream().takeWhile(
                testCase -> testCase.getName().equals(name)
        ).findFirst().orElse(null);
    }
}
