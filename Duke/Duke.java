package Duke.Duke;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import java.util.Scanner;
import java.util.ArrayList;


public class Duke{

    public static ArrayList<Task> arr = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr = new ArrayList<String>();
        arr.add("morning");
        System.out.println("Hello I'm Duke! \nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (! line.toLowerCase().equals("bye")) {
            checkList(line);
            if (line.equals("list")) {
                list(line);
            } else if (line.split(" ")[0].equals("done")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                markAsDone(num);
            } else if (line.split(" ")[0].equals("todo")){
                int spaceIndex = line.indexOf(" ");
                addToDo(line.substring(spaceIndex+1));
            } else if (line.split(" ")[0].equals("deadline")) {
                int spaceIndex = line.indexOf(" ");
                int backslashIndex = line.indexOf("/");
                addDeadline(line.substring(spaceIndex+1, backslashIndex-1), line.substring(backslashIndex+4));
            } else if (line.split(" ")[0].equals("event")) {
                int spaceIndex = line.indexOf(" ");
                int backslashIndex = line.indexOf("/");
                addEvent(line.substring(spaceIndex+1, backslashIndex-1), line.substring(backslashIndex+4));
            }else if (line.split(" ")[0].equals("delete")) {
                removeTask(Integer.parseInt(line.split(" ")[1]));
            }
            line = sc.nextLine();
        }
        System.out.println("Bye. Hope to see you again!");
    }

    public static void list(String command) {
        System.out.println("Here are the tasks in your list:");
        int index  = 1;
        for (Task task : arr) {
            System.out.println(String.format(index + ". " + task.toString()));
            index++;
        }
    }

    public static void markAsDone(int num) {
        if (num <= 0 || num > arr.size() ) {
            System.out.println("Number is out of range");
        } else {
            arr.get(num - 1).done();
        }
    }

    public static void addToDo(String taskName) {
        Todo newTodo = new Todo(taskName);
        arr.add(newTodo);
        printAddedTask();
    }

    public static void printAddedTask() {
        System.out.println("Got it. I've added this task: ");
        System.out.println(String.format("    %s", arr.get(arr.size()-1).toString()));
        System.out.println(String.format("Now you have %d tasks in the list.", arr.size()));
    }

    public static void printRemoveTask(Task t) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(String.format("    %s",t));
        System.out.println(String.format("Now you have %d tasks in the list.", arr.size()));
    }
    public static void addDeadline(String taskName, String datetime) {
        Deadline deadline = new Deadline(taskName,datetime);
        arr.add(deadline);
        printAddedTask();
    }

    public static void addEvent(String taskName, String datetime) {
        Event event = new Event(taskName, datetime);
        arr.add(event);
        printAddedTask();
    }
    public static void removeTask(int number) {
        Task rmv_t = arr.remove(number-1);
        printRemoveTask(rmv_t);
    }
    public static void checkList(String line){
        if(!line.split(" ")[0].equals("done") &&
                !line.split(" ")[0].equals("delete") &&
                !line.split(" ")[0].equals("event") &&
                !line.split(" ")[0].equals("deadline") &&
                !line.split(" ")[0].equals("todo")){
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        else if(line.split("   ")[0].equals("todo"))
        {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }
}