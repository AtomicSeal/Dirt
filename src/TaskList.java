import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {
    List<Task> lista = new ArrayList<Task>();
    public void addToList(Task taskToBeAdded){
        lista.add(taskToBeAdded);
    }
    public void printList(){
        if(lista.size()>0){
        int maxTitleLength=0;
        for (int l=0;l<lista.size();l++){
            if(lista.get(l).taskTitle.length()>maxTitleLength){
                maxTitleLength=lista.get(l).taskTitle.length();
            }
            else{

            }

        }
        String fullTableTitleText="                                                                                                                                                                             ";
        StringBuffer textToDisplay=new StringBuffer(fullTableTitleText);
        textToDisplay.insert(((maxTitleLength/2)-2),"Title");
        String finalTextToDisplay = textToDisplay.substring(0,maxTitleLength-1);
        String footerInfo="Lista tasków";
        int integerToPass=finalTextToDisplay.length();
        System.out.println("| Task ID |Creation date | Creation time | "+finalTextToDisplay+"  | Status");
        for(int i =0;i<lista.size();i++)
        {
            lista.get(i).printTaskTitles(maxTitleLength);

        }
        }
        else{

        }

    }
    public int returnSize(){
        return lista.size();
    }



}
