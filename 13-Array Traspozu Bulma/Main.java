import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Matris satir satisini giriniz:");
        int rows = input.nextInt();
        System.out.print("Matris sutun sayisini giriniz:");
        int cols = input.nextInt();

        //matris olustur

        int[][] matrix = new int[rows][cols];

        // matriselemanların kullanıcıdan alın
        System.out.println("Matris elemanlarini giriniz:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("[%d][%d]:", i, j);
                matrix[i][j] = input.nextInt();
            }
        }
        // matrisi yazdırma
        System.out.println("Matris verileri:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //matris transpozunu hesapla
        // buraya dikkat cols ve rows yeri değiştirildi.

        int[][] transpoz = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpoz[j][i] = matrix[i][j];
            }
        }

        // transpoz matrisini ekrana yazma

        System.out.println("Matrisin Transpozu:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpoz[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}