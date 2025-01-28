public class Sorts
{
    static int[] tempData;

	public static void heapSort(int[] data)
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

	public static void selectionSort(int[] list)
	{
		for(int a = 0; a < list.length; a++)
        {
            int minIndex = a;
            for(int b = a+1; b < list.length; b++)
            {
                if(list[b] < list[minIndex])
                    minIndex = b;
            }
            swap(list, minIndex, a);
        }
	}

	public static void insertionSort(int[] list)
	{
		for(int i = 1; i < list.length; i++)
        {
            int temp = list[i];
            int j = i;
            while(j > 0 && list[j-1] > temp)
            {
                list[j] = list[j-1];
                j--;
                list[j] = temp;
            }
        }
	}

	public static void quickSort(int[] data, int from, int to)
	{
		if(from >= to)
            return;
        int p = (from + to)/2;
        int i = from;
        int j = to;

        while(i <= j)
        {
            if(data[i] <= data[p])
                i++;
            else if(data[j] >= data[p])
                j--;
            else {
                swap(data, i, j);
                i++;
                j--;
            }
        }
        if(p < j)
        {
            swap(data, j, p);
            p = j;
        }
        else if(p > i)
        {
            swap(data, i, p);
            p = i;
        }
        quickSort(data, from, p-1);
        quickSort(data, p+1, to);
	}

	public static void mergeSort(int[] data, int from, int to)
	{
		if(tempData == null || tempData.length != data.length)
            tempData = new int[data.length];
        
        if(to == from)
            return;
        int middle = (from + to)/2;
        mergeSort(data, from , middle);
        mergeSort(data, middle+1, to);

        int i = from;
        int j = middle + 1;
        int k = from;

        while(i <= middle && j <= to)
        {
            if(data[i] < data[j])
                tempData[k++] = data[i++];
            else {
                tempData[k++] = data[j++];
            }
        }
        while(i <= middle)
            tempData[k++] = data[i++];
        while(j <= to)
            tempData[k++] = data[j++];
        for(k = from; k <= to; k++)
        {
            data[k] = tempData[k];
        }
	}
	
	public static void swap(int[] data, int spot1, int spot2)
	{
		int temp 	= data[spot1];
		data[spot1]	= data[spot2];
		data[spot2]	= temp;
	}
}