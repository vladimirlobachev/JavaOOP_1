package space.harbour.atm;

public interface Iterator<T> {
    T next();
    T current();
    boolean hasNext();
}
