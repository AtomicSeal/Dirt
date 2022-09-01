public class Footer {
    public void displayFooter(String footerToDisplay){
        System.out.println();
        switch (footerToDisplay){
            case "mainMenu":
                System.out.println("a:new task   e:edit task   l:list tasks");
                break;
            case "taskCreation":
                break;
            case "taskList":
                System.out.println("a:new task   e:edit task   l:list tasks   o: open task");
                break;
            case "commenting":
                System.out.println("b: back");

        }

    }
}
