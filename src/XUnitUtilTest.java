import org.junit.jupiter.api.Test;
import wind13.AnotherUtilsTest;
import wind13.SimpleUtilsTest;
import wind13.TestCase;

import static org.junit.jupiter.api.Assertions.*;

class XUnitUtilTest {
    @Test
    void should_have_a_single_method_class_test_class() {
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        assertNotNull(simpleUtilsTest);
    }

    @Test
    void should_have_test_methods_in_test_class() {
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        String methodName = "testAddSuccess";
        simpleUtilsTest.registerTestCase(methodName, simpleUtilsTest::testAddSuccess);
        assertEquals(simpleUtilsTest.getTestMethods().size(), 1);
        TestCase testCase = simpleUtilsTest.getTestMethods().get(0);
        assertNotNull(testCase);
        assertEquals(testCase.getName(), methodName);
    }

    @Test
    void should_run_test_and_know_success_or_failed() {
        SimpleUtilsTest simpleUtilsTest = new SimpleUtilsTest();
        simpleUtilsTest.registerTestCase("testAddSuccess", simpleUtilsTest::testAddSuccess);
        TestCase testCase = simpleUtilsTest.getTestMethods().get(0);
        assertTrue(testCase.runTest());
        assertEquals(testCase.getResult(), TestCase.PASS);
        simpleUtilsTest.registerTestCase("testAddFailed", simpleUtilsTest::testAddFailed);
        TestCase testCaseFailed = simpleUtilsTest.getTestMethods().get(1);
        assertFalse(testCaseFailed.runTest());
        assertEquals(testCaseFailed.getResult(), String.format(TestCase.FAILED, SimpleUtilsTest.FAILED_ASSERT_TRUE));
    }

    @Test
    void should_assert_result_pass_or_failed() {
        assertDoesNotThrow(() -> SimpleUtilsTest.assertTrue(true));
        @SuppressWarnings("ConstantConditions")
        Throwable exception = assertThrows(RuntimeException.class, () -> SimpleUtilsTest.assertTrue(false));
        assertEquals(exception.getLocalizedMessage(), SimpleUtilsTest.FAILED_ASSERT_TRUE);
    }

    void another_test_class_should_also_work() {
        AnotherUtilsTest anotherUtilsTest = new AnotherUtilsTest();
        anotherUtilsTest.registerTestCase("testMultiSuccess", anotherUtilsTest::testMultiSuccess);
        anotherUtilsTest.registerTestCase("testMultiFailed", anotherUtilsTest::testMultiFailed);
        assertEquals(anotherUtilsTest.getTestMethods().size(), 2);
        TestCase testCase = anotherUtilsTest.getTestCase("testMultiSuccess");
        assertTrue(testCase.runTest());
        assertEquals(testCase.getResult(), TestCase.PASS);
        TestCase testCaseFailed = anotherUtilsTest.getTestMethods().get(1);
        assertFalse(testCaseFailed.runTest());
        assertEquals(testCaseFailed.getResult(), String.format(TestCase.FAILED, SimpleUtilsTest.FAILED_ASSERT_TRUE));
    }

    void run_all_test_method_in_class_should_work() {
        AnotherUtilsTest anotherUtilsTest = new AnotherUtilsTest();
        anotherUtilsTest.registerTestCase("testMultiSuccess", anotherUtilsTest::testMultiSuccess);
        anotherUtilsTest.registerTestCase("testMultiFailed", anotherUtilsTest::testMultiFailed);
//        TestClassResult testClassResult = anotherUtilsTest.runTests();
    }

}
