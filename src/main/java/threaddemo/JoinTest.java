package threaddemo;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("First task completed");
            }
        });
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("Second task completed");
            }
        });
        t.start(); // Line 15
        t.join(); // Waits for this thread to die, then execute others
        t1.start();
    }
}