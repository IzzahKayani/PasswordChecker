/*import java.util.ArrayList;

public class SequentialSearch<Key extends Comparable<Key>, Value>
{
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs
    private int comparisons = 0;

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    //Initializes an empty symbol table.
    public SequentialSearch()
    {}

    //Returns the number of key-value pairs in this symbol table.
    public int size()
    {return n;}

    public int getComparisons()
    {return comparisons;}

    public void resetComparisons()
    {comparisons = 0;}

    //Returns true if this symbol table is empty.
    public boolean isEmpty()
    {return size() == 0;}

    //Returns true if this symbol table contains the specified key.
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    //Returns the value associated with the given key in this symbol table.

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next)
        {
            comparisons++;
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null)
        {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
            {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        ArrayList<Key> list = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next)
        {
            list.add(x.key);
        }
        return list;
    }
}

 */

public class HashTypes
{

}

