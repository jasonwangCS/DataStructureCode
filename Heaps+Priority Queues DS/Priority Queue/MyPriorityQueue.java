import java.util.*;
public class MyPriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>
{
    private MinHeap<E> queue;

    public MyPriorityQueue()
    {
        queue = new MinHeap<E>();
    }
    public boolean offer(E o)
    {
        return queue.insert(o);
    }
	public E poll()
    {
        return queue.remove();
    }
	public int size()
    {
        return queue.size();
    }
	public boolean isEmpty()
    {
        return queue.isEmpty();
    }
	public void clear()
    {
        queue.clear();
    }
	public E get(int x)
    {
        return queue.get(x);
    }
    public E element()
    {
        if(size() == 0)
            return null;
        return queue.get(0);
    }
    public String toString()
    {
        return queue.toString();
    }
}