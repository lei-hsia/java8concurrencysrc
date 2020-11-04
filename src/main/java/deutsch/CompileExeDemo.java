package deutsch;

public class CompileExeDemo {
    public static void main(String[] args) {
        String[] arg = new String[0];
        meth(arg);
    }
    
    public static void meth(String[] arg){
        System.out.println(arg);
        System.out.println(arg[1]);
    }
}
