import java.util.Scanner;

public class Dirt {
    public static void main(String[] args){
        Projektor projektor = new Projektor();
        Scanner input=new Scanner(System.in);

        projektor.loadTaskList();
        String os=System.getProperty("os.name");

        Boolean working =true;

        while(working){
            if (os.equals("Linux")){
                System.out.print("\033[H\033[2J");
            }
            else{
                System.out.print("\033\143");
                System.out.flush();
            }
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
                    working =false;
                    break;
                case "d":
                    projektor.deleteTaskFromList();
                    break;



            }




        }




    }
}
