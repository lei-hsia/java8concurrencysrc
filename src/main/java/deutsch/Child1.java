package deutsch;

public class Child1 extends Parent{
    public Child1() {count++;}

    public static void main(String[] args) {
        System.out.println("Count="+getCount());
        Child1 obj = new Child1();
        System.out.println("Count="+getCount());
    }
}