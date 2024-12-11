import java.util.LinkedList;

public class MyHashTable<K, V> {
    private final int numBuckets;
    private final LinkedList<MyMapNode<K, V>>[] bucketArray;

    public MyHashTable() {
        this.numBuckets = 10; // Default number of buckets
        this.bucketArray = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            bucketArray[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % numBuckets;
    }

    // Add or update key-value pair in the hash table
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.setValue(value); // Update value if key exists
                return;
            }
        }

        bucket.add(new MyMapNode<>(key, value)); // Add new key-value pair
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.getValue();
            }
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = bucketArray[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); // Remove node from linked list
                return;
            }
        }
    }
}
