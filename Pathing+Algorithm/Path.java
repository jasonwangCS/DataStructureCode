import java.util.*;
import java.awt.*;
public class Path
{
    public static Solution aStar(char[][] maze)
    {
        ArrayList<Node> open = new ArrayList<Node>();
        ArrayList<Node> closed = new ArrayList<Node>();

        int Erow = -1; 
        int Ecol = -1;
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                if(maze[i][j] == 'E')
                {
                    Erow = i;
                    Ecol = j;
                    break;
                }
            }
        }
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                if(maze[i][j] == 'S')
                {
                    //calculate est H;
                    int tmpH = Math.abs(Erow-i) + Math.abs(Ecol-j);
                    open.add(new Node(new Point(j, i), null, 0, tmpH));
                    System.out.println("tmpH: " + tmpH);
                    break;
                }
            }
        }
        //Collections.sort(open);
        Node out = null;
        while(!open.isEmpty())
        {
            System.out.println("size = " + open.size());
            //find node w lowest f val, if tied then lowest h val
            Node current = open.remove(0);
            if(current.getH() == 0)
            {
                out = current;
                break;
            }
            closed.add(current);

            int row = (int)current.getLocation().getY();
            int col = (int)current.getLocation().getX();
            //check right;
            if(col + 1 < maze[0].length)
            {
                System.out.println("check right");
                char tmpChar = maze[row][col+1];
                if(tmpChar == '-'|| tmpChar == 'E')
                {
                    //check closed if there alr is maze[row][col+1];
                    boolean isNodeInClosed = false;
                    for(Node wee : closed)
                    {
                        if(wee.getLocation().getX() == (col+1) && wee.getLocation().getY() == row)
                        {
                            isNodeInClosed = true;
                            break;
                        }
                    }
                    if(isNodeInClosed == false)
                    {
                        //check open if there alr is maze[row][col+1];
                        boolean isNodeInOpen = false;
                        Node s = null;
                        for(Node wee : open)
                        {
                            if(wee.getLocation().getX() == (col+1) && wee.getLocation().getY() == row)
                            {
                                isNodeInOpen = true;
                                s = wee;
                                break;
                            }
                        }
                        if(isNodeInOpen)
                        {
                            if(current.getG()+1 < s.getG())
                            {
                                System.out.println("alr in open bruh");
                                s.setG(current.getG()+1);
                                s.fixF();
                            }
                        }
                        else {
                            System.out.println("new node bruh");
                            int tmpH = Math.abs(Erow-(row)) + Math.abs(Ecol-(col+1));
                            System.out.println("new tmpH: " + tmpH);
                            
                            s = new Node(new Point(col+1, row), current, current.getG() + 1, tmpH);
                            System.out.println(s.getLocation());
                            System.out.println("G: " + s.getG() + ",H: " + s.getH() + ", F: " + s.getF());
                            open.add(s);
                        }
                    }
                }
            }
            //check down
            if(row + 1 < maze.length)
            {
                System.out.println("check down");
                char tmpChar = maze[row+1][col];
                if(tmpChar == '-' || tmpChar == 'E')
                {
                    //check closed if there alr is maze[row][col+1];
                    boolean isNodeInClosed = false;
                    for(Node wee : closed)
                    {
                        if(wee.getLocation().getX() == (col) && wee.getLocation().getY() == (row+1))
                        {
                            isNodeInClosed = true;
                            break;
                        }
                    }
                    if(isNodeInClosed == false)
                    {
                        //check open if there alr is maze[row][col+1];
                        boolean isNodeInOpen = false;
                        Node s = null;
                        for(Node wee : open)
                        {
                            if(wee.getLocation().getX() == (col) && wee.getLocation().getY() == (row+1))
                            {
                                isNodeInOpen = true;
                                s = wee;
                                break;
                            }
                        }
                        if(isNodeInOpen)
                        {
                            if(current.getG()+1 < s.getG())
                            {
                                System.out.println("alr in open bruh");
                                s.setG(current.getG()+1);
                                s.fixF();
                            }
                        }
                        else {
                            System.out.println("new node bruh");
                            int tmpH = Math.abs(Erow-(row+1)) + Math.abs(Ecol-(col));
                            System.out.println("new tmpH: " + tmpH);
                            
                            s = new Node(new Point(col, row+1), current, current.getG() + 1, tmpH);
                            System.out.println(s.getLocation());
                            System.out.println("G: " + s.getG() + ",H: " + s.getH() + ", F: " + s.getF());
                            open.add(s);
                        }
                    }
                }
            }
            //check up
            if(row - 1 >= 0)
            {
                System.out.println("check down");
                char tmpChar = maze[row-1][col];
                if(tmpChar == '-'|| tmpChar == 'E')
                {
                    //check closed if there alr is maze[row][col+1];
                    boolean isNodeInClosed = false;
                    for(Node wee : closed)
                    {
                        if(wee.getLocation().getX() == (col) && wee.getLocation().getY() == (row-1))
                        {
                            isNodeInClosed = true;
                            break;
                        }
                    }
                    if(isNodeInClosed == false)
                    {
                        //check open if there alr is maze[row][col+1];
                        boolean isNodeInOpen = false;
                        Node s = null;
                        for(Node wee : open)
                        {
                            if(wee.getLocation().getX() == (col) && wee.getLocation().getY() == (row-1))
                            {
                                isNodeInOpen = true;
                                s = wee;
                                break;
                            }
                        }
                        if(isNodeInOpen)
                        {
                            if(current.getG()+1 < s.getG())
                            {
                                System.out.println("alr in open bruh");
                                s.setG(current.getG()+1);
                                s.fixF();
                            }
                        }
                        else {
                            System.out.println("new node bruh");
                            int tmpH = Math.abs(Erow-(row-1)) + Math.abs(Ecol-(col));
                            System.out.println("new tmpH: " + tmpH);
                            
                            s = new Node(new Point(col, row-1), current, current.getG() + 1, tmpH);
                            System.out.println(s.getLocation());
                            System.out.println("G: " + s.getG() + ",H: " + s.getH() + ", F: " + s.getF());
                            open.add(s);
                        }
                    }
                }
            }
            //check left;
            if(col - 1 >=0)
            {
                System.out.println("check left");
                char tmpChar = maze[row][col-1];
                if(tmpChar == '-'|| tmpChar == 'E')
                {
                    //check closed if there alr is maze[row][col+1];
                    boolean isNodeInClosed = false;
                    for(Node wee : closed)
                    {
                        if(wee.getLocation().getX() == (col-1) && wee.getLocation().getY() == row)
                        {
                            isNodeInClosed = true;
                            break;
                        }
                    }
                    if(isNodeInClosed == false)
                    {
                        //check open if there alr is maze[row][col+1];
                        boolean isNodeInOpen = false;
                        Node s = null;
                        for(Node wee : open)
                        {
                            if(wee.getLocation().getX() == (col-1) && wee.getLocation().getY() == row)
                            {
                                isNodeInOpen = true;
                                s = wee;
                                break;
                            }
                        }
                        if(isNodeInOpen)
                        {
                            if(current.getG()+1 < s.getG())
                            {
                                System.out.println("alr in open bruh");
                                s.setG(current.getG()+1);
                                s.fixF();
                            }
                        }
                        else {
                            System.out.println("new node bruh");
                            int tmpH = Math.abs(Erow-(row)) + Math.abs(Ecol-(col-1));
                            System.out.println("new tmpH: " + tmpH);
                            
                            s = new Node(new Point(col-1, row), current, current.getG() + 1, tmpH);
                            System.out.println(s.getLocation());
                            System.out.println("G: " + s.getG() + ",H: " + s.getH() + ", F: " + s.getF());
                            open.add(s);
                        }
                    }
                }
            }
        }
        if(out == null)
        {
            return null;
        }
        else {
            //return winning path and distance;
            ArrayList<Point> path = new ArrayList<Point>();
            int tmpG = out.getG();
            if(out.getParent() == null)
            {
                path.add(out.getLocation());
            }
            else {
                
                while(out.getParent() != null)
                {
                    path.add(out.getLocation());
                    out = out.getParent();
                }
                path.add(out.getLocation());
            }
            
            Collections.reverse(path);
            for(int i = 0; i < path.size(); i++)
            {
                System.out.println(path.get(i));
            }
            
            Solution lol = new Solution(path, tmpG);
            return lol;
        }
    }
    public static void main(String[] args) {
        // char [][] maze = {{'-', 'S', 'W', '-', '-', '-', '-', '-', 'W', '-', 'W'},
        //                     {'W', '-', 'W', '-', '-', 'W', 'W', '-', '-', 'W', 'W'},
        //                     {'W', '-', 'W', '-', '-', 'W', '-', '-', 'W', '-', 'W'},
        //                     {'W', '-', '-', '-', 'W', 'E', '-', '-', 'W', '-', '-'},
        //                     {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}};
         char [][] maze = {{'S', 'E', 'W'}};
        
        System.out.println(aStar(maze).getSteps());
    }
    
}