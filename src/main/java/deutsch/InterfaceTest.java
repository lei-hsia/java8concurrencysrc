package deutsch;

public class InterfaceTest implements inter{
    public static void main(String[] args) {

    }

    @Override // 实现类只能更高access level，不写/default: 默认private
    // default: Extension methods can only be used within an interface 默认方法只能在接口中定义,可以在实现类中重写和继承
    public void func1(){

    }
}

// interface: always public
interface inter{
    default void func1() {

    }
}