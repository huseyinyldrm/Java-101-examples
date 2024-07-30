import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.print("Sayi adedi giriniz:");

        int adet= input.nextInt();

        for(int i=0; i<=adet; i++){
            for(int j=0; j<(adet-i);j++){
                System.out.print("*");
            }
            for(int k=1; k<=(2*i+1); k++){
                System.out.print(" ");
            }
            System.out.println(" "); // bu yapılmazsa yanyana yazdırır.
        }


    }
}