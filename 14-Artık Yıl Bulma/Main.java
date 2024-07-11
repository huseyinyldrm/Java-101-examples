import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int yil;
        System.out.print("Yil giriniz:");
        yil= input.nextInt();

        if((yil%400==0) || (yil%4==0 && yil%100!=0)){
            System.out.print(yil+" yili artik yildir.");
        }
        else {
            System.out.print(yil+" yili artik yil degildir.");
        }

    }
}