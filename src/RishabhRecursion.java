public class RishabhRecursion {
    public static  void printcounting(int x)
    {
        if(x==0)
        {
            System.out.println(0);
            return ;
        }
        printcounting(x-1);
        System.out.println(x);
    }

    public static int sum(int var)
    {
        if(var ==5)
        {
            return  5;
        }
        return var +sum(var+1);
    }

    public static int factorial(int fac)
    {
        if(fac ==1)
        {
            return 1;
        }
        return fac * factorial(fac-1);
    }

    public static void fibo(int a,int b ,int x )
    {
        if(x==0)
        {
            return;
        }
        int newa = a;
        int newb = b;
        int sum  = newa+newb;
        System.out.print (sum +" ");
        fibo(newb,sum,x-1);
    }


    public static int  pow(int x,int n)
    {
        if(n==1)
        {
            return x;
        }
        return x *pow(x,n-1);
    }


    public static void main(String[] args) {
//        printcounting(5);
//        System.out.println(sum(1));
//        System.out.print (0+ " "+1+" ");
//        fibo(0,1,3);
        System.out.println(pow(2,5));
    }

}
