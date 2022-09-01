import java.util.Scanner;

public class Projektor {
    Header myHeader = new Header();
    Footer myFooter = new Footer();
    Scanner input=new Scanner(System.in);
    TaskList myTaskList = new TaskList();

    public void newTaskProject(String title,String footer){


        myHeader.printTitle(title);
        System.out.println();

        System.out.println("Enter name of your task");
        String inputOne = input.nextLine();
        System.out.println("Enter description of your task");
        String inputTwo= input.nextLine();

        Task myTask=new Task(inputOne,inputTwo);

        myTaskList.addToList(myTask);

        myFooter.displayFooter(footer);
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
