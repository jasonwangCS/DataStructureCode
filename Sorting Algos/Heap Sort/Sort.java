public class Sort
{
    public static void heapSort(int [] data)
    {
        MinHeap<Integer> peepee = new MinHeap<Integer>();
        for(int i = 0; i < data.length; i++)
        {
            peepee.insert(data[i]);
        }
        for(int i = 0; i < data.length; i++)
        {
            data[i] = peepee.remove();
        }
    }
}