package deutsch;

import java.util.Arrays;
import java.util.List;


// java ITest ADD SUBTRACT  : 7 4
public class ADDSUBTRACT {
    static int index= 0;

    public static void main(String[] args) {
        List<MathOperation> list = Arrays.asList(null, null);
        list.forEach(m-> System.out.print(m.calculate(args[index++],1,2) + " "));
    }
}

class MathOperation {
    public static int calculate(String choice, int a, int b) {
        int c= 3;
        switch (choice) {
            case "ADD": c+=a+b; // 因为没有break;
            case "SUBTRACT": c+=a-b;
            default: c+=a*b;
        }
        return c;
    }
}
