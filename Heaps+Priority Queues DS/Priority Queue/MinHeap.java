import java.util.*;
public class MinHeap<E extends Comparable<E>> implements HeapInterface<E>
{
    private ArrayList<E> heap;

    public MinHeap()
    {
        heap = new ArrayList<E>();
    }
    public boolean insert(E item)
    {
        heap.add(item);
        if(size() == 1)
        {
            return true;
        }
        int index = heap.size() - 1;
        int parentIndex = (index-1)/2;
        while(parentIndex >= 0 && index > 0)//not root
        {
            System.out.println("run");
            parentIndex = (index-1)/2;
            int result = heap.get(index).compareTo(heap.get(parentIndex));
            System.out.println(heap.get(index));
            System.out.println(heap.get(parentIndex));
            
            System.out.println(result);
            if(result < 0)
            {
                System.out.println("swap");
                //swap
                E tmp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, tmp);
            }
            index = parentIndex;
            parentIndex = (index-1)/2;

        }
        return true;
    }
    public String toString()
    {
        if(heap.size() == 0)
            return "[]";
        String retStr = "[";
        for(int i = 0; i < heap.size()-1; i++)
        {
            retStr += heap.get(i) + ", ";
        }
        retStr += heap.get(heap.size()-1) + "]";
        return retStr;        
    }
	public E remove()
    {
        if(size() == 0)
            return null;
        if(size() == 1)
        {
            return heap.remove(0);
        }
        E lastElement = heap.get(size()-1);
        E ret = heap.get(0);
        //swap
        heap.set(0, lastElement);
        heap.remove(size()-1);

        int largest = 0;
        int l = 2*0+1;
        int r = 2*0+2;
        int tmpRoot = largest;
        do
        {
            if(l < heap.size())
            {
                int result = heap.get(l).compareTo(heap.get(largest));
                if(result < 0)
                {
                    System.out.println("swap left " + heap.get(l) + heap.get(largest));
                    largest = l;
                }
                
            }
            if(r < heap.size())
            {
                int result = heap.get(r).compareTo(heap.get(largest));
                if(result < 0)
                {
                    System.out.println("swap right "+ heap.get(r) + heap.get(largest));
                    largest = r;
                }
               
            }
            if(largest != tmpRoot)
            {
                E tmp = heap.get(largest);
                heap.set(largest, heap.get(tmpRoot));
                heap.set(tmpRoot, tmp);
                l = 2*largest+1;
                r = 2*largest+2;
                tmpRoot = largest;
            }
            else {
                largest = 0;
                System.out.println("break");
                break;
            }

        }while(largest != 0);
        return ret;
    }
	public boolean isEmpty()
    {
        if(size() == 0)
            return true;
        return false;
    }
	public int size()
    {
        return heap.size();
    }
	public E get(int x)
    {
        return heap.get(x);
    }
	public void clear()
    {
        heap.clear();
    }

}