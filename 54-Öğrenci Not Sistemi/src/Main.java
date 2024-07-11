
public class Main {
    public static void main(String[] args) {

        // burada Course class'ından yeni veriler oluşturduk

        Course matematik=new Course("Matematik","MAT","MAT101");
        Course fizik=new Course("Fizik","FZK","FZK101");
        Course kimya=new Course("Kimya","KİM","KİM101");
        Course biyo=new Course("Biyoloji","BYO","BYO101");
        Course tarih=new Course("Tarih","TRH","TRH101");
        Course cografya=new Course("Cografya","CGY","CGY101");
        Course muzik=new Course("Muzik","MZK","MZK101");

        // burada Teacher class'ından yeni veriler oluşturduk
        Teacher t1=new Teacher("Cihan Hoca","05445543442","MAT");
        Teacher t2=new Teacher("Abdullah Hoca","05467652233","FZK");
        Teacher t3=new Teacher("Veysiye Hoca","05266983322","KİM");
        Teacher t4=new Teacher("Samet Hoca","05433422123","BYO");
        Teacher t5=new Teacher("Mahmut Hoca","05353334421","TRH");
        Teacher t6=new Teacher("Fatma Hoca","05343344676","CGY");
        Teacher t7=new Teacher("Murat Hoca","05432457898","MZK");

        // burada Course class'ının içindeki verileri yazdırdık
        t1.print();
        t2.print();
        t3.print();
        t4.print();
        t5.print();
        t6.print();
        t7.print();

        // burada Course class'ından derlere öğretmen ekledik
        matematik.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);
        biyo.addTeacher(t4);
        tarih.addTeacher(t5);
        cografya.addTeacher(t6);
        muzik.addTeacher(t7);

        // burada da yeni öğrenciler oluşturduk.Verileri Student class'ından aldık
        Student s1=new Student("Ahmet Bak","12/A","236",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s1.addExamsNote(65,66,44,66,88,99,55);
        s1.addSozlu(66,88,77,99,88,66,52);
        s1.isPass();

        Student s2=new Student("Murat Al","12/A","345",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s2.addExamsNote(45,66,88,55,99,44,99);
        s2.addSozlu(66,88,77,44,88,44,89);
        s2.isPass();

        Student s3=new Student("Nur Pak","12/A","654",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s3.addExamsNote(56,77,88,99,55,33,66);
        s3.addSozlu(66,55,77,88,99,77,66);
        s3.isPass();

        Student s4=new Student("Sema Göl","12/A","391",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s4.addExamsNote(88,66,88,90,65,88,90);
        s4.addSozlu(44,77,66,88,66,55,44);
        s4.isPass();

        Student s5=new Student("Harun Okyanus","12/A","387",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s5.addExamsNote(84,33,34,54,66,38,95);
        s5.addSozlu(44,77,66,99,88,66,55);
        s5.isPass();

        Student s6=new Student("Berk Dere","12/A","466",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s6.addExamsNote(45,46,68,60,55,48,92);
        s6.addSozlu(55,77,88,99,66,55,99);
        s6.isPass();

        Student s7=new Student("Mizgin Bal","12/A","234",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s7.addExamsNote(34,44,38,20,85,98,95);
        s7.addSozlu(44,88,77,66,55,88,99);
        s7.isPass();

        Student s8=new Student("Serap Recel","12/A","531",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s8.addExamsNote(80,64,86,95,64,83,95);
        s8.addSozlu(77,88,99,77,66,55,44);
        s8.isPass();

        Student s9=new Student("Sevilay Ak","12/A","821",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s9.addExamsNote(55,65,84,90,76,56,100);
        s9.addSozlu(55,77,99,88,80,90,90);
        s9.isPass();

        Student s10=new Student("Zozan Arjin","12/A","781",matematik,fizik,kimya,biyo,tarih,cografya,muzik);
        s10.addExamsNote(55,63,83,93,53,84,100);
        s10.addSozlu(90,77,66,55,77,55,90);
        s10.isPass();
    }
}