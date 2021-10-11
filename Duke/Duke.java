package Duke.Duke;

import java.util.Scanner;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Duke{

    public static ArrayList<Task> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File f = new File("data/duke.txt");
        System.out.println("full path: " + f.getAbsolutePath());
        System.out.println("file exists?: " + f.exists());
        System.out.println("is Directory?: " + f.isDirectory());
        ArrayList<String> arr = new ArrayList<String>();
        arr = new ArrayList<String>();
        arr.add("morning");
        System.out.println("Hello I'm Duke! \nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (! line.toLowerCase().equals("bye")) {
            checkList(line);
            if (line.equals("list")) {
                getlist();
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
        writeListToFile();
    }

    /**
     * Returns all the task in the array arr back into the console
     *
     * @return number of task in the arrayList.
     */
    private static void getlist(){
        System.out.println("Here are the tasks in your list:");
        int index  = 1;
        for (Task task : arr) {
            System.out.println(String.format(index + ". " + task.toString()));
            index++;
        }
    }

    /**
     * Takes the num and marks the task as done
     * by replacing the " " with a "X"
     *
     * @param num number in the arrayList
     */
    private static void markAsDone(int num){
        if (num <= 0 || num > arr.size() ) {
            System.out.println("OOPS!!! Number is out of range");
        } else {
            arr.get(num-1).hasDone();
            arr.get(num-1).hasDone();

            printDoneTask(arr.get(num-1));
        }
    }

    /**
     * The adds a task into the arrayList
     *
     * @param taskName the name of the task.
     */
    private static void addToDo(String taskName) {
        Todo newTodo = new Todo(taskName);
        arr.add(newTodo);
        printAddedTask();
    }

    /**
     * Prints into the system when a task is mark as done
     *
     * @param t is the task that is marked to be done
     */
    private static void printDoneTask(Task t) {
        System.out.println("Nice! I've marked this task as done");
        System.out.println(String.format("    %s", t));
    }

    /**
     * Prints out that a task has been added
     */
    private static void printAddedTask() {
        System.out.println("Got it. I've added this task: ");
        System.out.println(String.format("    %s", arr.get(arr.size()-1).toString()));
        System.out.println(String.format("Now you have %d tasks in the list.", arr.size()));
    }

    /**
     * Prints out that a task has been removed
     */
    private static void printRemoveTask(Task t) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(String.format("    %s",t));
        System.out.println(String.format("Now you have %d tasks in the list.", arr.size()));
    }

    /**
     * Adds a deadline into the arrayList task
     *
     * @param taskName name to register the task by
     * @param dateTime the time of the deadline
     */
    private static void addDeadline(String taskName, String dateTime) {
        LocalDateTime dateTimeObj = parseDateTime(dateTime);
        Deadline deadline = new Deadline(taskName,dateTimeObj);
        arr.add(deadline);
        printAddedTask();
    }

    /**
     * Adds an event into the arrayList task
     *
     * @param taskName name to register the task by
     * @param dateTime the time of the event
     */
    private static void addEvent(String taskName, String dateTime) {
        LocalDateTime dateTimeObj = parseDateTime(dateTime);
        Event event = new Event(taskName, dateTimeObj);
        arr.add(event);
        printAddedTask();
    }

    /**
     * removes a task from the arrayList
     *
     * @param number the number of the task it is located at
     */
    private static void removeTask(int number) {
        Task removeTask = arr.remove(number-1);
        printRemoveTask(removeTask);
    }

    /**
     * checks if the input has any errors
     * and notifies the user
     *
     * @param line the input of the user
     */
    private static void checkList(String line){
        if(!line.split(" ")[0].equals("done") &&
                !line.split(" ")[0].equals("delete") &&
                !line.split(" ")[0].equals("event") &&
                !line.split(" ")[0].equals("deadline") &&
                !line.split(" ")[0].equals("todo") &&
                !line.split(" ")[0].equals("list")){
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        else if(line.split("   ")[0].equals("todo"))
        {
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * Changes the content of duke.txt by appending information into it
     *
     * @throws IOException Java exception which occurs when an IO operations fails
     */
    private static void writeListToFile() throws IOException {
        FileWriter fw = new FileWriter("data/duke.txt");
        StringBuilder sb = new StringBuilder();
        for (Task entry : arr) {
            if (entry instanceof Deadline) {
                sb.append(String.format("D | %s | %s | %s", entry.hasDone() ? "1" : "0",
                        entry.getTaskName(), ((Deadline) entry).getDatetime() ));
            } else if (entry instanceof Event) {
                sb.append(String.format("E | %s | %s | %s", entry.hasDone() ? "1" : "0",
                        entry.getTaskName(), ((Event) entry).getDatetime() ));
            } else if (entry instanceof Todo) {
                sb.append(String.format("T | %s | %s", entry.hasDone() ? "1" : "0",
                        entry.getTaskName() ));
            }

            sb.append(System.lineSeparator());
            fw.write(sb.toString());
            sb = new StringBuilder();
        }

        fw.close();

    }

    /**
     * Returns the time in another format.
     *
     * @param datetime the user input for time in any format
     * @return the date time in year month and day
     */
    private static LocalDateTime parseDateTime(String datetime) {
        int spaceIndex = datetime.indexOf(" ");
        String[] stringArr = datetime.split("/");

        int day = Integer.parseInt(stringArr[0]);
        int month = Integer.parseInt(stringArr[1]);
        int year = Integer.parseInt(stringArr[2]);
        return LocalDateTime.of(year,month,day,0,0);
    }
}