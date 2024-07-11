import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sayi;
        double total=0;
        System.out.print("Bir sayi giriniz:");
        sayi= input.nextInt();

        for(int i=1; i<=sayi; i++){
            total=total+(1.0/i); // burada double veri olacak dikkat
        }
        System.out.print(sayi+" Sayisinin harmonik hesabi:"+total);

    }
}