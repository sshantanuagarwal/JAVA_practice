package com.company;

import java.util.ArrayList;
import java.util.List;

class Subject {
    private List<ObserverImpl> observers = new ArrayList<>();
    private String stats;
    public String getStats() {
        return stats;
    }

    public void attach(ObserverImpl observer) {
        observers.add(observer);
    }

//    public void notify() {
//        for(Observer observer : observers) {
//            observer.update();
//        }
//    }


}
interface Observer{
    void update();
}

class ObserverImpl implements  Observer
{
 private String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println();
    }

}

public class ObserverRunner {
    public static void main(String[] args) {
//        Subject subject = new Subject();
    }
}