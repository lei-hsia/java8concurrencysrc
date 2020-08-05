package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastDemo {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if (item.equals("1")){
                iterator.remove();
            }
        }
        while (iterator.hasNext()){
            String string = iterator.next();
            System.out.println(string);
        }
    }
}
