import java.util.*;
public class Main
{
    public static void main(String[] args) {
        MyStack<Integer> left = new MyStack<Integer>();
        MyStack<Integer> middle = new MyStack<Integer>();
        MyStack<Integer> right = new MyStack<Integer>();

        Scanner sc = new Scanner(System.in);
        boolean outOfRange = true;
        int diskNum = 0;
        while(outOfRange == true)
        {
            System.out.print("How many disks would you like to play with ( 3 to 5 ): ");
            diskNum = sc.nextInt();
            if(diskNum >= 3 && diskNum <= 5)
            {
                outOfRange = false;
            }
            else {
                System.out.println("\tValue out of range");
            }
        }
        for(int i = 0; i < diskNum; i++){
            left.push(diskNum-i);
        }
        System.out.println(left.toString());
        display(left, middle, right);
        boolean win = false;
        int moves = 0;
        while(win == false)
        {
            System.out.print("Enter the source pole: (1 to 3): ");
            int source = sc.nextInt();
            System.out.print("Enter the destination pole: (1 to 3): ");
            int dest = sc.nextInt();
            if(source < 1 || source > 3 || dest < 1 || dest > 3)
            {
                System.out.println("\tFrom and to must both be values from 1 to 3.");
                display(left, middle, right);
            }
            else {
                MyStack<Integer> sourceTower = new MyStack<Integer>();
                MyStack<Integer> destTower = new MyStack<Integer>();;
                if(source == 1)
                    sourceTower = left;
                if(source == 2)
                    sourceTower = middle;
                if(source == 3)
                    sourceTower = right;
                if(dest == 1)
                    destTower = left;
                if(dest == 2)
                    destTower = middle;
                if(dest == 3)
                    destTower = right;
                if(sourceTower.isEmpty() == true)
                {
                    System.out.println("\tInvalid move, from is an empty stack.");
                    display(left, middle, right);
                }
                else {
                    int sourceStack = sourceTower.peek();
                    if(!destTower.isEmpty() && sourceStack > destTower.peek())
                    {
                        System.out.println("\tInvalid move, a larger disk can not be placed on a disk");
                        display(left, middle, right);
                    }
                    else {
                        moves++;
                        destTower.push(sourceStack);
                        sourceTower.pop();
                        display(left, middle, right);
                    }
                }
            }
            if(left.isEmpty() && middle.isEmpty())
                win = true;
        }
        System.out.println("You solved the puzzle in " + moves + " moves!");

    }
    public static void display(MyStack<Integer> left, MyStack<Integer> middle, MyStack<Integer> right)
    {
        //System.out.println("\t-\t-\t-");
        for(int i = 5; i >=0 ; i--)
        {
            String d1 = "", d2 = "", d3 = "";

            try
             {
                 for(int j = 0; j < left.get(i) * 2 + 1; j++)
                 {
                    d1 += "x";
                 }
                 //d1 = String.valueOf(left.get(i));
             }
             catch (Exception e){
                 d1 = "-";
             }
            int remainingSpace = 15;
            remainingSpace -= d1.length();
            remainingSpace /= 2;
            // System.out.print(d1.length());
            String space = "";
            for(int k = 0; k < remainingSpace; k++)
                space += " ";
            //System.out.print(space.length());
            System.out.print(space + d1 + space);
             try
             {
                 for(int j = 0; j < middle.get(i) * 2 + 1; j++)
                 {
                    d2 += "x";
                 }
                 //d2 = String.valueOf(middle.get(i));

             }
             catch (Exception e){
                 d2 = "-";
             }
            remainingSpace = 15;
            remainingSpace -= d2.length();
            remainingSpace /=2;
            space = "";
            for(int k = 0; k < remainingSpace; k++)
                space += " ";
            //System.out.print(space.length());
            System.out.print(space + d2 + space);
             try
             {
                 for(int j = 0; j < right.get(i) * 2 + 1; j++)
                 {
                    d3 += "x";
                 }
                 //d3 = String.valueOf(right.get(i));
             }
             catch (Exception e){
                 d3 = "-";
             }
            remainingSpace = 15;
            remainingSpace -= d3.length();
            remainingSpace /=2;
            space = "";
            for(int k = 0; k < remainingSpace; k++)
                space += " ";
            System.out.print(space + d3 + space);
             System.out.println();
             //System.out.println("\t" + d1 + "\t" + d2 + "\t" + d3);
        }
    }
}
