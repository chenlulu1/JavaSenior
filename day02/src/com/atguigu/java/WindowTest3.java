package com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 * 关于同步方法的总结：
 * 1.同步方式仍然涉及到同步监视器，只是不需要我们显示的声明。
 * 2.非静态的同步方式，同步监视器是：this
 *   静态的同步方式，同步监视器是：当前类本身
 *
 *
 * @author shkstart
 * @create 2022-12-02 13:58
 */
class Window3 implements Runnable{

    private int ticket = 100;


    @Override
    public void run() {

        while(true){
                show();
            }
        }
        private synchronized void show(){

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                }

        }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
