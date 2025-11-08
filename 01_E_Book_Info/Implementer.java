import java.io.IOException;

public class Implementer {
    public static void main(String[] args) throws IOException {
        Book_Info books = new Book_Info();
        System.out.println("Total books are: " + books.numberOfBooks() + "\n"); 

        String path = "E:\\Programming\\Java\\Assigenments\\01_E_Book_Info\\Assignments";
        
        E_Book_Info b1 = new E_Book_Info("Assignment", "MSA", (float) 1.5, path);

        System.out.println("Book Information:");
        b1.displayBookInfo();

        String displayBook = b1.displayBook(path + ".txt");
        System.out.println(displayBook);

        b1.makePDF();        
    }
}
