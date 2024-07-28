public class Student {

    private String name ;
    private String stuID;

    public Student (){
        name = null;
        stuID = null;
    }

    public Student(String n, String id){
        name = n;
        stuID = id ;
    }

    //getter
    public String getName (){
        return name;
    }
    public String getStuID (){
        return stuID;
    }

    //setter
    public void setName(String n){
        name = n;
    }
    public void setStuID(String id){
        stuID = id;
    }

    public String toString(){
        return "\nName: " + name + "\nStudent Id: " + stuID;
    }

}
