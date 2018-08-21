package metalMethod.ObserverJavaToy.interfaces;

/**
 *Observer design pattern
 * from: https://sourcemaking.com/design_patterns/observer/java/1
 *
 * Model the "independent" functionality with a "subject" abstraction
 * Model the "dependent" functionality with "observer" hierarchy
 * The Subject is coupled only to the Observer base class
 * Observers register themselves with the Subject
 * The Subject broadcasts events to all registered Observers
 * Observers "pull" the information they need from the Subject
 * Client configures the number and type of Observers

 * Subject also contain a method to notify all the observers of any change and either it can send the update
 * while notifying the observer
 * or it can provide another method to get the update.
 * <p>
 * Observer should have a method to set the object to watch
 * and another method that will be used by Subject to notify them of any updates.
 */

public interface Subject {

    /**
     * Registers a observer in this subject
     *
     * @param observer
     */
    void register(Observer observer);

    /**
     * Unregisters a observer in this subject
     *
     * @param observer
     */
    void unRegister(Observer observer);

    /**
     * Notify all registered observers of changes in this subject
     */
    void notifyObservers();

    /**
     * Sends to the Observer the update from this subject
     * @param observer
     */
    void getUpdate(Observer observer);

}


