import org.junit.jupiter.api.Test;
import wind13.SimpleUtils;
import wind13.SimpleUtilsTest;
import wind13.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class XUnitUtilTest {
    @Test
    public void should_have_a_single_method_class_test_class() {
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        assertNotNull(simpleUtilsTest);
    }

    @Test
    public void should_have_test_methods_in_test_class() {
        SimpleUtils simpleUtils = new SimpleUtils();
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        String methodName = "testAddSuccess";
        simpleUtilsTest.registerMethod(methodName, simpleUtilsTest::testAddSuccess);
        assertEquals(simpleUtilsTest.getTestMethodsCount(), 1);
        assertEquals(simpleUtilsTest.getTestMethods().size(), 1);
        TestCase testCase = simpleUtilsTest.getTestMethods().get(0);
        assertNotNull(testCase);
        assertEquals(testCase.getName(), methodName);
    }

    @Test
    public void should_run_test_and_know_success_or_failed() {
        SimpleUtils simpleUtils = new SimpleUtils();
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        simpleUtilsTest.registerMethod("testAddSuccess", simpleUtilsTest::testAddSuccess);
        TestCase testCase = simpleUtilsTest.getTestMethods().get(0);
        assertTrue(testCase.runTest());
//        assertEquals(testCase.getResult());
    }
}
