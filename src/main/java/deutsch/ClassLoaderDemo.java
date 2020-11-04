package deutsch;

public class ClassLoaderDemo {
}

class TestClassLoader {
    public static void main(String[] args) {
        try {
            Class.forName("string", true, ClassLoader.getSystemClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

