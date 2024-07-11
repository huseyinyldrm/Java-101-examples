import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a,b,c;
        System.out.print("1.sayi:");
        a= input.nextInt();

        System.out.print("2.sayi:");
        b= input.nextInt();

        System.out.print("3.sayi:");
        c=input.nextInt();

        if(a>b && a>c){ // en buyuk deger a olursa
           if(b>c){
               System.out.print(a+">"+b+">"+c);
           }
           else {
               System.out.print(a+">"+c+">"+b);
           }
        }
        else if(b>a && b>c){  // en buyuk deger b olursa
            if(a>c){
                System.out.print(b+">"+a+">"+c);
            }
            else {
                System.out.print(b+">"+c+">"+a);
            }
        }
        else if(c>a && c>b){  // en buyuk deger c olursa
            if(a>b){
                System.out.print(c+">"+a+">"+b);
            }
            else {
                System.out.print(c+">"+b+">"+a);
            }
        }
    }
}