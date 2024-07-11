
public class Main {
    public static void main(String[] args) {
        String[][] dizi=new String[6][4];

        for(int i=0; i< dizi.length; i++){
            for(int j=0; j<dizi[i].length; j++){
                if(i==0 || i==2){
                    dizi[i][j]=" * ";
                } else if (j==0 || j==3) {
                    dizi[i][j]=" * ";
                } else {
                    dizi[i][j]="   ";
                }

            }
            System.out.println();
        }
        for (String[] row:dizi){
            for (String col:row){
                System.out.print(col);
            }
            System.out.println();
        }

    }
}