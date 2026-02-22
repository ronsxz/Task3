import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String url = "jdbc:sqlite:Studentss.db";
    
    public void SelectAll(){
        List<Student>studentList = new ArrayList<>();
        String sql = "SELECT * FROM tableStudent";
        
        try (Connection conn = connection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("studentID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("course"),
                        rs.getInt("yearLevel"),
                        rs.getString("email"),
                        rs.getInt("contactNumber"),
                        rs.getString("address")
                );
                studentList.add(student);
            }   
            System.out.println("========================================================== MASTER LIST OF STUDENTS ===========================================================");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-5s %-8s %-10s %-10s %-30s %-15s %-20s%n", "StudentID", "FirstName", "LastName", "Age", "Gender", "Course", "YearLevel", "Email", "ContactNo", "Address");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                        
            for (Student s : studentList) {
            System.out.printf(
                    "%-10d %-15s %-15s %-5d %-8s %-10s %-10d %-30s %-15d %-20s%n",
                    s.getStudID(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getAge(),
                    s.getGender(),
                    s.getCourse(),
                    s.getYearLevel() ,
                    s.getEmail(),
                    s.getContactNumber(),
                    s.getAddress()); 
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public Connection connection(){
        String url = "jdbc:sqlite:Studentss.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }       
    public void insertStudent(Student student) {

        String sql = "INSERT OR IGNORE INTO tableStudent "
                + "(studentID, firstName, lastName, age, gender, course, yearLevel, email, contactNumber, address) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getStudID());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setInt(4, student.getAge());
            pstmt.setString(5, student.getGender());
            pstmt.setString(6, student.getCourse());
            pstmt.setInt(7, student.getYearLevel());
            pstmt.setString(8, student.getEmail());
            pstmt.setInt(9, student.getContactNumber());
            pstmt.setString(10, student.getAddress());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}