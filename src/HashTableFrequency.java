public class HashTableFrequency {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();

        String sentence = "To be or not to be";
        String[] words = sentence.split(" ");

        for (String word : words) {
            Integer count = hashTable.get(word);
            if (count == null) {
                hashTable.put(word, 1);
            } else {
                hashTable.put(word, count + 1);
            }
        }

        System.out.println("Frequency of words:");
        for (String word : words) {
            System.out.println(word + ": " + hashTable.get(word));
        }
    }
}
