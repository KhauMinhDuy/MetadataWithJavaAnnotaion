package com.khauminhduy.model;

//@SuppressWarnings("deprecation")
public class Woker {

    public void doSomeWork() {
        Doer doer = new Doer();
        doer.doTheThing();
    }

    public void doDoubleWork() {
        Doer doer = new Doer();
        doer.doTheThing();
        doer.doTheThing();
    }
}
