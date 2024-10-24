public class Path
{
    public static String breadthFirstSearch(String[] edges, String vertices, char start, char end)
    {
        MyQueue<String> queue = new MyQueue<String>();
        String tmp = String.valueOf(start);
        String visited = "";
        queue.offer(tmp);
        while(!queue.isEmpty())
        {
            //System.out.println("pee");
            String curr = queue.poll();
            System.out.println(queue.isEmpty());
            visited += curr;
            char lastIndex = curr.charAt(curr.length() -1);
            //maybe add last index to visited instead of curr
            for(String edge : edges)
            {
                //System.out.println("edge: " + edge);
                if(edge.indexOf(lastIndex) != -1)//includes last index
                {
                    System.out.println("edge: " + edge);
                    System.out.println(queue.isEmpty());
                    if(edge.charAt(1) == lastIndex)
                    {
                        System.out.println("POOP");
                        if(visited.indexOf(edge.charAt(0)) == -1)
                        {
                            System.out.println("CURR: " + curr);
                            String tmpAdd = curr + edge.charAt(0);
                            if(tmpAdd.charAt(tmpAdd.length()-1) == end)
                            {
                                return tmpAdd;
                            }
                            System.out.println("TMPADD: " + tmpAdd);
                            queue.offer(tmpAdd);
                            //System.out.println("tmpAdd = " + tmpAdd);
                        }
                    }
                    else if(edge.charAt(0) == lastIndex)
                    {
                        System.out.println("PEE");
                        if(visited.indexOf(edge.charAt(1)) == -1)
                        {
                            String tmpAdd = curr + edge.charAt(1);
                            if(tmpAdd.charAt(tmpAdd.length()-1) == end)
                            {
                                return tmpAdd;
                            }
                            System.out.println("TMPADD: " + tmpAdd);
                            queue.offer(tmpAdd);
                            //System.out.println("tmpAdd = " + tmpAdd);
                        }
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String [] edges = {"HA", "BF", "FG", "DA", "DG", "GC", "DH", "EF"};
        String ret = breadthFirstSearch(edges, "ABCDEFG", 'A', 'B');
        System.out.println(ret);
    }
    
}