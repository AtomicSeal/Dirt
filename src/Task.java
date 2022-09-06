import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task implements Serializable {

    static int counter;
    String taskTitle;
    String taskDescrition;
    String state;
    int taskId;
    List comments = new ArrayList();
    public Task(int counter, String Title,String Description){
        taskTitle=Title;
        taskDescrition=Description;
        taskId=counter;

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
        System.out.println(state);
        for(int i=0;i<comments.size();i++){
            System.out.println("    "+comments.get(i));
        }


    }

}
