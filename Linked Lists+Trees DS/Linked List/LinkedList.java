public class LinkedList<E> implements LinkedListInterface<E>
{
    private LLNode<E> first;
    private LLNode<E> last;

    public LinkedList()
    {
        first = null;
        last = null;
    }
    public LinkedList(E data)
    {
        LLNode<E> tmp = new LLNode<E>(data);
        first = tmp;
        last = tmp;
    }
    public LLNode<E> getFirstNode()
    {
        return first;
    }
	public LLNode<E> getLastNode()
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
        LLNode<E> tmp = new LLNode<E>(data);
        LLNode<E> tmptmp = first;
        if(first == null){
            first = tmp;
            last = tmp;
        }else{
            first = tmp;
            first.setNext(tmptmp);
        }  
        // LLNode<E> oldFirst = first;
        // first.setData(oldFirst.getData());
        // first.setNext(first);
    }
    public void addLast(E data)
    {
        // LLNode<E> hold = first;
        // while(hold.getNext() != null)
        // {
        //     hold = hold.getNext();
        // }
        // hold.setNext(last);
        // last.setData(data);
        // last.setNext(null);   
        LLNode<E> tmp = new LLNode<E>(data);
        if(first == null){
            first = tmp;
            last = tmp;
        }else{
            last.setNext(tmp);
            last = tmp;
            // LLNode<E> newNode = new LLNode<E>(data);
            // LLNode<E> hold = first;
            // while(hold.getNext() != null){
            //     hold = hold.getNext();
            // }
            // hold.setNext(newNode);
        }         
    }
    public E removeFirst()
    {
        if(first == null)
            return null;
        LLNode<E> pee = first.getNext();
        E tmp = first.getData();
        if(pee == null)
        {
            first = null;
            last = null;
            return tmp;
        }
        first = pee;
        return tmp;
        // else {
        //     E data = first.getData();
        //     LLNode<E> tmp = first.getNext();
        //     first = tmp;
        //     return data;
        // }
    }
	public E removeLast()
    {
        if(last == null || first == null)
            return null;
        E tmp = last.getData();
        LLNode<E> pee = first;
        if(first.getNext() == null)
        {
            first = null;
            last = null;
            return tmp;
        }

        while(pee!= null && pee.getNext().getNext() != null)
        {
            pee = pee.getNext();
        }
        last = pee;
        last.setNext(null);
        return tmp;
        // else if(size() == 1)
        // {
        //     E tmp = last.getData();
        //     clear();
        //     return tmp;
        // }
        // else {
        //     LLNode<E> hold = first;
        //     for(int i = 0; i < size()-2; i++)
        //     {
        //         hold = hold.getNext();
        //     }
        //     LLNode<E> tmpLast = hold.getNext();
        //     E tmp = tmpLast.getData();
        //     last = hold;
        //     last.setNext(null);
        //     return tmp;
        // }
    }
    public void clear()
    {
        first = null;
        last = null;
    }
	public int size()
    {
        if(first == null)
        {
            return 0;
        }
        int count = 1;
        LLNode<E> hold = first;
        while(hold != null && hold.getNext() != null)
        {
            hold = hold.getNext();
            count++;
        }
        return count;
    }
    public E get(int x)
    {
        int lol = 0;
        LLNode<E> hold = first;
        if(hold != null && x == 0)
            return hold.getData();
        while(hold != null)
        {
            if(lol == x)
                return hold.getData();
            lol++;
            hold = hold.getNext();
        }
        return null;
    }
    public void add(int x, E data)
    {
        LLNode<E> pre = first;
        LLNode<E> tmp = new LLNode<E>(data);
        LLNode<E> hold = null;
        boolean wee = false;
        int b = 0;
        if(x==0)
        {
            addFirst(data);
            return;
        }
        else if(x == size())
        {
            addLast(data);
            return;
        }
        while(pre != null && pre.getNext()!= null)
        {
            if(b == x-1)
            {
                hold = pre.getNext();
                pre.setNext(tmp);
                tmp.setNext(hold);
                break;
            }
            b++;
            pre = pre.getNext();
        }
        // LLNode<E> hold = first;
        // for(int i = 0; i < x; i++)
        // {
        //     hold = hold.getNext();
        // }
        // LLNode<E> tmp = new LLNode<E>(data);
        // tmp.setNext(hold.getNext());
    }
    public E remove(int x)
    {
        int a = 0;
        boolean found = false;
        LLNode <E> test = first;
        LLNode <E> ret = null;
        if(test == null){
        return null;
        }
        if(x==0){
        return removeFirst();
        }
        else if(x==size()){
        return removeLast();
        }
        while(test!=null && test.getNext()!=null){
        if(a==x-1){
            ret = test.getNext();
            found = true;
            test.setNext(ret.getNext());
            if(ret.getNext()==null){
            last=test;
            }
            break;
        }
        a++;
        test = test.getNext();
        }
        if(!found)
            return null;
        return ret.getData();

        // if(size() <= x)
        //     return null;
        // else 
        // {
        //     LLNode<E> hold = first;
        //     for(int i = 0; i < x; i++)
        //     {
        //         hold = hold.getNext();
        //     }
        //     LLNode<E> tmp = hold.getNext();
        //     E data = tmp.getData();
        //     hold.setNext(tmp.getNext());
        //     return data;
        // }
    }
    public E set(int x, E data)
    {
        int b = 0;
        LLNode <E> prev = first;
        E prevData = null;
        while(prev!=null){     
            if(x==b){
            prevData = prev.getData();
            prev.setData(data);
            break;
            }
            prev = prev.getNext();
            b++;
        }
        return prevData;

        // LLNode<E> hold = first;
        // for(int i = 0; i < x; i++)
        // {
        //     hold = hold.getNext();
        // }
        // E tmp = hold.getData();
        // hold.setData(data);
        // return tmp;
    }
    public boolean isEmpty()
    {
        if(first == null)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        
        System.out.println("poop");
        String retStr = "[";

        if(first == null)
        {
            return "[]";
        }

        LLNode<E> hold = first;
        while(hold != null){
            retStr += hold.getData();
            System.out.println(hold.getData());
            if(hold.getNext() != null)
            {
                System.out.println("pee");
                retStr += ", ";
            }
            hold = hold.getNext();

        }
        retStr += "]";

        return retStr;
    }
}