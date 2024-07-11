import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int  sayi;
        int toplam=0;
        System.out.println("Sayi girislerini sonlandirmak icin -1'e basiniz.");

        do {
            System.out.print("Bir sayi giriniz:");
            sayi= input.nextInt();
            if(sayi%2==0){
                toplam+=sayi;
            }

        }while (sayi!=-1);

        System.out.print("Girilen sayilarin toplami:"+toplam);


    }
}