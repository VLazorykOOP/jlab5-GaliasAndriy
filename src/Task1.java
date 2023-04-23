import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {
    public static void task1() {
        String intEngineFile = "D:/Java_labs/jlab5-GaliasAndriy/files_engine/InternalEngine.txt";
        try {
            // Read data from intEngineFile
            ArrayList<String> lines = new ArrayList<String>();
            FileBufferedReader.moveLinesIntoArrayList(lines, intEngineFile); // Move file lines of data in ArrayList

            ArrayList<String> titles = new ArrayList<String>();
            ArrayList<String> fuels = new ArrayList<String>();
            ArrayList<Integer> cylinders =  new ArrayList<Integer>();
            ArrayList<Double> horsePowers =  new ArrayList<Double>();
            ArrayList<Double> torques = new ArrayList<Double>();
            ArrayList<Double> engineVolumes = new ArrayList<Double>();

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (i % 2 == 0) {
                    titles.add(line);
                } else {
                    String[] words = line.split("\\s+");
                    fuels.add(words[0]);
                    cylinders.add(Integer.parseInt(words[1]));
                    horsePowers.add(Double.parseDouble(words[2]));
                    torques.add(Double.parseDouble(words[3]));
                    engineVolumes.add(Double.parseDouble(words[4]));
                }
            }

            BaseEngine[] intEngines = new BaseEngine[titles.size()];

            for (int i = 0; i < titles.size(); i++) {
                intEngines[i] = new InternalCombustionEngine();
                if (titles.get(i) != "") {
                    intEngines[i].setTitle(titles.get(i));
                } else {
                    System.out.println("Wrong title " + titles.get(i));
                    System.out.println("Object not created!");
                    continue;
                }
                if (intEngines[i] instanceof InternalCombustionEngine) {
                    boolean isValid = false;
                    switch (fuels.get(i).toLowerCase()) {
                        case "petrol":
                        case "gasoline":
                        case "diesel":
                        case "cng":
                        case "compressed natural gas":
                        case "bio-diesel":
                        case "biodiesel":
                        case "lpg":
                        case "liquid petroleum gas":
                        case "ethanol":
                        case "methanol":
                        case "electricity":
                            ((InternalCombustionEngine) intEngines[i]).setFuelType(fuels.get(i));
                            isValid = true;
                            break;
                        default:
                            System.out.println(" Invalid fuel type entered.");
                    }
                    if (isValid == false) {
                        System.out.println("Object not created!");
                        continue;
                    }
                    if (cylinders.get(i) <= 2 || cylinders.get(i) >= 32 || cylinders.get(i) % 1 != 0) {
                        System.out.println("Wrong cylinders count value " + titles.get(i));
                        System.out.println("Object not created!");
                        continue;
                    } else {
                        ((InternalCombustionEngine) intEngines[i]).setCylinderCount(cylinders.get(i));
                    }
                    if (horsePowers.get(i) <= 30 || horsePowers.get(i) >= 2000) {
                        System.out.println("Wrong hp value " + horsePowers.get(i));
                        System.out.println("Object not created!");
                        continue;
                    } else {
                        ((InternalCombustionEngine) intEngines[i]).setHP(horsePowers.get(i));
                    }

                    if (torques.get(i) <= 70 || torques.get(i) >= 3000) {
                        System.out.println("Wrong torque value " + torques.get(i));
                        System.out.println("Object not created!");
                        continue;
                    } else {
                        ((InternalCombustionEngine) intEngines[i]).setTorque(torques.get(i));
                    }
                    if (engineVolumes.get(i) <= 0.5 || engineVolumes.get(i) >= 12.0) {
                        System.out.println("Wrong engine volume value " + engineVolumes.get(i));
                        System.out.println("Object not created!");
                        continue;
                    } else {
                        ((InternalCombustionEngine) intEngines[i]).setVolumeEngine(engineVolumes.get(i));
                    }
                }
            }
            System.out.println("\n All data received from " + intEngineFile);
            for (int i = 0; i < titles.size(); i++) {
                System.out.println("\nData about a [" + (i+1) + "] engine");
                System.out.println(intEngines[i].show());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + e.getMessage() + " was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
