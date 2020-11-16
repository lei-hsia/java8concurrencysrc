package ths;

import java.util.Map;
import java.util.TreeMap;

public class MapPrintTest {
    /*
    *       1
            2
            33
            4
            Error
    * */
    public static void main(String[] args) throws Exception {
        try {
            String[] codeList = {"01", "02", "03", "04"};
            Map map = new TreeMap();
            map.put(3,3);
            map.put(3,33);
            map.put(2,2);
            map.put(4,4);
            map.put(1,1);
            for(Object i : map.keySet()){
                System.out.println(map.get(i));
            }
            System.out.println(codeList[4]);
        }catch (Exception e) {
            System.out.println("Error");
        }
    }
}
