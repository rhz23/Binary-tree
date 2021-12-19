package entities;

public abstract class ObjTree<T> implements Comparable<T> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compare(T other);
    public abstract String toString();

}
