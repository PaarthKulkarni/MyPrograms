import java.util.*;
import java.math.*;
import java.util.Date;
/**
 * Minesweeper Game
 *
 * Paarth Kulkarni
 * @version (a version number or a date)
 */
public class Mine
{
    public void main()
    {
        Scanner sc= new Scanner(System.in);
        int R = 0, C = 0;
        int[][] back = new int[100][100];
        int[][] front = new int[100][100];
        int i = 0, j = 0;
        for(i = 0; i < 100; i++)
        {
            for(j = 0; j < 100; j++)
            {
                front[i][j] = 10;
                back[i][j]  = 10;
            }
        }
        String bomb = "💣";
        String Nor  = "😀";
        String Win  = "😎";
        String Lose = "☠";
        String box  = "⬛";
        String Exp  = "💥";
        System.out.println(bomb + Nor + Win + Lose);
        System.out.print('\u000C');
        for(int k = 0; k == 0;)
        {
            System.out.print("Enter Number of Rows : ");
            R = sc.nextInt();
            if(R >= 5 && R <=100)
            {
                k = 1;
            }
            else
            {
                System.out.println("Number of Rows should be between 10 and 100 ");
            }
        }
        for(int k = 0; k == 0;)
        {
            System.out.print("Enter Number of Columns : ");
            C = sc.nextInt();
            if(C >= 5 && C <=100)
            {
                k = 1;
            }
            else
            {
                System.out.println("Number of Columns should be between 10 and 100 ");
            }
        }

        int N = C * R;
        int B = 0;
        int b;
        for(int k = 0; k == 0;)
        {
            System.out.print("Enter Number of Bombs : ");
            B = sc.nextInt();
            if(B >= 5 && B <= (int)(0.8 * N))
            {
                k = 1;
            }
            else if(B < 5)
            {
                System.out.println("Too Little Bombs");
            }
            else
            {
                System.out.println("Too Much Bomb");
            }
        }
        System.out.print('\u000C');
        N = N - B;
        System.out.println(B + "\t" + Nor + "\t" + N);
        for(i = 1; i <= R; i++)
        {
            for(j = 1; j <= C; j++)
            {
                if(front[i][j] == 10)
                {
                    System.out.print(box + "  ");
                }
            }
            System.out.println();
        }
        int r1 = 0, c1 = 0;
        for(int k = 0; k == 0;)
        {
            System.out.print("Enter Row Number : ");
            r1 = sc.nextInt();
            if(r1 >= 1 && r1 <= R)
            {
                k = 1;
            }
            else
            {
                System.out.println("Enter Valid Row Number");
            }
        }
        for(int k = 0; k == 0;)
        {
            System.out.print("Enter Column Number : ");
            c1 = sc.nextInt();
            if(c1 >= 1 && c1 <= C)
            {
                k = 1;
            }
            else
            {
                System.out.println("Enter Valid Column Number");
            }
        }
        System.out.print('\u000C');
        b = B;
        int r = 0, c = 0;
        for(;b != 0;)
        {
            r = (int) ((Math.random() * (R)) + 1);
            c = (int) ((Math.random() * (C)) + 1);
            if(back[r][c] == 10)
            {
                if(r == r1 && c == c1)
                {
                }
                else
                {
                    back[r][c] = 9;
                    b--;
                }
            }
        }
        for(i = 1; i <= R; i++)
        {
            for(j = 1; j <= C; j++)
            {
                if(back[i][j] == 10)
                {
                    back[i][j] = 0;
                    if(back[i - 1][j - 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i - 1][j] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i - 1][j + 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i][j - 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i][j + 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i + 1][j - 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i + 1][j] == 9)
                    {
                        back[i][j] += 1;
                    }
                    if(back[i + 1][j + 1] == 9)
                    {
                        back[i][j] += 1;
                    }
                }
            }
        }
        System.out.print('\u000C');
        front[r1][c1] = back[r1][c1];
        N--;
        int N1 = 0;
        int f = 0;
        for(;N > 0;)
        {
            System.out.println(B + "\t" + Nor + "\t" + N);
            for(i = 1; i <= R; i++)
            {
                for(j = 1; j <= C; j++)
                {
                    if(front[i][j] == 10)
                    {
                        System.out.print(box + "  ");
                    }
                    else if(front[i][j] == 9)
                    {
                        System.out.print(bomb + " ");
                        N1 = N;
                        N  = 0;
                    }
                    else
                    {
                        System.out.print(front[i][j] + "  ");
                    }
                }
                System.out.println();
            }
            for(int k = 0; k == 0;)
            {
                System.out.print("Enter Row Number : ");
                r1 = sc.nextInt();
                if(r1 >= 1 && r1 <= R)
                {
                    k = 1;
                }
                else
                {
                    System.out.println("Enter Valid Row Number");
                }
            }
            for(int k = 0; k == 0;)
            {
                System.out.print("Enter Column Number : ");
                c1 = sc.nextInt();
                if(c1 >= 1 && c1 <= C)
                {
                    k = 1;
                }
                else
                {
                    System.out.println("Enter Valid Column Number");
                }
            }
            if(front[r1][c1] == 10)
            {
                front[r1][c1] = back[r1][c1];
                if(front[r1][c1] == 9)
                {
                    N1 = N;
                    N =  0;
                }
                N--;
            }
            else
            {
                System.out.println("Enter different cell number");
                try
                {
                    Thread.sleep(2000);
                }
                catch(InterruptedException e)
                {
                    System.err.println(e.getMessage());
                }
            }
            
            System.out.print('\u000C');
        }
    }
}