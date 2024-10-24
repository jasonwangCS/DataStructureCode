import java.util.*;
import java.awt.*;

public class Graph
{
    public static String[] stronglyConnectedRegions(String[] edges, String vertices)
    {
        ArrayList<String> out = new ArrayList<String>();
        for(int i = 0; i < vertices.length(); i++)
        {
            char parentChar = vertices.charAt(i);
            String tmpResult = "" + parentChar;
            for(int j = i+1; j < vertices.length(); j++)
            {
                //System.out.println(vertices.charAt(i) + "" + vertices.charAt(j));
                if(bfs(edges, vertices, parentChar, vertices.charAt(j)) && bfs(edges, vertices, vertices.charAt(j), parentChar))
                {
                    //validdd
                    tmpResult += vertices.charAt(j);
                }
            }
            if(tmpResult.length() > 1)
            {
                if(!checkExists(out, tmpResult))
                    out.add(tmpResult);
            }
        }
        
        //done
        if(out.isEmpty())
            return null;
        String [] ret = new String[out.size()];
        for(int i = 0; i < out.size(); i++)
        {
            System.out.println(out.get(i));
            ret[i] = out.get(i);
        }
        
        return ret;
    }
    public static boolean checkExists(ArrayList<String> results, String tmpResult)
    {
        for(String wee : results)
        {
            for(int i  = 0; i < tmpResult.length(); i++)
            {
                if(wee.indexOf(tmpResult.charAt(i)) != -1)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean bfs(String[] edges, String vertices, char start, char end)
    {
        ArrayList<String> queue = new ArrayList<String>();
        String tmp = String.valueOf(start);
        String visited = "";
        queue.add(tmp);
        while(!queue.isEmpty())
        {
            String curr = queue.remove(0);
            visited += curr;
            char lastIndex = curr.charAt(curr.length() -1);
            for(String edge : edges)
            {
                if(edge.indexOf(lastIndex) != -1)//includes last index
                {
                    if(edge.charAt(0) == lastIndex)
                    {
                        if(visited.indexOf(edge.charAt(1)) == -1)
                        {
                            String tmpAdd = curr + edge.charAt(1);
                            if(tmpAdd.charAt(tmpAdd.length()-1) == end)
                            {
                                return true;
                            }
                            queue.add(tmpAdd);
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String [] edges = {"AD","AC","BE","BF","CD","CS","DG","DB","EF","FB","GC","SA","SB"};
        String vertices = "ABCDEFGS";
        
        stronglyConnectedRegions(edges, vertices);


    }
    
}