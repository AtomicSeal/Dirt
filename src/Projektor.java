import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            FileInputStream fileIn = new FileInputStream("/home/foka/Disk1/Programowanko/Java/DirtRelated/Dirt/serialListy.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myTaskdes = (TaskList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Elo mordo załadowane");
            myTaskdes.printList();
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
        String inputOne = input.nextLine();
        System.out.println("Enter description of your task");
        String inputTwo= input.nextLine();

        Task myTask=new Task(counter,inputOne,inputTwo);

        myTaskList.addToList(myTask);

        myFooter.displayFooter(footer);
        try {
            FileOutputStream fileOut = new FileOutputStream("serialListy.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myTaskList);
            out.close();
            fileOut.close();
            System.out.println("Elo mordo zapisane");
        }
        catch (Exception e) {
            System.out.println("Niepoprawny parametr, rozmiar tablicy to:");
        }

    }
    public void taskListProject(String title,String footer){

        myHeader.printTitle(title);
        System.out.println();

        myTaskList.printList();
        System.out.println();
        myFooter.displayFooter("taskList");

    }
    public void addCommentProject(String title,String footer){


        myHeader.printTitle(title);
        myTaskList.printList();
        System.out.println("Chose task you would like to add comment to");

        myFooter.displayFooter(footer);

        int x=Integer.parseInt(input.nextLine());
        System.out.print("\033[H\033[2J");
        myHeader.printTitle(myTaskList.lista.get(x).taskTitle);

        System.out.println("Enter you comment");
        String comment = input.nextLine();
        myTaskList.lista.get(x).addComment(comment);
        myFooter.displayFooter(footer);
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

}
