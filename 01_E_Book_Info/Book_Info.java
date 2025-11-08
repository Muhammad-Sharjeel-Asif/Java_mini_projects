import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Book_Info {
    String title;
    int noOfPages;
    String author;
    String category;
    float price;
    private static int numberOfBooks = 0;

    public Book_Info() {
        numberOfBooks++;
    }

    // Constructor Overloaded
    public Book_Info(String title, int noOfPages, String author, String category, float price) {
        numberOfBooks++;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.noOfPages = noOfPages;
    }

    public Book_Info(String title, String author, float price) {
        numberOfBooks++;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Category: " + this.category);
        System.out.println("Number of pages: " + this.noOfPages);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println();
    }

    public int numberOfBooks() {
        return this.numberOfBooks;
    }
}

class E_Book_Info extends Book_Info {
    String filePath;

    public E_Book_Info() {
        super();
    }

    public E_Book_Info(String title, int noOfPages, String author, String category, float price, String path) {
        super(title, noOfPages, author, category, price);
        filePath = path;
    }

    public E_Book_Info(String title, String author, float price, String path) {
        super(title, author, price);
        filePath = path;
    }

    public String displayBook(String path) throws IOException {
        File filePath = new File(path);
        Scanner reader = new Scanner(filePath);
        String line = "";

        while (reader.hasNext()) {
            String newline = reader.nextLine();
            line += newline + "\n";
        }
        reader.close();
        return line;
    }

    public void makePDF() throws IOException {

        Runtime.getRuntime().exec(new String[] {
                "cmd", "/c", "start", filePath + ".pdf\""
        });
    }
}
