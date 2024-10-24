import java.util.*;
import java.awt.*;
public class Path
{
    public static int lowestFuel(char [][] grid)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<TerrainCost> travelCosts = new ArrayList<TerrainCost>();
        travelCosts.add(new TerrainCost('S', 0));
        travelCosts.add(new TerrainCost('E', 0));
        travelCosts.add(new TerrainCost('P', 0));
        travelCosts.add(new TerrainCost('O', 1));
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 'S')
                {
                    nodes.add(new Node(new Point(i, j), 0));
                }
                else 
                {
                    nodes.add(new Node(new Point(i, j), Integer.MAX_VALUE));
                }
            }
        }
        ArrayList<Node> sorted = new ArrayList<Node>();
        for(int i = 0; i < nodes.size(); i++)
        {
            sorted.add(nodes.get(i));
            //System.out.println("pee: " + sorted.get(i).getLocation());
        }
        Collections.sort(sorted);
        System.out.println(nodes.get(1));
        System.out.println(sorted.get(1));


        Node current;
        int curDistance;
        int distance = 0;
        //System.out.println(nodes.size());
        while(!sorted.isEmpty())
        {
            System.out.println(nodes.size());
            current = sorted.remove(0);
            int curI = (int)current.getLocation().getX();
            int curJ = (int)current.getLocation().getY();
            if(grid[curI][curJ] == 'I')
            {
                continue;
            }
            System.out.println("current: " + current.getDistance());
            // if(current.getDistance() == Integer.MAX_VALUE)
            // {
            //     break;
            // }
            int row = (int)current.getLocation().getX();
            int col = (int)current.getLocation().getY();
            System.out.println("row: " + row + "col: " + col);

            //left
            if(col - 1 >= 0)
            {
                System.out.println("check left");
                char tmpChar = grid[row][col-1];
                int tmpCost;
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            int moveDist = nodes.get(row * grid[0].length + col-1).getDistance();
                            nodes.get(row * grid[0].length + col-1).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get(row * grid[0].length + col-1) + " to " + nodes.get(row * grid[0].length + col-1).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == row && sorted.get(j).getLocation().getY() == (col-1))
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
            }
            //right
            if(col + 1 < grid[0].length)
            {
                System.out.println("check right");
                char tmpChar = grid[row][col+1];
                System.out.println(tmpChar);
                int tmpCost;
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            int moveDist = nodes.get(row * grid[0].length + col+1).getDistance();
                            nodes.get(row * grid[0].length + col+1).setDistance(Math.min(currentDist+tmpCost, moveDist));
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                System.out.println("row:: " + row + ", col::" + col);
                                if(sorted.get(j).getLocation().getX() == row && sorted.get(j).getLocation().getY() == (col+1))
                                {
                                    //System.out.println(sorted.get(1).getDistance() + "PPP");
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                    System.out.println(sorted.get(j).getLocation() + ", " + sorted.get(j).getDistance());
                                    System.out.println(j);
                                    //System.out.println(sorted.get(1).getDistance());
                                }
                            }
                        }
                    }
                }
            }
            //up
            if(row - 1 >= 0)
            {
                System.out.println("check up");
                char tmpChar = grid[row-1][col];
                int tmpCost;
                System.out.println("out?");
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            int moveDist = nodes.get((row-1) * grid[0].length + col).getDistance();
                            nodes.get((row-1) * grid[0].length + col).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row-1) && sorted.get(j).getLocation().getY() == col)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
                System.out.println("out??");
            }
            //down
            if(row + 1 < grid.length)
            {
                
                //System.out.println("BBB" + sorted.get(1).getLocation() + ", " + sorted.get(1).getDistance());
                System.out.println("check down");
                char tmpChar = grid[row+1][col];
                int tmpCost;
                System.out.println("tmpChar: " + tmpChar);
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    System.out.println(travelCosts.get(i).getType());
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        System.out.println("weee");
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            System.out.println(currentDist);
                            int moveDist = nodes.get((row+1) * grid[0].length + col).getDistance();
                            nodes.get((row+1) * grid[0].length + col).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get((row+1) * grid[0].length + col) + " to " + nodes.get((row+1) * grid[0].length + col).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row+1) && sorted.get(j).getLocation().getY() == col)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
                
                //System.out.println("BBB" + sorted.get(1).getLocation() + ", " + sorted.get(1).getDistance());
            }
            //down right
            if(row + 1 < grid.length && col + 1 < grid[0].length)
            {
                System.out.println("check down right");
                char tmpChar = grid[row+1][col + 1];
                int tmpCost;
                System.out.println("tmpChar: " + tmpChar);
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    System.out.println(travelCosts.get(i).getType());
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        System.out.println("weee");
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            System.out.println(currentDist);
                            int moveDist = nodes.get((row+1) * grid[0].length + col+1).getDistance();
                            nodes.get((row+1) * grid[0].length + col+1).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get((row+1) * grid[0].length + col+1) + " to " + nodes.get((row+1) * grid[0].length + col+1).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row+1) && sorted.get(j).getLocation().getY() == col+1)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
            }
            //down left
            if(row + 1 < grid.length && col - 1 >= 0)
            {
                System.out.println("check down left");
                char tmpChar = grid[row+1][col - 1];
                int tmpCost;
                System.out.println("tmpChar: " + tmpChar);
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    System.out.println(travelCosts.get(i).getType());
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        System.out.println("weee");
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            System.out.println(currentDist);
                            int moveDist = nodes.get((row+1) * grid[0].length + col-1).getDistance();
                            nodes.get((row+1) * grid[0].length + col-1).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get((row+1) * grid[0].length + col-1) + " to " + nodes.get((row+1) * grid[0].length + col-1).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row+1) && sorted.get(j).getLocation().getY() == col-1)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
            }
            //up right
            if(row - 1 >= 0 && col + 1 < grid[0].length)
            {
                System.out.println("check up right");
                char tmpChar = grid[row-1][col + 1];
                int tmpCost;
                System.out.println("tmpChar: " + tmpChar);
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    System.out.println(travelCosts.get(i).getType());
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        System.out.println("weee");
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            System.out.println(currentDist);
                            int moveDist = nodes.get((row-1) * grid[0].length + col+1).getDistance();
                            nodes.get((row-1) * grid[0].length + col+1).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get((row-1) * grid[0].length + col+1) + " to " + nodes.get((row-1) * grid[0].length + col+1).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row-1) && sorted.get(j).getLocation().getY() == col+1)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
            }
            //up left
            if(row - 1 >= 0 && col - 1 >= 0)
            {
                System.out.println("check up left");
                char tmpChar = grid[row-1][col - 1];
                int tmpCost;
                System.out.println("tmpChar: " + tmpChar);
                for(int i = 0; i < travelCosts.size(); i++)
                {
                    System.out.println(travelCosts.get(i).getType());
                    if(travelCosts.get(i).getType() == tmpChar)
                    {
                        System.out.println("weee");
                        tmpCost = travelCosts.get(i).getCost();
                        if(tmpCost == -1)
                        {
                            break;
                        }
                        else {
                            //check if move price to grid[row][col-1] is worth replacing
                            int currentDist = nodes.get(row * grid[0].length + col).getDistance();
                            System.out.println(currentDist);
                            int moveDist = nodes.get((row-1) * grid[0].length + col-1).getDistance();
                            nodes.get((row-1) * grid[0].length + col-1).setDistance(Math.min(currentDist + tmpCost, moveDist));
                            System.out.println("change: " + nodes.get((row-1) * grid[0].length + col-1) + " to " + nodes.get((row-1) * grid[0].length + col-1).getDistance());
                            //update sorted
                            for(int j = 0; j < sorted.size(); j++)
                            {
                                if(sorted.get(j).getLocation().getX() == (row-1) && sorted.get(j).getLocation().getY() == col-1)
                                {
                                    sorted.get(j).setDistance(Math.min(currentDist + tmpCost, moveDist));
                                }
                            }
                        }
                    }
                }
            }
            //System.out.println("BBB" + sorted.get(1).getLocation() + ", " + sorted.get(1).getDistance());
            Collections.sort(sorted);
        }
        System.out.println(nodes.size());
        int tmpi = 0;
        int tmpj = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 'E')
                {
                    tmpi = i;
                    tmpj = j;
                }
            }
        }
        
        for(int i = 0; i < nodes.size(); i++)
        {
            if(nodes.get(i).getLocation().getX() == tmpi && nodes.get(i).getLocation().getY() == tmpj)
            {
                if(nodes.get(i).getDistance() > -10 && nodes.get(i).getDistance() != Integer.MAX_VALUE)
                {
                    return nodes.get(i).getDistance();
                }
                return -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        char [][] grid = {{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                            {'E', 'O', 'P', 'P', 'O', 'P', 'O', 'S'},
                            {'O', 'O', 'O', 'O', 'O', 'P', 'O', 'O'},
                            {'O', 'O', 'P', 'O', 'O', 'O', 'O', 'O'}};
        System.out.println(lowestFuel(grid));
    }
    
}