
public class Main {
    public static void main(String[] args) {
        int[] list={23,54,21,65,78,87,9,98};
        double average;
        int sum=0;

        for (int i=0; i< list.length; i++){
            sum+=list[i];
        }
        average =(double) sum/ list.length;
        System.out.println("Liste Ortalama:"+average);

        System.out.println("************************");

        double average2;
        int total=0;

        int[] liste2={45,676,3,21,76,5,34,21,26};

        // forEach ile şöyle hesaplanır:
        for(int i: list){
            total+=i;
        }

        average2=(double) total/liste2.length;
        System.out.println("Liste2 ortalama:"+average2);


    }
}