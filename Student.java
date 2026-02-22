public class Student {
    private int studID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String course;
    private int yearLevel;
    private String email;

    public Student(int studID, String firstName, String lastName, int age, String gender, String course, int yearLevel, String email){
        this.studID = studID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.yearLevel = yearLevel;
        this.email = email;
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
    public String getGender(){
        return gender;
    }
    public String getCourse(){
        return course;
    }
    public int getYearLevel(){
        return yearLevel;
    }
    public int getEmail(){
        return email;
    }
    
}