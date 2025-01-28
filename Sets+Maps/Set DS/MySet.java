import java.util.*;
public class MySet<E> implements SetInterface <E>
{
    private ArrayList<E> data;

    public MySet()
    {
        data = new ArrayList<E>();
    }
    public boolean add(E o)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i) == o)
                return false;
        }
        data.add(o);
        return true;
    }
	public void clear()
    {
        data.clear();
    }
	public boolean contains(E o)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i) == o)
                return true;
        }
        return false;
    }
	public boolean isEmpty()
    {
        if(data.size() == 0)
            return true;
        return false;
    }
	public Iterator<E> iterator()
    {
        return data.iterator();
    }
	public boolean remove(E o)
    {
        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i) == o)
            {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
	public int size()
    {
        return data.size();
    }
}