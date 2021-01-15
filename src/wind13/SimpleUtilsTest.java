package wind13;

import java.util.ArrayList;
import java.util.List;

public class SimpleUtilsTest {
    private List<TestCase> methods = new ArrayList<>();

    public SimpleUtilsTest() {
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
//        if(r == 8) {
//            this.methods.find
//        }
        return;
    }
    public void testAddFailed() {
        return;
    }
}
