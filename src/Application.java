import org.json.JSONException;
import service.FileScrubber;
import service.Ingestor;

/**
 * Created by i20762 on 7/13/2017.
 */
public class Application {
    public static void main(String args[]) throws JSONException {
        FileScrubber jl = new FileScrubber();
        Ingestor i = new Ingestor();
        String fileTxt= jl.getFileString("input/input.txt");
        i.build(fileTxt);

    }

}

