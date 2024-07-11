import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, day;
        String burc = " ";

        System.out.print("Dogdugunuz ay:");
        month = input.nextInt();

        System.out.print("Dogdugunuz gun:");
        day = input.nextInt();
        if (month == 1) {
            if (day >= 1 && day <= 21) {
                burc = "Oglak";
            } else if (day >= 22 && day <= 31) {
                burc = "Kova";
            }
        } else if (month == 2) {
            if (day >= 1 && day <= 19) {
                burc = "Kova";
            } else if (day >= 20 && day <= 29) {
                burc = "Balik";
            }

        } else if (month == 3) {
            if (day >= 1 && day <= 20) {
                burc = "Balik";
            } else if (day >= 21 && day <= 31) {
                burc = "Koc";
            }

        } else if (month == 4) {
            if (day >= 1 && day <= 20) {
                burc = "Koc";
            } else if (day >= 21 && day <= 31) {
                burc = "Boga";
            }

        } else if (month == 5) {
            if (day >= 1 && day <= 21) {
                burc = "Boga";
            } else if (day >= 22 && day <= 31) {
                burc = "İkizler";
            }

        } else if (month == 6) {
            if (day >= 1 && day <= 22) {
                burc = "İkizler";
            } else if (day >= 23 && day <= 31) {
                burc = "Yengec";
            }

        } else if (month == 7) {
            if (day >= 1 && day <= 22) {
                burc = "Yengec";
            } else if (day >= 23 && day <= 31) {
                burc = "Aslan";
            }

        } else if (month == 8) {
            if (day >= 1 && day <= 22) {
                burc = "Aslan";
            } else if (day >= 23 && day <= 31) {
                burc = "Basak";
            }
        } else if (month == 9) {
            if (day >= 1 && day <= 22) {
                burc = "Basak";
            } else if (day >= 23 && day <= 30) {
                burc = "Terazi";
            }
        } else if (month == 10) {
            if (day >= 1 && day <= 22) {
                burc = "Terazi";
            } else if (day >= 23 && day <= 31) {
                burc = "Akrep";
            }
        } else if (month == 11) {
            if (day >= 1 && day <= 21) {
                burc = "Akrep";
            } else if (day >= 22 && day <= 30) {
                burc = "Yay";
            }
        } else if (month == 12) {
            if (day >= 1 && day <= 21) {
                burc = "Yay";
            } else if (day >= 22 && day <= 31) {
                burc = "Oglak";
            }
        } else {
            System.out.print("Gecerli bir deger giriniz.");
        }
        System.out.print("Burcunuz:" + burc);


    }
}