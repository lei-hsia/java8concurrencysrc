package deutsch;

public class SuperTest {
    private int n;
    protected Number getLocalNode(String value, boolean isValid){return (Number)n;}
}

class Sub extends SuperTest {
    // SuperTest'; attempting to assign weaker access privileges ('private'); was 'protected'
    @Override
    protected Integer getLocalNode(String value, boolean isValid) {
        return (Integer) super.getLocalNode(value, isValid);
    }
}