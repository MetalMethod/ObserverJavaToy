package metalMethod.ObserverJavaToy.implementations.basic;

import metalMethod.ObserverJavaToy.interfaces.Observer;
import metalMethod.ObserverJavaToy.interfaces.Subject;

import java.util.ArrayList;

public class BasicObservable implements Subject {

    private String subjectName;

    private int updateNumber;

    private String content;

    private ArrayList<Observer> observers;

    public BasicObservable(String subjectName) {
        this.subjectName = subjectName;
        this.observers = new ArrayList<>();
        this.updateNumber = 0;
        this.content = "";
    }

    @Override
    public void register(Observer observer) {
        try {
            this.observers.add(observer);
        } catch (
                Exception e) {
            this.errorMessage("#### Can't register Observer to this Subject", e);
        }
    }

    @Override
    public void unRegister(Observer observer) {
        try {
            this.observers.remove(observer);
        } catch (Exception e) {
            this.errorMessage("#### Observer not found in this Subject", e);
        }
    }

    @Override
    public void notifyObservers() {
        try {
            for (Observer o : this.observers) {
                o.setContent(this.content);
            }
        } catch (Exception e) {
            this.errorMessage("#### Observers list is empty", e);
        }
    }

    @Override
    public void getUpdate(Observer observer) {
        observer.setContent(this.content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setNewUpdate();
    }

    private void setNewUpdate() {
        this.updateNumber++;
        this.printCurrentContent();
        this.notifyObservers();
    }

    public void printUpdateStatus() {
        System.out.println("#   updated " + this.updateNumber
                + " times from: " + this.subjectName);
        System.out.println("\n");

    }

    public void printCurrentContent() {
        System.out.println("Subject content: " + this.content);
    }

    public void printObserversContent() {
        for (Observer o : this.observers) {
            System.out.println(o.getContent());
        }
    }

    private void errorMessage(String s, Exception e) {
        System.out.println(s);
        System.out.println(e);
    }
}
