package Duke.Duke;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Duke{
    public static void main(String[] args) {
        int i = 0;
        CtoJava[] tasks = new CtoJava[100];
        List<String> al=new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line = sc.nextLine();
        tasks[i] = new CtoJava(line);
        al.add(line);
        while (line.equals("bye") == false) {
            al.remove("list");
            al.remove("done");
            if(line.equals("list") == true){
                ListIterator<String> itr=al.listIterator();
                while(itr.hasNext()){
                    System.out.println((itr.nextIndex()+1)+".[" + tasks[i].getStatusIcon() +"] "+itr.next());
                }
            }
            if(line.equals("list") == false && line.equals("done") == false) {
                System.out.println("added: " + line);
            }
            line = sc.nextLine();
            al.add(line);
            if (line.equals("done") == true) {
                int number = sc.nextInt();
                tasks[i].Check(line);
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("[" + tasks[i].getStatusIcon() + "] " + al.get(number - 1));
                break;
            }

        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}

