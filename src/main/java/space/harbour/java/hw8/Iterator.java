public final interface Iterator<T> {
    T next();
    T current();
    boolean hasNext();
}
