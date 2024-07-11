import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dogumYili;
        String cinZodyagiBurcu = "";
        System.out.print("Lutfen dogum yilinizi giriniz:");
        dogumYili = input.nextInt();

        if (dogumYili % 12 == 0) {
            cinZodyagiBurcu = "Maymun";
        } else if (dogumYili % 12 == 1) {
            cinZodyagiBurcu = "Horoz";

        } else if (dogumYili % 12 == 2) {
            cinZodyagiBurcu = "Kopek";

        } else if (dogumYili % 12 == 3) {
            cinZodyagiBurcu = "Domuz";

        } else if (dogumYili % 12 == 4) {
            cinZodyagiBurcu = "Fare";

        } else if (dogumYili % 12 == 5) {
            cinZodyagiBurcu = "Okuz";

        } else if (dogumYili % 12 == 6) {
            cinZodyagiBurcu = "Kaplan";

        } else if (dogumYili % 12 == 7) {
            cinZodyagiBurcu = "Tavsan";

        } else if (dogumYili % 12 == 8) {
            cinZodyagiBurcu = "Ejderha";

        } else if (dogumYili % 12 == 9) {
            cinZodyagiBurcu = "Yilan";

        } else if (dogumYili % 12 == 10) {
            cinZodyagiBurcu = "At";

        } else if (dogumYili % 12 == 11) {
            cinZodyagiBurcu = "Koyun";

        } else {
            System.out.println("Gecerli bir deger giriniz.");
        }

        System.out.print("Cin Zodyagi Burcunuz:" + cinZodyagiBurcu);


    }
}