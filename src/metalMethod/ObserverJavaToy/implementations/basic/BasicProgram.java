package metalMethod.ObserverJavaToy.implementations.basic;

import metalMethod.ObserverJavaToy.interfaces.Observer;

import java.util.Scanner;

public class BasicProgram {

    private BasicObservable basicObservable;

    private int nameCount;

    public BasicProgram() {
        this.basicObservable = new BasicObservable("BasicSubject");
    }

    public void run() {

        while (true) {

            System.out.println("Say something to all observers:");
            Scanner scan = new Scanner(System.in);
            String inputText = scan.nextLine();

            this.basicObservable.setContent(inputText);
            this.basicObservable.printObserversContent();
            this.basicObservable.printUpdateStatus();

            this.basicObservable.register(new BasicObserver("Observer " + this.nameCount));
            this.nameCount++;


        }

    }


}
