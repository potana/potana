import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line = sc.nextLine();
        while(line.equals("bye") == false)
        {
            System.out.println(line);
            line = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
