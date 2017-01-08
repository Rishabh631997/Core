package com.company.concurrency.test;

/**
 * Created by Pgupta on 10/30/2015.
 */
public class LoggingWidget extends Widget {
    public synchronized void doSomething(){
        System.out.println(toString() + " : calling doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}

