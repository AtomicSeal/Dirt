public class Footer {
    public void displayFooter(String footerToDisplay){
        System.out.println();
        switch (footerToDisplay){
            case "mainMenu":
                System.out.println("a:new task   e:edit task   l:list tasks");
                break;
            case "taskCreation":
                System.out.println("b: back");
                break;
            case "taskList":
                System.out.println("a:new task   e:edit task   l:list tasks   o: open task  q: quit prgram  ");
                break;
            case "editTask":
                System.out.println("a: addComment   s: Switch state");

        }

    }
}
