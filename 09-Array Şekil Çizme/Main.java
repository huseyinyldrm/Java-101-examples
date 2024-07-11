
public class Main {
    public static void main(String[] args) {
        String[][] letter=new String[9][5];

        for(int i=0; i< letter.length; i++){
            for (int j=0; j<letter[i].length; j++){
                if(j==0 || i==4 && j<=2 || i==0 && j<=2 || i==8 && j<=2){
                    letter[i][j]=" * ";
                } else if (i + j == 6 && j > 2 || i+j==10 || i%9==1 && j==3 || i%9==5 && j==3){
                    letter[i][j]=" * ";
                } else{
                    letter[i][j]="   ";
                }

            }
        }

        for(String[] row : letter){
            for(String col:row){
                System.out.print(col);
            }
            System.out.println();
        }

    }
}