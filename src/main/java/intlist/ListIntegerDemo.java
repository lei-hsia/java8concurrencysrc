package intlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListIntegerDemo {
    public static void main(String[] args) {
        // int[] -> List<Integer> Integer[] 往大的方向转: Arrays.stream() ...
        // List<Integer> Integer[] -> int[] 往小的方向转: list.stream().mapToInt(). ...
        int[] nums = {4, 3, 5, 6, 8, 1};

        // int[] -> List<Integer>
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。

        // int[] -> Integer[] : 变成这种类型都需要装箱，所以都需要boxed()
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // List<Integer> -> int[]
        int[] ints1 = list.stream().mapToInt(Integer::valueOf).toArray();
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。

        // Integer[] -> int[]
        int[] ints2 = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。

        /* List<String> 和 String[] 的转化*/
        String[] str = {"a", "b", "c"};
        // String[] -> List<String>
        List<String> listStr = Arrays.asList(str);
        // List<String> -> String[]
        String[] strings = listStr.toArray(new String[listStr.size()]);
    }
}
