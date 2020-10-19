import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        System.out.println();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Select how many books you want to store\n");
            int number = Integer.parseInt(scanner.nextLine());
            if(number<=0) throw new Exception("Incorrect input");
            for (int i = 0; i < number; i++) {
                System.out.println("Enter book title");
                String title = scanner.nextLine();
                System.out.println("Enter book's author first name");
                String author_first_name = scanner.nextLine();
                System.out.println("Enter book's author surname");
                String author_name = scanner.nextLine();
                System.out.println("Enter book's author year of birth [AD only]");
                int author_year_of_birth = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter book's publisher");
                String publisher = scanner.nextLine();
                System.out.println("Enter book's year of print"); // komentarz

                int year_of_print = Integer.parseInt(scanner.nextLine());
                books.add(new Book(title, new Author(author_first_name,author_name,author_year_of_birth),new Release(publisher, year_of_print)));
                }
            Gson gson = new Gson();
            String booksjson = gson.toJson(books);
            System.out.println(booksjson);
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
