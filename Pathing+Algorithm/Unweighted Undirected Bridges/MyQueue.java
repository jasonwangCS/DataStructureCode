import java.util.*;
public class MyQueue <E> implements QueueInterface <E>
{
    private ArrayList<E> data;

    public MyQueue()
    {
        data = new ArrayList<E>();
    }
    public boolean offer(E o)
    {
        data.add(o);
        return true;
    }
	public int size()
    {
        return data.size();
    }
	public E element()
    {
        if(data.size() == 0)
            return null;
        return data.get(0);
    }
	public E get(int x)
    {
        return data.get(x);
    }
	public E poll()
    {
        if(data.size() == 0)
            return null;
        return data.remove(0);
    }
	public boolean isEmpty()
    {
        if(data.size() == 0)
            return true;
        return false;
    }
    public void clear()
    {
        data.clear();
    }
    @Override
    public String toString()
    {
        return data.toString();
    }
}