import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int elemanSayisi;
        int a=0,b=1;
        System.out.print("Fibonacci hesabi icin eleman sayisi giriniz:");
        elemanSayisi= input.nextInt();

        for (int i=1; i<=elemanSayisi; i++){
            System.out.print(a+" ");

            int toplam=a+b;
            a=b;
            b=toplam;
        }
        input.close();
    }
}