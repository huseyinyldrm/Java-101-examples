import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Dizinin Boyutu:");
        int sayi= input.nextInt();


        int[] list=new int[sayi];

        for(int i=0; i<list.length;i++){

            System.out.print((i+1)+". Eleman:");
            list[i]=input.nextInt();
        }
        System.out.print("Siralama:");

        Arrays.sort(list);

        for(int number: list){
            System.out.print(number+" ");
        }

    }
}