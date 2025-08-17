import java.util.*;
import java.lang.Math;
class Game
{
    static void display(char ar[][])
    {
        for(int i=0;i<8;i++)
        {
            System.out.println();
            for(int j=0;j<8;j++)
            {
                System.out.print(ar[i][j]+"  ");
            }
        }
    }
    static void mechanics(char ar[][],char n)
    {
        Scanner sc=new Scanner(System.in);
        int s=1;char m=0;ar[0][0]=n;int i=0,j=0;
        System.out.println("Enter W A S D for Movement");
        int fi=(int)(Math.random()*7);
        int fj=(int)(Math.random()*7);
        ar[fi][fj]='@';int pts=1;
        while(s>0)
        {
            m=sc.next().charAt(0);
            if(m=='a'&& j>0)
            {
                char tem=ar[i][j];
                ar[i][j]=ar[i][j-1];
                ar[i][j-1]=tem;
                j=j-1;
            }
            else if(m=='w'&& i>0)
            {
                char tem=ar[i][j];
                ar[i][j]=ar[i-1][j];
                ar[i-1][j]=tem;
                i=i-1;
            }
            else if(m=='d' && j<7)
            {
                char tem=ar[i][j];
                ar[i][j]=ar[i][j+1];
                ar[i][j+1]=tem;
                j=j+1;
            }
            else if(m=='s' && i<7)
            {
                char tem=ar[i][j];
                ar[i][j]=ar[i+1][j];
                ar[i+1][j]=tem;
                i=i+1;//ar[i+1][j]='';ar[i][j+1]='';ar[i-1][j]='';ar[i][j-1]='';
            }
            display(ar);
            if(i==fi && j==fj)
            {
                display(ar);
                if(i==0 && j!=0)
                {
                    ar[i+1][j]='_';ar[i][j+1]='_';ar[i][j-1]='_';
                }
                else if(j==0 && i!=0)
                {
                    ar[i+1][j]='_';ar[i][j+1]='_';ar[i-1][j]='_';
                }
                else if(j==0 && i==0)
                {
                    ar[i+1][j]='_';ar[i][j+1]='_';
                }
                else{
                    ar[i+1][j]='_';ar[i][j+1]='_';ar[i-1][j]='_';ar[i][j-1]='_';
                }
                fi=(int)(Math.random()*7);
                fj=(int)(Math.random()*7);
                ar[fi][fj]='@';
                System.out.println("Points"+ (pts++));
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Player Name");
        String name=sc.next();
        char n=name.charAt(0);
        char ar[][]= new char[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                ar[i][j]='_';
            }
        }
        mechanics(ar,n);
    }

}
