package com.company;

public class Two_Stacks {

    int size=10, top1=5,top2=4 ;
    int[] s;

    Two_Stacks(){
        s= new int[size];
    }
    public void push1(int a){
      if(top1>0) {
          top1--;
          s[top1] = a;
      } else {
          System.out.println("Stack is full");
      }
    }

    public void pop1(){

        if(top1==5) {
            System.out.println("Stack is empty");
        } else {
            top1++;
        }
    }
    public void print1(){
        System.out.print("s1 :");

        for(int i=top1; i<=4; i++){
            System.out.print(s[i]+"\t");
        }
        System.out.println();

    }

    public void push2(int a){
        if(top2<size-1) {
            top2++;
            s[top2] = a;
        } else {
            System.out.println("Stack is full");
        }
    }

    public void pop2(){

        if(top2==4) {
            System.out.println("Stack is empty");
        } else {
            top2--;
        }
    }
    public void print2(){
        System.out.print("s2 :");

        for(int i=top2; i>=5; i--){
            System.out.print(s[i]+"\t");

        }
        System.out.println();
    }

    public static void main(String[] args) {

        Two_Stacks twoS = new Two_Stacks();
        twoS.push1(1);
        twoS.push1(2);
        twoS.push1(3);
        twoS.push1(4);
        twoS.push1(5);
        twoS.push1(6);

        twoS.print1();

        twoS.push2(1);
        twoS.push2(2);
        twoS.push2(3);
        twoS.push2(4);
        twoS.push2(5);
        twoS.push2(6);


        twoS.print2();

        twoS.pop1();
        twoS.pop2();
        twoS.print1();
        twoS.print2();




    }
}
