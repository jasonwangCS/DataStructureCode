import java.util.*;
public class Path
{
    public static int dijkstras(String[] edges, String vertices, char start, char end)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        
        for(int i = 0; i < vertices.length(); i++)
        {
            if(vertices.charAt(i) == start)
            {
                nodes.add(new Node(start, 0));
            }
            else {
                nodes.add(new Node(vertices.charAt(i), Integer.MAX_VALUE));
            }
        }
        ArrayList<Node> sorted = new ArrayList<Node>();
        for(int i = 0; i < nodes.size(); i++)
        {
            sorted.add(nodes.get(i));
            System.out.println("pee: " + sorted.get(i).getLocation());
        }
        Collections.sort(sorted);
        Node current;
        int distance = 0;
        //System.out.println(nodes.size());
        while(!sorted.isEmpty())
        {
            System.out.println(nodes.size());
            current = sorted.remove(0);
            if(current.getDistance() == Integer.MAX_VALUE)
            {
                break;
            }
            for(String edge : edges)
            {
                if(edge.indexOf(current.getLocation()) != -1 && edge.charAt(0) == current.getLocation())
                {
                    //System.out.println("current" + current.getDistance());
                    String s = ""+edge.substring(2);
                    int x = Integer.parseInt(s);
                    int tmpD = current.getDistance() + x;
                    char tmpN = edge.charAt(1);
                    System.out.println("tmpD: " + tmpD + ", tmpN: " + tmpN);
                    for(int i = 0; i < sorted.size(); i++)
                    {
                        if(sorted.get(i).getLocation() == tmpN)
                        {
                            tmpD = Math.min(sorted.get(i).getDistance(), tmpD);
                            sorted.get(i).setDistance(tmpD);
                            for(int j = 0; j < nodes.size(); j++)
                            {
                                if(nodes.get(j).getLocation() == tmpN)
                                {
                                    nodes.get(j).setDistance(tmpD);
                                }
                            }
                            break;
                        }
                    }
                }
            }
            Collections.sort(sorted);
        }
        System.out.println(nodes.size());
        for(int j = 0; j < nodes.size(); j++)
        {
            System.out.println("wee: " + nodes.get(j).getLocation());
            if(nodes.get(j).getLocation() == end)
            {
                System.out.println(nodes.get(j).getLocation() + ", " + nodes.get(j).getDistance());
                if(nodes.get(j).getDistance() != Integer.MAX_VALUE)
                {
                    return nodes.get(j).getDistance();
                }
                else {
                    return -1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String [] edges = {"AD3","BC6","CE7","DA1","EB5","EC4","FE10"};
        int ret = dijkstras(edges, "ADBCEF", 'D', 'A');
        System.out.println(ret);
    }
     
}