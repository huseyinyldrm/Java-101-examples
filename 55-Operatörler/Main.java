
public class Main {
    public static void main(String[] args) {

        int A=10;
        int B=20;
        int C=30;
        int D=40;
        // == eşittir operator kullanimi

        System.out.println(A==B);
        System.out.println(A==C);
        System.out.println(A==D);
        System.out.println(B==D);

        // eşit değildir operatoru
        System.out.println("************");

        System.out.println(A!=B);
        System.out.println(A!=C);
        System.out.println(A!=D);
        System.out.println(D!=B);

        // buyuktur operatoru
        System.out.println("************");

        System.out.println(A>=B);
        System.out.println(A>=C);
        System.out.println(C>=B);
        System.out.println(D>=B);




    }
}