package assignment5;
import java.util.Scanner;

public class urlGen {
    String title;
    public urlGen(String title) {
        this.title = title;
        generator();
    }
    public void generator() {
        String url = title.trim().replaceAll("\\s+", "/").replaceAll("[^a-zA-Z0-9/]", "").toLowerCase();
        System.out.println("Generated Url: " + url);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Title to generate URL: ");
        String inputTitle = sc.nextLine();
        new urlGen(inputTitle);
        sc.close();
    }
}
