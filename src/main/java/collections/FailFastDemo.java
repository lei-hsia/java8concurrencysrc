package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FailFastDemo {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if (item.equals("2")){
                iterator.remove();
            }
        }
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            String string = iterator1.next();
            System.out.println(string);
        }
        // ReentrantReadWriteLock
    }
}
