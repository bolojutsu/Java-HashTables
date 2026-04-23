import java.util.Objects;
import java.util.Vector;

public class LinkedList<E extends KeyedElementInterface<K>, K> implements ListInterface<E, K> {
    private int count;
    private Node front;
    private Node back;

    public class Node {
        private E element;
        private Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public Node getNext() {
            return this.next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public ElementIterator<E> iterator() {
        Vector<E> vector = new Vector<>();
        Node current = this.front;

        while (current != null) {
            vector.add(current.getElement());
            current = current.getNext();
        }
        return new ElementIterator<>(vector);
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
        LinkedList<E, K> copiedList = new LinkedList<>();
        Node current = this.front;

        while (current != null) {
            E copiedElement = (E) current.getElement().copy();
            copiedList.add(copiedElement);
            current = current.getNext();
        }
        return copiedList;
    }

    @Override
    public E add(E element) {
        if (element == null) {
            return null;
        }

        E displacedElement = this.remove(element.getKey());
        Node newNode = new Node(element);

        if (this.isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.setNext(newNode);
            this.back = newNode;
        }

        this.count++;
        return displacedElement;
    }

    @Override
    public E get(K key) {
        Node current = this.front;

        while (current != null) {
            E currentElement = current.getElement();
            if (Objects.equals(currentElement.getKey(), key)) {
                return currentElement;
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public E replace(E element) {
        if (element == null) {
            return null;
        }

        K targetKey = element.getKey();
        Node current = this.front;

        while (current != null) {
            E currentElement = current.getElement();
            if (Objects.equals(currentElement.getKey(), targetKey)) {
                current.setElement(element);
                return currentElement;
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public E remove(K key) {
        Node current = this.front;
        Node previous = null;

        while (current != null) {
            E currentElement = current.getElement();
            if (Objects.equals(currentElement.getKey(), key)) {
                if (previous == null) {
                    this.front = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                if (current == this.back) {
                    this.back = previous;
                }

                this.count--;
                if (this.count == 0) {
                    this.front = null;
                    this.back = null;
                }

                return currentElement;
            }

            previous = current;
            current = current.getNext();
        }

        return null;
    }

    @Override
    public void removeAll() {
        this.front = null;
        this.back = null;
        this.count = 0;
    }
}
