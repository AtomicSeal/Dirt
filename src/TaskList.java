import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> lista = new ArrayList<Task>();
    public void addToList(Task taskToBeAdded){
        lista.add(taskToBeAdded);
    }
    public void printList(){
        String footerInfo="Lista tasków";
        for(int i =0;i<lista.size();i++){
            lista.get(i).printTaskTitles();

        }

    }


}