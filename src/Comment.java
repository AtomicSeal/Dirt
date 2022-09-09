import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comment implements Serializable {
    String commentText;
    String commentType;
    int commentId;
    LocalDate commentCreationDate = LocalDate.now();
    LocalTime commentCreationTime;
    public Comment(String text,String type,int idCount){
        commentText=text;
        commentType=type;
        commentId=idCount;
        commentCreationDate = LocalDate.now();
        commentCreationTime = LocalTime.now();
    }
    public void displayTaskComments(){
        System.out.println("CommentID: "+commentId+"    "+ commentCreationDate+" "+ commentCreationTime+" "+commentText);
        System.out.println("        Type: "+commentType);
        System.out.println("");
    }
}
