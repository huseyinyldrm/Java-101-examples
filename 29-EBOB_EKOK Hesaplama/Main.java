import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int buyukSayi;
        int kucukSayi;
        int ebob = 0;
        int ekok;
        System.out.print("Buyuk sayiyi giriniz:");
        buyukSayi = input.nextInt();
        System.out.print("Kucuk sayiyi giriniz:");
        kucukSayi = input.nextInt();

        int i = 1;
        while (i <= buyukSayi) {
            if (buyukSayi % i == 0 && kucukSayi % i == 0) {
                ebob = i;
            }
            i++;
        }
        System.out.println(buyukSayi + " ve " + kucukSayi + " sayilarinin ebob degeri:" + ebob);

        int k = 1;
        while (k <= (buyukSayi * kucukSayi)) {
            if (k % buyukSayi == 0 && k % kucukSayi == 0) {
                ekok = k;
                System.out.println(buyukSayi + " ve " + kucukSayi + " sayilarinin ekok degeri:" + ekok);
                break;// bu koyulmazsa ekok doğru bulunmaz.
            }
            k++;
        }
        System.out.println("Ikinci ekok bulma yontemi:" + (buyukSayi * kucukSayi) / ebob);


    }
}