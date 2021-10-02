package Duke.Duke;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        List<String> al=new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line = sc.nextLine();
        al.add(line);
        while (line.equals("bye") == false) {
            al.remove("list");
            if(line.equals("list") == true){
                ListIterator<String> itr=al.listIterator();
                while(itr.hasNext()){
                    System.out.println((itr.nextIndex()+1)+". "+itr.next());
                }
            }
            if(line.equals("list") == false) {
                System.out.println("added: " + line);
            }
            line = sc.nextLine();
            al.add(line);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
