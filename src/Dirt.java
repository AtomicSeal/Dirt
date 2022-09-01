import java.util.Scanner;

public class Dirt {
    public static void main(String[] args){
        Projektor projektor = new Projektor();
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.print("\033[H\033[2J");
            projektor.taskListProject("Dirt","taskList");
            System.out.println("\033[?25l");

            String userInput = input.nextLine();
            System.out.print("\033[H\033[2J");
            switch(userInput){
                case "a":
                    projektor.newTaskProject("New Task","taskCreation");
                    break;

                case "e":
                    projektor.addCommentProject("Commenting", "commenting");
                    break;

                case "o":
                    projektor.openTaskProject("Commenting", "commenting");
                    break;

            }




        }




    }
}
