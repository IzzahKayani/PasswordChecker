public class HashTypes
{
    public static int oldHash(String str, int m)
    {
        int hash = 0;
        int skip = Math.max(1, str.length() / 8);
        for (int i = 0; i < str.length(); i += skip)
        {hash = (hash * 37 + str.charAt(i));}
        return (hash & 0x7fffffff) % m;
    }

    public static int newHash(String str, int m)
    {
        int hash = 0;
        for (int i = 0; i < str.length(); i++)
        {hash = (hash * 31 + str.charAt(i));}
        return (hash & 0x7fffffff) % m;
    }
}

