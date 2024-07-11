public class Teacher {
    String name;
    String branch;
    String  mpNo;

    Teacher (String name,String mpNo,String branch){
        this.name=name;
        this.mpNo=mpNo;
        this.branch=branch;
    }
    void print(){
        System.out.println("=======================");
        System.out.println("Ogretmen Adi:"+this.name);
        System.out.println("Bransi      :"+this.branch);
        System.out.println("Telefon No  :"+this.mpNo);
    }

}
