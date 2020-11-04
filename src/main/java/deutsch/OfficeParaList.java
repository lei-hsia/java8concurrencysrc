package deutsch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfficeParaList {
    public static void main(String[] args) {
        List<Map<List<Integer>, List<String>>> officeParamList = new ArrayList<>();
        Map<List<Integer>, List<String>> officeParamMap = new HashMap<>();
        officeParamList.add(null);
        officeParamList.add(officeParamMap); // {}
        officeParamList.add(new HashMap<List<Integer>, List<String>>()); // {}
        officeParamList.forEach(e -> System.out.print(e+ " "));
    }
}
