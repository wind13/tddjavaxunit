package wind13;

public class SimpleUtilsTest extends XUnitTest {
    public SimpleUtilsTest() {
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
