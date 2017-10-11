package sw.pro.the3nplus1_2;

import java.io.IOException;
import java.util.StringTokenizer;

class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {

        String input;
        StringTokenizer idata;
        int a, b,max;


        while (!(input = Main.ReadLn (255)).equals(""))
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());

          if (a<b){
              max=work(a,b);

          }else{
              max=work(b,a);
          }
          System.out.println (a + " " + b + " " +max);
        }
    }

    int work( int a , int b){
        int max=0;
        for ( int i=a;i<=b;i++){
            int temp=process(i);
            if (temp>max) max=temp;
        }
        return max;
    }
    int process (long n){
        int count=1;
        while(n!=1){
            count++;
            if (n%2==1){
                n=n*3+1;
            }else{
                n=n>>1;
            }
        }

        return count;
    }
}