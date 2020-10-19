import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Painting> paintings = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        String selecteditem = "";

        System.out.println();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Select what kind of items you want to store in JSON file\nType 1 for books\nType 2 for paintings\nType 3 for movies\n");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice!=1 && choice!=2 && choice!=3) throw new Exception("Incorrect input");
            switch (choice) {
                case 1:
                    selecteditem = "book"; break;
                case 2:
                    selecteditem = "painting"; break;
                case 3:
                    selecteditem = "movie"; break;
            }
            System.out.println("Select how many "+ selecteditem +"s you want to store\n");
            int number = Integer.parseInt(scanner.nextLine());
            if(number<=0) throw new Exception("Incorrect input");
            for (int i = 0; i < number; i++) {
                System.out.println("Enter " + selecteditem +" title");
                String title = scanner.nextLine();
                System.out.println("Enter "+ selecteditem + "author");
                String author = scanner.nextLine();
                switch (choice) {
                    case 1:
                        books.add(new Book(title, author)); break;
                    case 2:
                        paintings.add(new Painting(title, author)); break;
                    case 3:
                        movies.add(new Movie(title, author)); break;
                }
            }
            Gson gson = new Gson();
            switch (choice) {
                case 1:
                    String booksjson = gson.toJson(books);
                    System.out.println(booksjson);
                    break;
                case 2:
                    String paintingsjson = gson.toJson(paintings);
                    System.out.println(paintingsjson);
                    break;
                case 3:
                    String moviesjson = gson.toJson(movies);
                    System.out.println(moviesjson);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
