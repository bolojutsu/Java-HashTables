public class HashTable<E extends KeyedElementInterface<K>, K> implements HashTableInterface<E, K> {
    private static int NUMBER_OF_BUCKETS = 26;
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

        for (int i = 0; i < incomingBuckets.length; i++) {
            if (!(incomingBuckets[i] instanceof LinkedList<?, ?>)) {
                throw new InstantiationException();
            }
        }

        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            LinkedList<E, K> list = (LinkedList<E, K>) incomingBuckets[i];
            this.buckets[i] = (LinkedList<E, K>) list.copy();
            this.size += list.size();
        }
    }

    private int hashFunction(int key) {
        int hashCode = key % buckets.length;
        return hashCode;
    }

    private int probe(int hashCode, int i) {
        return (hashCode + i + (i * i)) % buckets.length;
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

        return null;
    }

    @Override
    public ElementIterator<E> iterator() {
        return null;
    }

    @Override
    public E insert(E element) {
        return null;
    }

    @Override
    public E get(K key) {
        return null;
    }

    @Override
    public E remove(K key) {
        return null;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public int getSizeOfLargestBucket() {
        return 0;
    }

    @Override
    public double getAverageBucketSize() {
        return 0.0;
    }

    @Override
    public Object[] getBuckets() {
        return null;
    }

}
