import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sayi;
        System.out.print("Bir sayi giriniz:");
        sayi= input.nextInt();
        int i=1;
        int toplam=0;

        while (i<=sayi){
            if(i%2==0){
                System.out.println(i);
                toplam+=i;
            }
            i++;
        }
        System.out.println("Girilen araliktaki sayilarin toplami:"+toplam);


    }
}