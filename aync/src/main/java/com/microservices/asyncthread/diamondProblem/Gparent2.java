package com.microservices.asyncthread.diamondProblem;

public interface Gparent2 extends GreatGreatParent {
@Override
    default void play(){
        System.out.println("by by");
    }
}
