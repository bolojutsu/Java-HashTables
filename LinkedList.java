
public class LinkedList<E extends KeyedElementInterface<K>, K> implements ListInterface<E, K> {
    private int count;

    public class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public ElementIterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public ListInterface<E, K> copy() {
        return null;
    }

    @Override
    public E add(E element) {
        return null;
    }

    @Override
    public E get(K key) {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    @Override
    public E remove(K key) {
        return null;
    }

    @Override
    public void removeAll() {

    }
}
