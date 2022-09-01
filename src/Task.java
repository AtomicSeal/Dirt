import java.util.ArrayList;
import java.util.List;

public class Task {
    static int counter;
    String taskTitle;
    String taskDescrition;
    int taskId;
    List comments = new ArrayList();
    public Task(String Title,String Description){
        taskTitle=Title;
        taskDescrition=Description;
        taskId=counter;
        counter++;
    }
    public void addComment(String comment){
        comments.add(comment);
    }


    public void printTaskTitles(){
        System.out.println(taskId+" "+taskTitle);

    }
    public void printTask(){
        System.out.println(taskId+" "+taskTitle);
        System.out.println();
        System.out.println(taskDescrition);
        for(int i=0;i<comments.size();i++){
            System.out.println("    "+comments.get(i));
        }


    }
}
