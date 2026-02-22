public class Student {
    private int studID;
    private String firstName;
    private String lastName;
    private int age;

    public Student(int studID, String firstName, String lastName, int age){
        this.studID = studID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    } 
    public int getStudID() {
        return studID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
}