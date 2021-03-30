package com.bilqu.ds;

import java.util.Objects;

public class BilquMap<K,V>{

    private static final int DEFAULT_SIZE = 16;

    private int size ;
    private Entry<K,V>[] bucket;


    public BilquMap(){
        this(DEFAULT_SIZE);
    }

    public BilquMap(int size){
        this.size = size;
        this.bucket = new Entry[this.size];
    }


    public V get(K key){
        //Compute Hash
        int keyHash = key.hashCode() % size;

        //Get the respective bucket
        Entry<K,V> entry = bucket[keyHash];

        //validate key equality
        while(entry.next != null) {
            if (key.equals(entry.key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public void  put(K key,V value){
        if(contains(key)){


        }

    }

    public boolean contains(K key){
        //Compute Hash
        int keyHash = key.hashCode() % size;

        //Get the respective bucket
        Entry<K,V> entry = bucket[keyHash];

        //validate key equality
        while(entry.next != null) {
            if (key.equals(entry.key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public class Entry<K,V>{
        private final K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value= value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Entry<?, ?> entry = (Entry<?, ?>) o;
//            return Objects.equals(key, entry.key);
//        }
//
//        @Override
//        public int hashCode() {
//            return 13*Objects.hash(key);
//        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
