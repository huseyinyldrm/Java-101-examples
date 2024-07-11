import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayi giriniz: ");
        int n = input.nextInt();

        for (int i = 0; i <4*n; i++) {
            for (int j = 0; j <4*n; j++) {
                if(i<n || i>(3*n)-1 || j<n|| j>(3*n)-1){
                    System.out.print(" * ");
                }
                else{
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }

        System.out.print("\n****************************\n");

                System.out.print("Bir sayi giriniz: ");
                int sayi = input.nextInt();

                int kenar = 4 * sayi;

                for (int i = 0; i < kenar * kenar; i++) {
                    int satir = i / kenar;
                    int sutun = i % kenar;

                    if (satir < n || satir >= 3 * n || sutun < n || sutun >= 3 * n) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" # ");
                    }
                    if (sutun == kenar - 1) {
                        System.out.println();
                    }
                }
            }
        }

