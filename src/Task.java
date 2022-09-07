import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task implements Serializable {

    static int counter;
    String taskTitle;
    String taskDescrition;
    String taskState;
    int taskId;
    List<String> comments = new ArrayList<String>();
    public Task(int counter, String Title,String Description){
        taskTitle=Title;
        taskDescrition=Description;
        taskId=counter;
        taskState="New";

    }

    public void addComment(String comment){
        comments.add(comment);
    }


    public void printTaskTitles(){
        System.out.println(taskId+" "+taskTitle+ " "+ taskState);

    }
    public void printTask(){
        System.out.println(taskId+" "+taskTitle);
        System.out.println();
        System.out.println(taskDescrition);
        System.out.println("Status" + " "+ taskState);
        for(int i=0;i<comments.size();i++){
            System.out.println("    "+comments.get(i));
        }


    }
    public void switchTaskState(String x){
        switch (x){
            case "a":
                taskState="In Progress";
                break;
            case "b":
                taskState="Closed";
                break;

        }
    }

}
