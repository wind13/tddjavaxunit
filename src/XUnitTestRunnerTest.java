import org.junit.jupiter.api.Test;
import wind13.SomeTests;
import wind13.TestSuitResult;
import wind13.XUnit;

import static org.junit.jupiter.api.Assertions.*;

public class XUnitTestRunnerTest {
    @Test
    void testXUnit() {
        XUnit xunit = new XUnit();
        assertNotNull(xunit);
    }
    @Test
    void testSomeTest() {
        SomeTests someTests = new SomeTests();
        someTests.regTestMethod("single_test_method", someTests::single_test_method);
        assertTrue(someTests.getMethods().containsKey("single_test_method"));
        TestSuitResult testSuitResult = someTests.runTests();
        assertNotNull(testSuitResult);
        assertNotNull(testSuitResult.results);
    }
}
