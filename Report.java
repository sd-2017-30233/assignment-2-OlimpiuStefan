package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public interface Report {
    public void generate(ArrayList<String> titles) throws FileNotFoundException;
}
