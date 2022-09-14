import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings implements Serializable {

    String dateFormat;
    String titleFormating;
    String fontColour;
    String[] listViewArray;


    public Settings(String titleFormat){
        titleFormating = titleFormat;

    }
}
