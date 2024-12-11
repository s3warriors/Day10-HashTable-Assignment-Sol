public class RemoveWordFromHashTable {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();

        String paragraph = "Paranoids are not paranoid because they are paranoid " +
                "but because they keep putting themselves deliberately " +
                "into paranoid avoidable situations.";
        String[] words = paragraph.split(" ");

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

        hashTable.remove("avoidable");
        System.out.println("\nAfter removing 'avoidable':");
        for (String word : words) {
            if (hashTable.get(word) != null) {
                System.out.println(word + ": " + hashTable.get(word));
            }
        }
    }
}
