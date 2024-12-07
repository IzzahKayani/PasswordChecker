public class LinearProbing
{
    private String[] list;
    private int m;
    private Hash hashFunction;
    private int comparisons;

    public LinearProbing(int m, Hash hashFunction)
    {
        this.m = m;
        this.hashFunction = hashFunction;
        this.list = new String[m];
    }

    public int getComparisons()
    {return comparisons;}

    public void put(String key)
    {
        int index = hashFunction.hash(key,m);
        while(list[index]!= null)
        {index = (index + 1) % m;}
        list[index] = key;
    }

    public boolean contains(String key)
    {
        comparisons = 0;
        int index = hashFunction.hash(key,m);
        while(list[index]!= null)
        {
            comparisons++;
            if(list[index].equals(key))
                return true;
            index = (index + 1) % m;
        }
        return false;
    }

}