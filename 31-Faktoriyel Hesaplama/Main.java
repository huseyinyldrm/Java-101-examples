import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int total=1;// carpmada etkisiz oldugu için 1 verildi
        int sayi;
        System.out.print("Faktorial sayisini giriniz:");
        sayi= input.nextInt();

        for(int i=1; i<=sayi; i++){
            total=total*i;
        }
        System.out.print(sayi+" faktorial degeri:"+total);

    }
}