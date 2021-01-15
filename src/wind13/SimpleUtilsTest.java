package wind13;

import java.util.ArrayList;
import java.util.List;

public class SimpleUtilsTest {
    private List<TestCase> methods = new ArrayList<>();
    public static final String FAILED_ASSERT_TRUE = "Expect true but got false.";

    public SimpleUtilsTest() {
    }

    public static void assertTrue(boolean b) {
        if(!b) {
            throw new RuntimeException(FAILED_ASSERT_TRUE);
        }
    }

    public void registerMethod(String name, Runnable method) {
        this.methods.add(new TestCase(name, method));
    }

    public int getTestMethodsCount() {
        return this.methods.size();
    }

    public List<TestCase> getTestMethods() {
        return this.methods;
    }

    public void testAddSuccess() {
        SimpleUtils simpleUtils = new SimpleUtils();
        int r = simpleUtils.add(3, 5);
        assertTrue(r == 8);
    }
    public void testAddFailed() {
        SimpleUtils simpleUtils = new SimpleUtils();
        int r = simpleUtils.add(7, 8);
        assertTrue(r == 9);
    }
}
