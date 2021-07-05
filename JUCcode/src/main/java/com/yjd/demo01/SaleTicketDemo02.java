package com.yjd.demo01;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程就是一个单独的资源类，没有任何附属的操作
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {

        // 并发：多线程操作同一个资源类, 把资源类丢入线程
        Ticket2 ticket = new Ticket2();

        // @FunctionalInterface 函数式接口，jdk1.8 lambda表达式 (参数)->{ 代码 }
        new Thread(()->{for (int i = 1; i < 60 ; i++) ticket.sale();},"A").start();
        new Thread(()->{for (int i = 1; i < 60 ; i++) ticket.sale();},"B").start();
        new Thread(()->{for (int i = 1; i < 60 ; i++) ticket.sale();},"C").start();
    }
}

// lock
class Ticket2 {
    // 属性、方法
    private int number = 50;
    private int i = 0;
    Lock lock = new ReentrantLock();
    // 卖票的方式
    // synchronized 本质: 队列，锁
    public void sale(){
        lock.lock();
        //lock.tryLock();//尝试获取锁


        try {
            //业务代码
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(++i)+"票,剩余："+(--number));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //解锁
        }
    }
}

