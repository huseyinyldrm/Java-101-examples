public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int note;
    int sozlu;

    Course(String name,String prefix,String code){
        this.name=name;
        this.code=code;
        this.prefix=prefix;
    }
    void  addTeacher(Teacher t){
        if(this.prefix.equals(t.branch)){
            this.courseTeacher=t;
        }
        else {
            System.out.println(t.name+" Akademisyeni bu dersi veremez.");
        }
    }

}
