import java.util.ArrayList;
import java.io.*;

public class FileBufferedReader {
    public static void moveLinesIntoArrayList(ArrayList<String> lines, String fileName)
            throws IOException {
        // open a file for reading
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue; // skip empty lines
            }
            lines.add(line);
        }
        reader.close(); // close a file
    }
}