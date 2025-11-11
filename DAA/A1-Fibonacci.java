import java.sql.Time;
import java.util.Scanner;

public class Fibo {

    public static void fiboNonRecursive(
            int range
    ){

        int f0,f1,f2;
        f0 = 0;
        f1 = 1;

        System.out.println(f0);
        System.out.println(f1);

        for(int i = 2 ; i<range ; i++){
            f2 = f1+f0;
            System.out.println(f2);
            f0 = f1;
            f1 = f2;
        }

    }

    /**
     * Helper function
     *
     * @param f0 First num
     * @param f1 Second num
     * @param curr Current index
     * @param range Total num range
     */
    public static void fiboRecursive(
            int f0,
            int f1,
            int curr,
            int range
    ){

        if(curr >= range){
            return ;
        }

        System.out.println(f0+f1);

        fiboRecursive(f1,f1+f0,curr+1,range);

    }

    public static void findFiboRec(
            int range
    ){
        System.out.println("First "+range+" fibo numbers are-");
        if(range<=0){
            return;
        }else if(range==1){
            System.out.println(0);
            return;
        } else if (range==2) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        System.out.println(0);
        System.out.println(1);
        fiboRecursive(0,1,2,range);


    }


    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        fiboNonRecursive(5);

        System.out.println("method 2");

        int range;
        System.out.println("Enter range");
        range = sc.nextInt();

        findFiboRec(range);

    }

}
