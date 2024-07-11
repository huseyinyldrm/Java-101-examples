import java.util.Scanner;

public class Main {
    static void isPalindrom(int number) {
        int temp = number;
        int reverseNumber = 0, lastNumber;

        while (temp != 0) {
            lastNumber = temp % 10; //kalan alınır
            reverseNumber = (reverseNumber * 10) + lastNumber;//yeni basamak eklenir
            temp /= 10;// kalan 0 oluncaya kadar devam eder
        }
        if (reverseNumber == number) {
            System.out.println(number + " Sayisi palindromdur.");
        } else {
            System.out.println(number + " Sayisi palindrom değildir.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayi giriniz:");
        int sayi = input.nextInt();

        isPalindrom(sayi);// girilen sayi metoda gonderilir.


    }
}