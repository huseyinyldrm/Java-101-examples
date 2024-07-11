import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName, password;
        int bakiye = 5000;
        int select;
        int right = 3;

        System.out.print("Kullanici adiniz:");
        userName = input.nextLine();
        System.out.print("Parolaniz:");
        password = input.nextLine();
        while (right > 0) {


            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("\nBankamiza Hosgeldiniz.");

                do {
                    System.out.println("1-Para Yatirma\n" +
                            "2-Para Cekme\n" +
                            "3-Bakiye Sorgulama\n" +
                            "4-Cikis");
                    System.out.print("Yapmak istediginiz islemi giriniz:");
                    select = input.nextInt();

                    switch (select) {
                        case 1:
                            System.out.print("Para Miktari:");
                            int price = input.nextInt();
                            bakiye += price;
                            System.out.print("Guncel Bakiyeniz:" + bakiye);
                            break;
                        case 2:
                            System.out.print("Para Miktari:");
                            int cekilenMiktar = input.nextInt();
                            if (cekilenMiktar > bakiye) {
                                System.out.print("Bakiye yetersiz.");
                            } else {
                                bakiye -= cekilenMiktar;
                                System.out.print("Guncel Bakiye:" + bakiye);
                            }
                            break;
                        case 3:
                            System.out.print("Guncel Bakiyeniz:" + bakiye);
                            break;
                        case 4:
                            System.out.print("Cikis yapiliyor.");
                            break;
                        default:
                            System.out.print("Gecerli deger giriniz.");
                            break;
                    }
                } while (select != 4);
                break;

            } else {
                right--;
                System.out.println("Hatali giris.Tekrar deneyin.");
                if (right == 0) {
                    System.out.println("Hesabiniz bloke olmustur.");
                } else {
                    System.out.println("Kalan Hakkiniz:" + right);
                }
            }
            if(right>0){
                System.out.print("Kullnici adiniz:");
                userName= input.next();
                System.out.print("Parolaniz:");
                password= input.next();
            }

        }
    }
}