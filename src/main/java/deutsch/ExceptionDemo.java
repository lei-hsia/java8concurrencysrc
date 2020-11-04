package deutsch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExceptionDemo {
    public static void main(String[] args) {
        String a = null;
        Optional<String> b = Optional.empty();
        try {
            System.out.print(a.length());
            System.out.println(b.orElse("").length()); // ""
        }
        catch (Exception e) {
            System.out.print(a);
        }
        finally {
            a = "String";
            System.out.print(a.length());
            b = Optional.ofNullable("");
            System.out.println(b.get().length());
        }
    }

    List<?> list = new ArrayList<String>();
}
