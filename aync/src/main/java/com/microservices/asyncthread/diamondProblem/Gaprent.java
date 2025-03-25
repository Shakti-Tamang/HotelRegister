package com.microservices.asyncthread.diamondProblem;


//To solve the diamond problem caused by conflicting default methods in
//        interfaces, you must explicitly override the conflicting method
//        in the class that implements both interfaces. Here's how to resolve
//        it in your example:


public interface Gaprent extends GreatGreatParent{
//    1. Override the Conflicting Method
//    In the Parent2 class, override the play() method and either:
//
//    Choose one of the interface implementations.
//
//    Combine both implementations.
//
//    Define a new implementation.
//
//2. Use InterfaceName.super.method()
//    To explicitly call a specific interface’s default method, use the syntax
//        <InterfaceName>.super.<methodName>().
//


//    Why the Conflict Occurs:
//    Both Gaprent and Gparent2 override play() from GreatGreatParent, so
//    Parent2 inherits two conflicting default implementations. Java forces
//    you to resolve this ambiguity.
//
//            Compile-Time Safety:
//    If you don’t override play(), the compiler will throw an error:
    @Override
default void play(){
    System.out.println("by");
}

}
