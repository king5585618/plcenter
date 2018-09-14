package com.kakarot.plcenter.gc;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {
    public static Test test = null;
    public void a() {
        System.out.println("yes, i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed !");
        Test.test = this;
    }

    public static void main(String[] args) throws InterruptedException {
        test = new Test();
        test = null;
        System.gc();
        Thread.sleep(500L);
        if(test != null){
            test.a();
        }else{
            System.out.println("dead");
        }
        test = null;
        System.gc();
        Thread.sleep(500L);
        if(test != null){
            test.a();
        }else{
            System.out.println("dead");
        }
    }
}
