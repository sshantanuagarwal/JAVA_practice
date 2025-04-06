package com.company;

class A {
    void fun() {
        System.out.println("fun for A");
    }
}



class B extends A {
    void fun() {
        System.out.println("fun for B");
    }
}
public class Inheritence {
    public static void main(String[] args) {
        A a = new B();
        a.fun();

        B b = new B();
        b.fun();
    }
}
