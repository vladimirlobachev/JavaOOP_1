package space.harbour.factory;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
    int cashLeft();
    boolean setUp(int numOfConts);
    void withdraw(int amount);
    int getId();
}
