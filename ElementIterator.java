import java.util.Iterator;
import java.util.Vector;

public class ElementIterator<E> implements Iterator<E> {
    private Vector<E> vector;
    private int count;

    public ElementIterator(Vector<E> vector) {
        this.vector = vector;
        this.count = 0;
    }

    public boolean hasNext() {
        return this.count < this.vector.size();
    }

    public E next() {
        E nextElement = vector.get(count);
        count++;
        return nextElement;
    }
}
