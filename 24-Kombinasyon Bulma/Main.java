import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int pay;
        int payda;
        int total1=1;
        int total2=1;
        int total3=1;
        double combinasyon;

            System.out.print("Combinasyon icin pay degeri:");
            pay = input.nextInt();
            System.out.print("Combinasyon icin payda degeri:");
            payda = input.nextInt();

            for (int i = 1; i <= pay; i++) {
                total1 *= i;
            }
            for (int i = 1; i <= payda; i++) {
                total2 *= i;
            }
            for (int i = 1; i <= (pay - payda); i++) {
                total3 *= i;
            }
            combinasyon = (double) total1 / (total2 * total3);
            System.out.print(pay + " degerinin " + payda + " 'li combinasyonu:" + combinasyon);
    }
}