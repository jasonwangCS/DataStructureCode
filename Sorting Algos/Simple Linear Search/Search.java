public class Search
{
    public static int linearSearch(int [] list, int value)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == value)
                return i;
        }
        return -1;
    }
}