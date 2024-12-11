import java.util.ArrayList;

public class MyHashTable<K, V> {
    private final int numBuckets;
    private final ArrayList<MyMapNode<K, V>> bucketArray;

    public MyHashTable() {
        this.numBuckets = 10;
        this.bucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % numBuckets;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = bucketArray.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = bucketArray.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = bucketArray.get(index);
        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.next = head;
        bucketArray.set(index, newNode);
    }
}
