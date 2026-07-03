//package com.zero.learns.loom;
//
//import java.util.concurrent.ThreadFactory;
//
///**
// * 用户线程测试
// * @since jdk23
// */
//public class JLoomTest {
//    public static void main(String[] args) {
//        Thread vt1 =  Thread.ofVirtual().name("VT001").start(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("VT001");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        Thread vt2 =  Thread.ofVirtual().name("VT002").start(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("VT002");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        ThreadFactory vtf = Thread.ofVirtual().factory();
//        Thread vt3 = vtf.newThread(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("VT003");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        vt3.start();
//        Thread vt4 = vtf.newThread(() -> {
//            while(true) {
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("VT004");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        vt4.start();
//
//        Thread at1 = new Thread(() -> {
//            int i = 100;
//            while(i>0) {
//                try {
//                    i--;
//                    Thread.sleep(1000L);
//                    System.out.println("VT004");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        at1.start();
//        System.out.println("vt1 group: " + vt1.getThreadGroup().getName() + ", thread vt1 id: " + vt1.threadId());
//        System.out.println("vt2 group: " + vt2.getThreadGroup().getName() + ", thread vt2 id: " + vt2.threadId());
//        System.out.println("vt3 group: " + vt3.getThreadGroup().getName() + ", thread vt3 id: " + vt3.threadId());
//        System.out.println("vt4 group: " + vt4.getThreadGroup().getName() + ", thread vt4 id: " + vt4.threadId());
//        System.out.println("at1 group: " + at1.getThreadGroup().getName() + ", thread at1 id: " + at1.threadId());
//        try {
//            Thread.sleep(100000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("end");
//    }
//}
