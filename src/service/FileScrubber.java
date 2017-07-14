package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Objects;

/**
 * Created by i20762 on 7/13/2017.
 */
public class FileScrubber {
    JSONObject events;


    public String getFileString(String fileLocation) {
        InputStream is = null;
        String opString = null;
        try {
            is = new FileInputStream(fileLocation);

            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            opString = sb.toString();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opString;
    }


}