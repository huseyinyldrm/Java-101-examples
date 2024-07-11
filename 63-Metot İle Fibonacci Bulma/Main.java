import java.util.Scanner;
public class Main {
    static void Fibonacci(int sayi){
       int n1=0,n2=1;
       int n3,i;
       System.out.print(n1+" "+n2+" ");
       for(i=2; i<=sayi; i++){
           n3=n2+n1;
           System.out.print(" "+n3+" ");
           n1=n2;
           n2=n3;
       }

    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Fibonacci icin basamak sayisi giriniz:");
        int adet= input.nextInt();
        Fibonacci(adet);

    }
}