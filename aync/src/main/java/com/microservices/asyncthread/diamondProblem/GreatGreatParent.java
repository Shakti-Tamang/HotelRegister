package com.microservices.asyncthread.diamondProblem;

//@FunctionalInterface
public interface GreatGreatParent {
//    public void go();
    default void play(){
        System.out.println("hello");
    }
}
