import com.sun.management.DiagnosticCommandMBean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.*;

public class Task implements Serializable {

    static int counter;
    String taskTitle;
    String taskDescrition;
    String taskState;
    int taskId;
    List<Comment> comments = new ArrayList<Comment>();
    public Task(int counter, String Title,String Description){
        taskTitle=Title;
        taskDescrition=Description;
        taskId=counter;
        taskState="New";
        LocalDate creationDate=LocalDate.now();
        LocalTime creationTime = LocalTime.now();

    }

    public void addComment(String comment,String type ){
        Comment myComment = new Comment(comment,type);
        comments.add(myComment);
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
            comments.get(i).displayTaskComments();
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
