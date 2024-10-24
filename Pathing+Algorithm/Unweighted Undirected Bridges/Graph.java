import java.util.*;
public class Graph
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
            //System.out.println(queue.isEmpty());
            visited += curr;
            char lastIndex = curr.charAt(curr.length() -1);
            //maybe add last index to visited instead of curr
            for(String edge : edges)
            {
                //System.out.println("edge: " + edge);
                //System.out.println("edges length : " + edges.length);
                //System.out.println(edge);
                //System.out.println(lastIndex);
                if(edge == null)
                {
                    continue;
                }
                if(edge.indexOf(lastIndex) != -1)//includes last index
                {
                    //System.out.println("edge: " + edge);
                    //System.out.println(queue.isEmpty());
                    if(edge.charAt(1) == lastIndex)
                    {
                        //System.out.println("POOP");
                        if(visited.indexOf(edge.charAt(0)) == -1)
                        {
                            //System.out.println("CURR: " + curr);
                            String tmpAdd = curr + edge.charAt(0);
                            if(tmpAdd.charAt(tmpAdd.length()-1) == end)
                            {
                                return tmpAdd;
                            }
                            //System.out.println("TMPADD: " + tmpAdd);
                            queue.offer(tmpAdd);
                            //System.out.println("tmpAdd = " + tmpAdd);
                        }
                    }
                    else if(edge.charAt(0) == lastIndex)
                    {
                        //System.out.println("PEE");
                        if(visited.indexOf(edge.charAt(1)) == -1)
                        {
                            String tmpAdd = curr + edge.charAt(1);
                            if(tmpAdd.charAt(tmpAdd.length()-1) == end)
                            {
                                return tmpAdd;
                            }
                            //System.out.println("TMPADD: " + tmpAdd);
                            queue.offer(tmpAdd);
                            //System.out.println("tmpAdd = " + tmpAdd);
                        }
                    }
                }
            }
        }
        return null;
    }
    public static ArrayList<String> bridges(String [] edges, String vertices)
    {
        ArrayList<String> out = new ArrayList<String>();
        for(int i = 0; i < edges.length; i++)
        {
            // edge i is tmp removed
            String [] lol = new String[edges.length];
            for(int w = 0; w < edges.length; w++)
            {
                lol[w] = edges[w];
            }
            lol[i] = null;
            String [] tmpEdges = new String[lol.length-1];
            int index = 0;
            for(int j = 0; j < lol.length; j++)
            {
                if(lol[j] == null)
                {
                    continue;
                }
                else {
                    tmpEdges[index] = lol[j];
                    index++;
                }
            }
            for(int wee = 1; wee < vertices.length(); wee++)
            {
                if(breadthFirstSearch(tmpEdges, vertices, vertices.charAt(0), vertices.charAt(wee)) == null)
                {
                    out.add(edges[i]);
                    break;
                }
            }
        }
        if(out.isEmpty() == true)
        {
            return null;
        }
        else {
            return out;
        }
    }
    public static void main(String[] args) {
        String [] edges = {"FD", "BD", "FA", "CE", "BF"};
        String vertices = "FDBACE";
        ArrayList<String> lol = bridges(edges, vertices);
        if(lol == null)
        {
            //System.out.println("NULL");
        }
        else {
            //System.out.println(lol.size());
            for(int i = 0 ; i < lol.size(); i++)
            {
                System.out.println(lol.get(i));
            }
        }
        

    }
    
}