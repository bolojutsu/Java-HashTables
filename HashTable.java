public class HashTable<E extends KeyedElementInterface<K>, K> implements HashTableInterface<E, K> {
    private LinkedList<E, K> bucketList;
    private int count;

    public HashTable() {
        this.bucketList = null;
        this.count = 0;
    }

    private int hashFunction(K key) {
        return 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
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
