package deutsch;

public class Parent {
    protected static int count = 0;
    public Parent() { count++; }
    static int getCount() { return count; }
}

 class Child extends Parent{
    public Child() {count++;}

    public static void main(String[] args) {
        System.out.println("Count="+getCount());
        Child1 obj = new Child1();
        System.out.println("Count="+getCount());
    }
}