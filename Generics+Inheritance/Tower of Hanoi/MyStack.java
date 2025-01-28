import java.util.*;
public class MyStack <E> implements StackInterface <E>
{
	private ArrayList <E> data;

    public MyStack()
    {
        data = new ArrayList <E>();
    }

	public E peek()
	{
		if(data.size()==0)
			return null;
		else
			return data.get(data.size()-1);
	}

    public int size()
    {
        return data.size();
    }
    public boolean isEmpty()
    {
        if(data.size() == 0)
            return true;
        return false;
    }
    public E get(int x)
    {
        return data.get(x);
    }
    public void push(E o)
    {
        data.add(o);
    }
    public E pop()
    {
        return data.remove(data.size()-1);
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