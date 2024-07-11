import java.util.Scanner;

public class Main {
    static boolean isAsal(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        for (int i = 2; i <= sayi / 2; i++) {
            if (sayi % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayi giriniz:");
        int number = input.nextInt();
        if (isAsal(number)) {
            System.out.print(number + " sayisi asaldir.");
        } else {
            System.out.print(number + " sayisi asal degildir.");
        }
    }
}