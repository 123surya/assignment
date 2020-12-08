package com.datastore.repository;

public class CustomHashMap<K,V> {

    private Entry<K, V>[] table;
    private int capacity = 10;

    static class Entry<K , V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        table = new Entry[capacity];
    }

    public void put(K newKey, V data) {

        if(newKey == null) {
            return;
        }

        int hash = hash(newKey);

        Entry<K,V> newEntry = new Entry<K,V>(newKey, data);

        if(table[hash] == null) {
            // put table[hash] newenrty
        } else {
            Entry<K,V> prev = null;
            Entry<K,V> curr = table[hash];

            while(curr != null) {
                if(curr.key.equals(newKey)) {
                    if(prev == null) {
                        newEntry.next = curr.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = curr.next;
                        prev.next = newEntry;
                        return;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if(table[hash] == null) {
            return null;
        } else {
            Entry<K,V> temp = table[hash];
            while(temp!=null) {
                if(temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int hash = hash(key);
        if(table[hash] == null) {
            return false;
        } else{
            Entry<K,V> prev = null;
            Entry<K,V> curr = table[hash];
            while(curr!=null) {
                if(curr.key.equals(key)) {
                    if(prev == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        prev.next = curr.next;
                        return true;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return false;

    }

    public int hash(K key) {
        return key.hashCode() % capacity;
    }

}

