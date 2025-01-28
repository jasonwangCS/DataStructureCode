public class DoublyCircularLinkedList<E> implements DoublyCircularLinkedListInterface<E>
{
    private DLLNode<E> first;
    private DLLNode<E> last;

    public DoublyCircularLinkedList()
    {
        first = null;
        last = null;
    }
    public DoublyCircularLinkedList(E data)
    {
        DLLNode<E> tmp = new DLLNode<E>(data);
        first = tmp;
        last = tmp;
        first.setNext(last);
        first.setPrev(last);
        last.setNext(first);
        last.setPrev(first);
    }
    public DLLNode<E> getFirstNode()
    {
        return first;
    }
	public DLLNode<E> getLastNode()
    {
        return last;
    }
    public E getFirst()
    {
        if(first == null)
            return null;
        return first.getData();
    }
    public E getLast()
    {
        if(last == null)
            return null;
        return last.getData();
    }
    public void addFirst(E data)
    {
        DLLNode<E> tmp = new DLLNode<E>(data);
        DLLNode<E> tmptmp = first;
        if(first == null)
        {
            first = tmp;
            last = tmp;
            first.setNext(last);
            first.setPrev(last);
            last.setNext(first);
            last.setPrev(first);
        }
        else {
            first = tmp;
            first.setNext(tmptmp);
            tmptmp.setPrev(first);
            first.setPrev(last);
            if(tmptmp.getNext() == first)
            {
                last = tmptmp;
                last.setNext(first);
            }
            else {
                last.setNext(first);
            }
            System.out.println(last.getNext().getData());
            System.out.println(first.getData());
            System.out.println("hi");
        }
    }
    public void addLast(E data)
    {
        DLLNode<E> tmp = new DLLNode<E>(data);
        DLLNode<E> tmptmp = last;
        if(first == null || last == null)
        {
            first = tmp;
            last = tmp;
            first.setNext(last);
            first.setPrev(last);
            last.setNext(first);
            last.setPrev(first);
        }
        else {
            last = tmp;
            last.setNext(first);
            last.setPrev(tmptmp);
            tmptmp.setNext(last);
            first.setPrev(last);

            // tmp.setPrev(last);
            // last.setNext(tmp);
            // last = tmp;
            // last.setNext(first);
            // first.setPrev(last);
            
        }
    }
    public E removeFirst()
    {
        if(first == null)
            return null;
        DLLNode<E> tmp = first.getNext();
        E tmpData = first.getData();
        if(tmp == null || size() == 1)
        {
            first = null;
            last = null;
            return tmpData;
        }
        else if(size() == 2)
        {
            DLLNode<E> tmptmp = new DLLNode<E>(tmp.getData());
            first = tmptmp;
            last = tmptmp;
            return tmpData;
        }
        first = tmp;
        first.setPrev(last);
        last.setNext(first);
        return tmpData;
    }
    public E removeLast()
    {
        if(last == null || first == null)
            return null;
        E tmp = last.getData();
        DLLNode<E> temp = first;
        if(size() == 1)
        {
            first = null;
            last = null;
            return tmp;
        }
        else if(size() == 2)
        {
            DLLNode<E> tmptmp = new DLLNode<E>(temp.getData());
            first = tmptmp;
            last = tmptmp;
            return tmp;
        }
        for(int i = 0; i < size()-2; i++)
        {
            temp = temp.getNext();
        }
        last = temp;
        last.setNext(first);
        first.setPrev(last);
        return tmp;
    }
    public E get(int x)
    {
        int lol = 0;
        DLLNode<E> hold = first;
        if(hold != null && x == 0)
            return hold.getData();
        else if(x == size()-1)
            return last.getData();
        else {
            while(hold != last)
            {
                if(lol == x)
                    return hold.getData();
                lol++;
                hold = hold.getNext();
            }
        }
        return null;
    }
    public void add(int x, E data)
    {
        DLLNode<E> pre = first;
        DLLNode<E> tmp = new DLLNode<E>(data);
        DLLNode<E> hold = null;
        int b = 0;
        if(x == 0)
        {
            addFirst(data);
            return;
        }
        else if (x == size())
        {
            addLast(data);
            return;
        }
        while(pre != null && pre.getNext() != first)
        {
            if(b == x-1)
            {
                hold = pre.getNext();
                pre.setNext(tmp);
                tmp.setNext(hold);
                tmp.setPrev(pre);
                hold.setPrev(tmp);
                break;
            }
            b++;
            pre = pre.getNext();
        }
    }
    public E remove(int x)
    {
        int a = 0;
        boolean found = false;
        DLLNode <E> test = first;
        DLLNode <E> ret = null;
        if(test == null){
        return null;
        }
        if(x==0){
        return removeFirst();
        }
        else if(x==size()-1){
        return removeLast();
        }
        while(test!=null && test.getNext()!=first){
        if(a==x-1){
            ret = test.getNext();
            found = true;
            test.setNext(ret.getNext());
            ret.getNext().setPrev(test);
            if(ret.getNext()==null){
                last=test;
                last.setNext(first);
                first.setPrev(last);
            }
            break;
        }
        a++;
        test = test.getNext();
        }
        if(!found)
            return null;
        return ret.getData();
    }
    public E set(int x, E data)
    {
        DLLNode<E> tmp = first;
        for(int i = 0; i < x; i++)
        {
            tmp = tmp.getNext();
        }
        E tmpData = tmp.getData();
        tmp.setData(data);
        return tmpData;
    }

    public int size()
    {
        int count = 0;
        if (first == null)
            return count;
        else {
            DLLNode<E> temp = first;
            do {
                 if(temp.getNext() == first)
                 {
                     return 1;
                 }
                temp = temp.getNext();
                count++;
            } while (temp != last);
            count++;
        }
        return count;
    }
    public void clear()
    {
        first = null;
        last = null;
    }
    public boolean isEmpty()
    {
        if(size() == 0)
            return true;
        return false;
    }
    public String toString(){
        String retStr = "[";
        if(first == null)
            return "[]";
        DLLNode<E> temp = first;
        retStr += temp.getData();
        if(temp.getNext() != first)
        {
            retStr += ", ";
            do { 
                temp = temp.getNext();
                if(temp == last)
                {
                    retStr += temp.getData();
                }
                else {
                    retStr += temp.getData() + ", ";
                }
            } while (temp != last);
        }
        retStr += "]";
        return retStr;
    }
    public String backwardsToString(){
        String retStr = "[";
        if(last == null)
            return "[]";
        DLLNode<E> temp = last;
        retStr += temp.getData();
        if(temp.getPrev() != first)
        {
            retStr += ", ";
            do { 
                temp = temp.getPrev();
                if(temp == first)
                {
                    retStr += temp.getData();
                }
                else {
                    retStr += temp.getData() + ", ";
                }
            } while (temp != first);
        }
        retStr += "]";
        return retStr;
    }
}