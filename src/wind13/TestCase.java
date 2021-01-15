package wind13;

public class TestCase {
    private String name;
    private Runnable method;
    private boolean isSuccess;

    TestCase(String name, Runnable method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return this.name;
    }

    public boolean runTest() {
        this.method.run();
        // How to know the run result?
        return this.isSuccess;
    }
}
