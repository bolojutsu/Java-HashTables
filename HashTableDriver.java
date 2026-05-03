public class HashTableDriver implements HashTableDriverInterface {

    public Person<Integer>[] createPersons(int numPeople) {
        Person<Integer>[] people = new Person[numPeople];
        for(int i = 0; i < numPeople; i++) {
            people[i] = new Person<>(i);
        }
        return people;
    }

    public LinkedList<Person<Integer>, Integer>[] createBuckets(int numBuckets) {
        LinkedList<Person<Integer>, Integer>[] buckets = new LinkedList[numBuckets];
        for(int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
        return buckets;
    }

    public HashTable<Person<Integer>, Integer> createHashTable(TestType testType, int numPeople) {
        HashTable<Person<Integer>, Integer> hashTable = new HashTable<>();
        if(testType == TestType.Get || testType == TestType.Remove) {
            Person<Integer>[] people = createPersons(numPeople);
            for(int i = 0; i < numPeople; i++) {
                hashTable.insert(people[i]);
            }
        }
        return hashTable;
    }

    public Object[] runTestCase(TestType testType, int numPeople, int numberOfTimes) {
        return null;
    }
}
