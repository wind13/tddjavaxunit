package wind13;

public class TestCase {
    private String name;
    private Runnable method;
    private boolean isSuccess;
    private String result;

    public static final String PASS = "PASS";
    public static final String FAILED = "FAILED, Info: %s";

    TestCase(String name, Runnable method) {
        this.name = name;
        this.method = method;
        this.isSuccess = false;
        this.result = "Not run test, no result now.";
    }

    public String getName() {
        return this.name;
    }

    public boolean runTest() {
        try {
            this.method.run();
            this.isSuccess = true;
            this.result = PASS;
        } catch (Exception e) {
            e.printStackTrace();
            this.isSuccess = false;
            this.result = String.format(FAILED, e.getLocalizedMessage());
        }
        return this.isSuccess;
    }

    public String getResult() {
        return this.result;
    }
}
