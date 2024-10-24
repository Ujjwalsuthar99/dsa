package org.example.practice;

public class Exp2OfStaticFinalClass {




    public static void main(String[] args) {

        ExpOfStaticFinalClass.age2 = 33;
        ExpOfStaticFinalClass expOfStaticFinalClass = new ExpOfStaticFinalClass();

//        expOfStaticFinalClass.age = 33;
        System.out.println("aggee: " + ExpOfStaticFinalClass.age2);

    }


}
