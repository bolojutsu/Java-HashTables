import java.util.Vector;
public class HashTable<E extends KeyedElementInterface<K>, K> implements HashTableInterface<E, K> {
    public static int NUMBER_OF_BUCKETS = 26;
    private LinkedList<E, K>[] buckets;
    private int size;

    public HashTable() {
        this.buckets = new LinkedList[NUMBER_OF_BUCKETS];
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            this.buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    public HashTable(Object[] incomingBuckets) throws InstantiationException {
        if (incomingBuckets.length != NUMBER_OF_BUCKETS) {
            throw new InstantiationException();
        }

        this.buckets = new LinkedList[NUMBER_OF_BUCKETS];
        this.size = 0;

        for (int i = 0; i < incomingBuckets.length; i++) {
            if (!(incomingBuckets[i] instanceof LinkedList<?, ?>)) {
                throw new InstantiationException();
            }

            LinkedList<E, K> list = (LinkedList<E, K>) incomingBuckets[i];
            this.buckets[i] = (LinkedList<E, K>) list.copy();
            this.size += this.buckets[i].size();
        }
    }

    private int hashFunction(K key) {
        return(key.hashCode()) % buckets.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public HashTableInterface<E, K> copy() {
        HashTable<E, K> copyTable = new HashTable<>();
        for(int i = 0; i < buckets.length; i++) {
            copyTable.buckets[i] = (LinkedList<E, K>) this.buckets[i].copy();
        }
        copyTable.size = this.size;
        return copyTable;
    }

    @Override
    public ElementIterator<E> iterator() {
        Vector<E> vector = new Vector<>();
        for(int i = 0; i< buckets.length; i++) {
            ElementIterator<E> bucketIterator = (ElementIterator<E>) buckets[i].iterator();
            while(bucketIterator.hasNext()) {
                vector.add(bucketIterator.next());
            }
        }
        return new ElementIterator<>(vector);
    }

    @Override
    public E insert(E element) {
        if(element == null) {
            return null;
        }
        int index = hashFunction(element.getKey());
        E displacedElement = buckets[index].add(element);

        if( displacedElement == null) {
            this.size++;
        }
        return displacedElement;
    }

    @Override
    public E get(K key) {
        if(key == null) {
            return null;
        }
        int index = hashFunction(key);
        return buckets[index].get(key);
    }

    @Override
    public E remove(K key) {
        if(key == null) {
            return null;
        }
        int index = hashFunction(key);
        E removedElement = buckets[index].remove(key);

        if(removedElement != null) {
            this.size--;
        }
        return removedElement;
    }

    @Override
    public void removeAll() {
        for(int i = 0; i < buckets.length; i++) {
            buckets[i].removeAll();
        }
        this.size = 0;
    }

    @Override
    public int getSizeOfLargestBucket() {
        int largest = 0;
        for(int i = 0; i< buckets.length; i++){
            if(buckets[i].size() > largest) {
                largest = buckets[i].size();
            }
        }
        return largest;
    }

    @Override
    public double getAverageBucketSize() {
        return (double) this.size / NUMBER_OF_BUCKETS;
    }

    @Override
    public Object[] getBuckets() {
        return this.buckets;
    }

}
