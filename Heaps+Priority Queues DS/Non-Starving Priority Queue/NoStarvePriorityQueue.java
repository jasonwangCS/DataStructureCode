public class NoStarvePriorityQueue<E> extends MyPriorityQueue<PriorityNode<E>>
{
    public PriorityNode<E> poll()
    {
        PriorityNode<E> peepee = super.poll();
        for(int i = 0; i < super.size(); i++)
        {
            super.get(i).setPriority(super.get(i).getPriority()-1);
        }
        return peepee;
        // Add code here
    }
}