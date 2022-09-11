import java.io.*;
import java.util.Scanner;

public class Projektor {

    static int counter;
    Header myHeader = new Header();
    Footer myFooter = new Footer();
    Scanner input=new Scanner(System.in);
    TaskList myTaskList = new TaskList();

    TaskList myTaskdes=null;
    public void loadTaskList(){
        try {
            FileInputStream fileIn = new FileInputStream("serialListy.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myTaskdes = (TaskList) in.readObject();
            in.close();
            fileIn.close();
            myTaskList=myTaskdes;
        }
        catch (Exception e) {
            System.out.println("Niepoprawny parametr, rozmiar tablicy to:");
        }


    }

    public void newTaskProject(String title,String footer){

        counter =myTaskList.returnSize();
        myHeader.printTitle(title);
        System.out.println();

        System.out.println("Enter name of your task");
        myFooter.displayFooter(footer);
        System.out.println("\033[?25h");
        String inputOne = input.nextLine();

        System.out.println("Enter description of your task");
        String inputTwo= input.nextLine();
        System.out.println("Enter deadline date in following format dd/mm/yyyy");
        String inputTree = input.nextLine();
        Task myTask=new Task(counter,inputOne,inputTwo,inputTree);

        myTaskList.addToList(myTask);


        serializationMethod(myTaskList);




    }
    public void taskListProject(String title,String footer){

        myHeader.printTitle(title);
        System.out.println();

        myTaskList.printList();
        System.out.println();
        myFooter.displayFooter("taskList");

    }
    public void editTask(String title,String footer){


        myHeader.printTitle(title);
        myTaskList.printList();
        System.out.println("Chose task you would like to edit");

        int x=Integer.parseInt(input.nextLine());
        System.out.print("\033[H\033[2J");
        myHeader.printTitle(myTaskList.lista.get(x).taskTitle);

        System.out.println("what would you like to do?");
        myFooter.displayFooter(footer);
        String userInput = input.nextLine();
        switch (userInput){
            case "a":
                System.out.println("Enter your comment below");
                String comment = input.nextLine();
                System.out.println("Chose type of comment");
                String type = input.nextLine();
                myTaskList.lista.get(x).addComment(comment,type,myTaskList.lista.get(x).comments.size());
                break;
            case "s":
                System.out.println("Which state would you like to switch task to");
                System.out.println("a for In progress");
                System.out.println("b for closed");
                myTaskList.lista.get(x).switchTaskState(input.nextLine());
            case "d":
                myTaskList.lista.get(x).printTask();
                System.out.println("which comment would you like to delete?");
                int s=Integer.parseInt(input.nextLine());
                myTaskList.lista.get(x).deleteComment(s);
            default:
                System.out.println("Please chose valid option");

        }

        myFooter.displayFooter(footer);
        serializationMethod(myTaskList);
    }
    public void openTaskProject(String title,String footer){
        myHeader.printTitle(title);
        myTaskList.printList();
        System.out.println("Chose task you would like to open");
        myFooter.displayFooter(footer);
        int x=Integer.parseInt(input.nextLine());
        System.out.print("\033[H\033[2J");
        myTaskList.lista.get(x).printTask();
        System.out.println();
        System.out.println("press anything to continue");
        input.nextLine();
    }
    public void serializationMethod(TaskList lista){
        try {
            FileOutputStream fileOut = new FileOutputStream("serialListy.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lista);
            out.close();
            fileOut.close();
        }
        catch (Exception e) {
            System.out.println("Niepoprawny parametr, rozmiar tablicy to:");
        }
    }
    public void deleteTaskFromList(){
        try{
            int taskToRemove = Integer.parseInt(input.nextLine());
            myTaskList.lista.remove(taskToRemove);
            for(int i=0;i<myTaskList.lista.size();i++){
                myTaskList.lista.get(i).taskId=i;

            }
            serializationMethod(myTaskList);
        }
        catch (Exception e) {
            System.out.println("Enter integer please");
        }



    }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");
    }
    public void hideCursor(){
        System.out.println("\033[?25l");

    }
}
