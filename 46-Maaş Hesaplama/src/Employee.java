public class Employee {
    String name;
    double salary;
    int workHours;// haftalık calismak saati
    int hireYears;// işe başlangıç yılı

    // constrotur olustur

    Employee(String name,double salary,int workHours,int hireYears){
        this.name=name;
        this.hireYears=hireYears;
        this.salary=salary;
        this.workHours=workHours;
    }

    // vergi oranlarını hesaplama

    public double tax(){
        if(this.salary<1000){
            return 0;
        } else {
            return this.salary * 0.03;
        }
    }
    // bonusları hesapla

    public  double bonus(){
        double result;
        if (this.workHours>=40) {
            result=this.workHours-40;
            return result * 30;
        }else {
            return 0;
        }
    }

    //başlangıç yılına göre maas hesaplama

    public double raiseSalary(){
        double raiseAmount=0;
        if(2024-this.hireYears<10){
            raiseAmount=this.salary*=0.05;
        } else if(2024-this.hireYears>=10 && 2024-this.hireYears<20){
            raiseAmount=salary*=0.10;
        } else if(2024-this.hireYears>=20){
           raiseAmount= this.salary*=0.15;
        }
        return raiseAmount;
    }

    // sonuçları ekrana yazdırma
    void printKnowledge(){

        double totalSalary=this.salary-tax()+bonus();
        System.out.println("-----------------------------");
        System.out.println("Isim:\t"+this.name);
        System.out.println("Maas:\t"+this.salary);
        System.out.println("Calisma Saati:"+this.workHours);
        System.out.println("Baslangic Yili:"+this.hireYears);
        System.out.println("Vergi:\t"+tax());
        System.out.println("Bonus:\t"+bonus());
        System.out.println("Maas Artisi:"+raiseSalary());
        System.out.println("Vergiler ve Bonuslar ile Birlikte Maas:"+totalSalary);
        System.out.println("Toplam Maas:"+(totalSalary+this.salary));

    }

}
