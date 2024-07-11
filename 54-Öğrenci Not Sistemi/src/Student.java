public class Student {
    String name,stuNo;
    String classes;
    Course mat;
    Course fizik;
    Course kimya;
    Course biyo;
    Course tarih;
    Course cografya;
    Course muzik;

    double average;

    boolean isPass;

    Student(String name,String classes,String stuNo,Course mat,Course fizik,Course kimya,Course biyo,Course muzik,Course tarih,Course cografya){
        this.name=name;
        this.classes=classes;
        this.stuNo=stuNo;
        this.mat=mat;
        this.fizik=fizik;
        this.kimya=kimya;
        this.biyo=biyo;
        this.tarih=tarih;
        this.cografya=cografya;
        this.muzik=muzik;
        calcAverage();
        this.isPass=false;
    }
    void addExamsNote(int mat,int fizik,int kimya,int biyo,int tarih,int cografya,int muzik){
        if(mat>=0 && mat<=100){
            this.mat.note=mat;
        }
        if(fizik>=0 && fizik<=100){
            this.fizik.note=fizik;
        }
        if(kimya>=0 && kimya<=100){
            this.kimya.note=kimya;
        }
        if(biyo>=0 && biyo<=100){
            this.biyo.note=biyo;
        }
        if(tarih>=0 && tarih<=100){
            this.tarih.note=tarih;
        }
        if(cografya>=0 && cografya<=100){
            this.cografya.note=cografya;
        }
        if(muzik>=0 && muzik<=100){
            this.muzik.note=muzik;
        }

    }
    void addSozlu(int matSozlu,int fizikSozlu,int kimyaSozlu,int biyoSozlu,int tarihSozlu,int cografyaSozlu,int muzikSozlu){
        if(matSozlu>=0 && matSozlu<=100){
            this.mat.sozlu=matSozlu;
        }
        if(fizikSozlu>=0 && fizikSozlu<=100){
            this.fizik.sozlu=fizikSozlu;
        }
        if(kimyaSozlu>=0 && kimyaSozlu<=100){
            this.kimya.sozlu=kimyaSozlu;
        }
        if(biyoSozlu>=0 && biyoSozlu<=100){
            this.biyo.sozlu=biyoSozlu;
        }
        if(tarihSozlu>=0 && tarihSozlu<=100){
            this.tarih.sozlu=tarihSozlu;
        }
        if(cografyaSozlu>=0 && cografyaSozlu<=100){
            this.cografya.sozlu=cografyaSozlu;
        }
        if(muzikSozlu>=0 && muzikSozlu<=100){
            this.muzik.sozlu=muzikSozlu;
        }

    }
    void  isPass(){
        if(this.mat.note==0||this.fizik.note==0||this.kimya.note==0||
        this.biyo.note==0||this.tarih.note==0||this.cografya.note==0||
        this.muzik.note==0){
            System.out.println("Notlar tam girilmemis.");
        }
        else{
            this.isPass=isCheckPass();
            printNote();
            System.out.println("Ortalama:"+this.average);
            if(this.isPass){
                System.out.println("Sinifi gecti.");
            }
            else{
                System.out.println("Sinifta kaldi.");
            }
        }

    }
    void calcAverage(){
        this.average=(((this.mat.note*0.80)+(this.mat.sozlu*0.20))+
                ((this.fizik.note*0.80)+(this.fizik.sozlu*0.20))+
                ((this.kimya.note*0.75)+(this.kimya.sozlu*0.25))+
                ((this.biyo.note*0.75)+(this.biyo.sozlu*0.25))+
                ((this.cografya.note*0.65)+(this.cografya.sozlu*0.35))+
                ((this.tarih.note*0.65)+(this.tarih.sozlu*0.35)) +
                ((this.muzik.note*0.60)+(this.muzik.sozlu*0.40)))/7;
    }
    public boolean isCheckPass(){
        calcAverage();
        return this.average>=60;
    }
    void printNote(){
        System.out.println("====================");
        System.out.println("Ogrenci:"+this.name);
        System.out.println("Matematik Notu:"+this.mat.note+"\t\t Matematik Sozlu Notu:"+this.mat.sozlu);
        System.out.println("Fizik Notu:"+this.fizik.note+"\t\t\t Fizik Sozlu Notu:"+this.fizik.sozlu);
        System.out.println("Kimya Notu:"+this.kimya.note+"\t\t\t Kimya Sozlu Notu:"+this.kimya.sozlu);
        System.out.println("Biyoloji Notu:"+this.biyo.note+"\t\t Biyoloji Sozlu Notu:"+this.biyo.sozlu);
        System.out.println("Tarih Notu:"+this.tarih.note+"\t\t\t Tarih Sozlu Notu:"+this.tarih.sozlu);
        System.out.println("Cografya Notu:"+this.cografya.note+"\t\t Cografya Sozlu Notu:"+this.cografya.sozlu);
        System.out.println("Muzik Notu:"+this.muzik.note+"\t\t\t Muzik Sozlu Notu:"+this.muzik.sozlu);
    }
}
