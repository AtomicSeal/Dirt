import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comment implements Serializable {
    String commentText;
    String commentType;
    LocalDate commentCreationDate = LocalDate.now();
    LocalTime commentCreationTime;
    public Comment(String text,String type){
        commentText=text;
        commentType=type;
        commentCreationDate = LocalDate.now();
        commentCreationTime = LocalTime.now();
    }
    public void displayTaskComments(){
        System.out.println("    "+ commentCreationDate+" "+ commentCreationTime+" "+commentText);
        System.out.println("        Type: "+commentType);
        System.out.println("");
    }
}
