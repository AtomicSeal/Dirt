import com.sun.management.DiagnosticCommandMBean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    LocalDate creationDate;
    LocalTime creationTime;
    LocalDate ticketDeadLine;
    public Task(int counter, String Title,String Description,String deadLine){
        taskTitle=Title;
        taskDescrition=Description;
        taskId=counter;
        taskState="New";
        creationDate=LocalDate.now();
        creationTime = LocalTime.now();
        if(!deadLine.equals("")){
            String[] splitedDeadline = deadLine.split("/");
            ticketDeadLine=LocalDate.of(Integer.parseInt(splitedDeadline[2]),Integer.parseInt(splitedDeadline[1]),Integer.parseInt(splitedDeadline[0]));
        }
        else{

        }


    }

    public void addComment(String comment,String type,int id ){
        Comment myComment = new Comment(comment,type,id);
        comments.add(myComment);
    }
    public void deleteComment(int toBeDeleted){
        comments.remove(toBeDeleted);
        for(int i=0;i<comments.size();i++){
            comments.get(i).commentId=i;
        }
    }


    public void printTaskTitles(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("| Task ID |Creation date | Creation time | Title  | Status");
        System.out.println("|    "+taskId+"    |  "+creationDate+"  |    "+creationTime.format(dtf)+"   | "+taskTitle+ " | "+ taskState);

    }
    public void printTask(){
        System.out.println(taskId+" "+taskTitle);
        System.out.println();
        System.out.println("Description: "+taskDescrition);
        System.out.println("Status" + " "+ taskState);
        System.out.println("Due date: "+ticketDeadLine);
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
