import java.util.LinkedList;
public class SeparateChaining
{
    private LinkedList<String>[] list;
    private int m;
    private Hash hashFunction;
    private int comparisons;

    public SeparateChaining(int m, Hash hashFunction)
    {
        this.m = m;
        this.hashFunction = hashFunction;
        this.list = new LinkedList[m];
        for(int i = 0; i < m; i++)
            list[i] = new LinkedList<>();
    }

    public int getComparisons()
    {return comparisons;}

    public void put(String key)
    {
        int index = hashFunction.hash(key, m);
        list[index].add(key);
    }
    public boolean contains(String key)
    {
        comparisons = 0;
        int index = hashFunction.hash(key, m);
        for(String word: list[index])
        {
            comparisons++;
            if(word.equals(key))
                return true;
        }
        return false;
    }
}