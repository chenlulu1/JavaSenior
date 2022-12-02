package com.atguigu.java;

/**
 *  *
 *  * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * 使用同步方法处理继承Thread类的方法中的线程安全问题
 *
 *  *
 * @author shkstart
 * @create 2022-12-02 11:37
 */
class Window4 extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            show();
            }
    }
    private static synchronized void show(){//同步监视器Window4.class
        if (ticket>0){
             try {
                 sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
                System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket);
                ticket--;
            }
        }
    }

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}