import java.io.File;
import java.util.Scanner;

public class Dirt {
    public static void main(String[] args){


        File f = new File("serialSettings.ser");
        if(f.exists() && !f.isDirectory()) {

        }




        Projektor projektor = new Projektor();
        Scanner input=new Scanner(System.in);

        projektor.loadTaskList();

        Boolean working =true;

        while(working){
            projektor.taskListProject("Dirt","taskList");
            System.out.println("\033[?25l");

            String userInput = input.nextLine();
            System.out.print("\033[H\033[2J");

            switch(userInput){
                case "a":
                    projektor.newTaskProject("New Task","taskCreation");
                    break;

                case "e":
                    projektor.editTask("Commenting", "editTask");
                    break;

                case "o":
                    projektor.openTaskProject("Commenting", "commenting");
                    break;
                case "q":
                    System.out.println("\033[?25h");
                    working =false;
                    break;
                case "d":
                    projektor.deleteTaskFromList();
                    break;
                case "s":
                    projektor.settingsScreen();


            }




        }




    }
}
