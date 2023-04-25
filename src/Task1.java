import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void task1() {
        String intEngineFile = "D:/Java_labs/lab5_collections/jlab5-GaliasAndriy/files_engine/InternalEngine.txt";
        String dieselEngineFile = "D:/Java_labs/lab5_collections/jlab5-GaliasAndriy/files_engine/DieselEngine.txt";
        String jetEngineFile = "D:/Java_labs/lab5_collections/jlab5-GaliasAndriy/files_engine/JetEngine.txt";
        try {
            // Read data from intEngineFile
            List<String> lines = new ArrayList<String>();
            FileBufferedReader.moveLinesIntoArrayList(lines, intEngineFile); // Move file lines of data in ArrayList
            // Creating proper ArrayLists for values
            List<String> titles = new ArrayList<String>();
            List<String> fuels = new ArrayList<String>();
            List<Integer> cylinders =  new ArrayList<Integer>();
            List<Double> horsePowers =  new ArrayList<Double>();
            List<Double> torques = new ArrayList<Double>();
            List<Double> engineVolumes = new ArrayList<Double>();
            // Calling function which will create internalCombustionEngine objects
            CreateEngineObject.internalCombustionEngine(lines, titles, fuels, cylinders, horsePowers,
                    torques, engineVolumes, intEngineFile);
            // Clear all Array Lists
            lines.removeAll(lines);
            titles.removeAll(titles);
            fuels.removeAll(fuels);
            cylinders.removeAll(cylinders);
            horsePowers.removeAll(horsePowers);
            torques.removeAll(torques);
            engineVolumes.removeAll(engineVolumes);


            // Creating proper ArrayLists for values
            List<Integer> numberOfInjectors = new ArrayList<Integer>();
            // Read data from dieselEngineFile
            FileBufferedReader.moveLinesIntoArrayList(lines, dieselEngineFile);
            // Calling function which will create dieselEngine objects
            CreateEngineObject.dieselEngine(lines, titles, fuels, cylinders, horsePowers,
                    torques, engineVolumes, numberOfInjectors, dieselEngineFile);
            // Clear all Array Lists
            lines.removeAll(lines);
            titles.removeAll(titles);
            fuels.removeAll(fuels);
            cylinders.removeAll(cylinders);
            horsePowers.removeAll(horsePowers);
            torques.removeAll(torques);
            engineVolumes.removeAll(engineVolumes);
            numberOfInjectors.removeAll(numberOfInjectors);


            // Creating proper ArrayLists for values
            List<String> thrust = new ArrayList<String>();
            List<String> bypassRatio = new ArrayList<String>();
            // Read data from jetEngineFile
            FileBufferedReader.moveLinesIntoArrayList(lines, jetEngineFile);
            // Calling function which will create dieselEngine objects
            CreateEngineObject.jetEngine(lines, titles, bypassRatio, thrust, jetEngineFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + e.getMessage() + " was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
