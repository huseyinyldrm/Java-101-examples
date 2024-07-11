import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int sayi;
        int us;
        int total=1;
        System.out.print("Taban degerini giriniz:");
        sayi= input.nextInt();
        System.out.print("Us degerini giriniz:");
        us= input.nextInt();

        for(int i=1; i<=us; i++){
            total=sayi*total;
        }
        System.out.print(sayi+" degerinin ussu:"+total);

    }
}