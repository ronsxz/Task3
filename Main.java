import java.util.List;

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();
        repo.insertStudent(new Student(5, "Jamie", "Gayo", 19, "Feale", "BSIT", 2, "jamiegayo@gmail.com", 987654321, "Valenzuela City"));
        repo.SelectAll();
        
    }
}