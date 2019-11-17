package space.harbour.observer;

public interface Observable {
    void addObserver(Object ob);
    void removeObserver(Object ob);
    void notifyObservers();
}

