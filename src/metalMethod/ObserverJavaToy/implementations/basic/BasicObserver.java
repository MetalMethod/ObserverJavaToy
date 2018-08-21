package metalMethod.ObserverJavaToy.implementations.basic;

import metalMethod.ObserverJavaToy.interfaces.Observer;
import metalMethod.ObserverJavaToy.interfaces.Subject;

public class BasicObserver implements Observer {

    private Subject subject;

    public String name;
    public String content;

    private int notificationsCount;

    public BasicObserver(String name) {
        this.name = name;
        this.content = "";
        this.notificationsCount = 0;
    }

    @Override
    public void update() {
        this.subject.getUpdate(this);
        this.notificationsCount++;
    }

    @Override
    public String getContent() {
        return this.name + ": " + this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public int getNotificationsCount() {
        return this.notificationsCount;
    }
}
