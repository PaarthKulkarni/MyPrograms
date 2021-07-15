import java.math.*;
import java.util.*;
/**
 * 15-16 Puzzle
 *
 * Paarth Kulkarni
 * @version (a version number or a date)
 */
public class Puzzle1516
{
    static void randomize(int back[])
    {
        // Creating a object for Random class
        Random r = new Random();
           
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = 15 ; i > 0; i--) {
               
            // Pick a random index from 0 to i
            int j = r.nextInt(i);
               
            // Swap arr[i] with the element at random index
            int temp = back[i];
            back[i]  = back[j];
            back[j]  = temp;
        }
    }
    public void main()
    {
        Scanner sc= new Scanner(System.in);
        int R = 0, C  = 0;
        int [] back   = new int[16];
        int[][] front = new int[4][4];
        int[][] check = new int[4][4];
        int i = 0, j  = 0, c = 0, f = 1, temp = 0;
        for(i = 0; i < 4; i++)
        {
            for(j = 0; j < 4; j++)
            {
                front[i][j] = 0;
            }
        }
        for(i = 0; i < 16; i++)
        {
            back[i] = i;
        }
        randomize(back);
        for(i = 0; i < 4; i++)
        {
            for(j = 0; j < 4; j++)
            {
                front[i][j] = back[c];
                if(front[i][j] == 0)
                {
                    R = i;
                    C = j;
                }
                c++;
                check[i][j] = c;
                check[3][3] = 0;
            }
        }
        String ch = "";
        for(;f == 1;)
        {
            f = 0;
            for(i = 0; i < 4; i++)
            {
                for(j = 0; j < 4; j++)
                {
                    if(front[i][j] != 0)
                    {
                        System.out.print(front[i][j] + "\t");
                    }
                    else
                    {
                        System.out.print("_\t");
                    }
                    if(check[i][j] != front[i][j])
                    {
                        f = 1;
                    }
                }
                System.out.println("");
            }
            if(f == 1)
            {
                System.out.print("Enter Direction (w,a,s,d) : ");
                ch = sc.nextLine();
                switch(ch)
                {
                    case "w" :
                    case "W" : if(R != 3)
                               {
                                   temp = front[R][C];
                                   front[R][C] = front[R + 1][C];
                                   front[R + 1][C] = temp;
                                   R++;
                               }
                               break;
                    case "s" :
                    case "S" : if(R != 0)
                               {
                                   temp = front[R][C];
                                   front[R][C] = front[R - 1][C];
                                   front[R - 1][C] = temp;
                                   R--;
                               }
                               break;
                    case "a" :
                    case "A" : if(C != 3)
                               {
                                   temp = front[R][C];
                                   front[R][C] = front[R][C + 1];
                                   front[R][C + 1] = temp;
                                   C++;
                               }
                               break;
                    case "d" :
                    case "D" : if(C != 0)
                               {
                                   temp = front[R][C];
                                   front[R][C] = front[R][C - 1];
                                   front[R][C - 1] = temp;
                                   C--;
                               }
                               break;
                }
            }
        }
        System.out.print("You Win");
    }
}
