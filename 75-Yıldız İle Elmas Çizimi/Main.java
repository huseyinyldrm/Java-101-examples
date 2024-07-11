import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayi;
        int i,j,k;
        System.out.print("elmas deseni için bir sayi giriniz:");
        sayi= input.nextInt();

        for(i=1; i<=sayi; i++){//elmas ust kısmı için
            for(j=1; j<=(sayi-i); j++){
                System.out.print(" ");
            }
            for (k=2; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(i=sayi-1; i>=1; i--){
            for(j=1; j<=sayi-i; j++){
                System.out.print(" ");
            }
            for (k=2; k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}