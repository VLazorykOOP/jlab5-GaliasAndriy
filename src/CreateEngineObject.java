import java.util.*;

public class CreateEngineObject {
    public static void internalCombustionEngine (ArrayList<String> lines, ArrayList<String> titles, ArrayList<String> fuels,
                                                 ArrayList<Integer> cylinders, ArrayList<Double> horsePowers,
                                                 ArrayList<Double> torques, ArrayList<Double> engineVolumes,
                                                 String fileName) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i % 2 == 0) {
                titles.add(Character.toTitleCase(line.charAt(0)) + line.substring(1));
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
                System.out.println("Wrong title: " + titles.get(i));
            }
            if (intEngines[i] instanceof InternalCombustionEngine) {
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
                        break;
                    default:
                        System.out.println(" Invalid fuel type entered: " + fuels.get(i));
                }
                if (cylinders.get(i) <= 2 || cylinders.get(i) >= 32 || cylinders.get(i) % 1 != 0) {
                    System.out.println("Wrong cylinders count value: " + titles.get(i));
                } else {
                    ((InternalCombustionEngine) intEngines[i]).setCylinderCount(cylinders.get(i));
                }
                if (horsePowers.get(i) <= 30 || horsePowers.get(i) >= 2000) {
                    System.out.println("Wrong hp value: " + horsePowers.get(i));
                } else {
                    ((InternalCombustionEngine) intEngines[i]).setHP(horsePowers.get(i));
                }

                if (torques.get(i) <= 70 || torques.get(i) >= 3000) {
                    System.out.println("Wrong torque value: " + torques.get(i));
                } else {
                    ((InternalCombustionEngine) intEngines[i]).setTorque(torques.get(i));
                }
                if (engineVolumes.get(i) <= 0.5 || engineVolumes.get(i) >= 12.0) {
                    System.out.println("Wrong engine volume value: " + engineVolumes.get(i));
                } else {
                    ((InternalCombustionEngine) intEngines[i]).setVolumeEngine(engineVolumes.get(i));
                }
            }
        }
        System.out.println("\n All data received from " + fileName);
        for (int i = 0; i < titles.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(intEngines[i].show());
        }

        System.out.print("\n-------------------------------------------\nSort Internal Combustion Engines by title:\n" +
                "-------------------------------------------\n");
        List<BaseEngine> engineList = new ArrayList<>();
        for (int i = 0; i < intEngines.length; i++) {
            engineList.add(intEngines[i]);
        }
        Comparator<BaseEngine> comparator = Comparator.comparing(BaseEngine::getTitle);
        Collections.sort(engineList, comparator);
        for (int i = 0; i < engineList.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(engineList.get(i).show());
        }

        // Input data
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.println("\nEnter data about a new Internal Combustion engine:");
        while (!validInput) {
            try {
                System.out.print("Enter engine title: ");
                String title = scanner.nextLine();
                scanner.nextLine(); // consume leftover newline character
                System.out.print("Enter fuel type: ");
                String fuelType = scanner.nextLine().toLowerCase();
                System.out.print("Enter cylinder count: ");
                int cylinderCount = scanner.nextInt();
                System.out.print("Enter horse powers: ");
                double hp = scanner.nextDouble();
                System.out.print("Enter torque: ");
                double torque = scanner.nextDouble();
                System.out.print("Enter volume engine: ");
                double volumeEngine = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
                scanner.next();
            }
        }
        System.out.println("\nEnter data about a new Internal Combustion engine:");
        System.out.print("Enter engine title: ");
        String title = scanner.nextLine();
        System.out.print("Enter fuel type: ");
        String fuelType = scanner.nextLine().toLowerCase();
        System.out.print("Enter cylinder count: ");
        int cylinderCount = scanner.nextInt();
        System.out.print("Enter horse powers: ");
        double hp = scanner.nextDouble();
        System.out.print("Enter torque: ");
        double torque = scanner.nextDouble();
        System.out.print("Enter volume engine: ");
        double volumeEngine = scanner.nextDouble();

        BaseEngine newEngine = new InternalCombustionEngine();
        newEngine.setTitle(Character.toTitleCase(title.charAt(0)) + title.substring(1));
        if (newEngine instanceof InternalCombustionEngine) {
            switch (fuelType) {
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
                    ((InternalCombustionEngine) newEngine).setFuelType(fuelType);
                    break;
                default:
                    System.out.println(" Invalid fuel type entered: " + fuelType);
            }
            ((InternalCombustionEngine) newEngine).setCylinderCount(cylinderCount);
            ((InternalCombustionEngine) newEngine).setHP(hp);
            ((InternalCombustionEngine) newEngine).setTorque(torque);
            ((InternalCombustionEngine) newEngine).setVolumeEngine(volumeEngine);
        }
        engineList.add(newEngine);
        Collections.sort(engineList, comparator);

        System.out.print("\n-------------------------------------------\nSorting after adding a new engine:\n" +
                "-------------------------------------------\n");
        for (BaseEngine engine : engineList) {
            System.out.print("\nData about a [" + (engineList.indexOf(engine) + 1) + "] engine");
            System.out.println(engine.show());
        }
    }

    public static void dieselEngine (ArrayList<String> lines, ArrayList<String> titles, ArrayList<String> fuels,
                                     ArrayList<Integer> cylinders, ArrayList<Double> horsePowers,
                                     ArrayList<Double> torques, ArrayList<Double> engineVolumes,
                                     ArrayList<Integer> numberOfInjectors, String fileName) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i % 2 == 0) {
                titles.add(Character.toTitleCase(line.charAt(0)) + line.substring(1));
            } else {
                String[] words = line.split("\\s+");
                cylinders.add(Integer.parseInt(words[0]));
                horsePowers.add(Double.parseDouble(words[1]));
                torques.add(Double.parseDouble(words[2]));
                engineVolumes.add(Double.parseDouble(words[3]));
                numberOfInjectors.add(Integer.parseInt(words[4]));
            }
        }

        // Diesel engines
        BaseEngine[] dieselEngines = new BaseEngine[titles.size()];
        for (int i = 0; i < titles.size(); i++) {
            dieselEngines[i] = new DieselEngine();
            if (titles.get(i) != "") {
                dieselEngines[i].setTitle(titles.get(i));
            } else {
                System.out.println("Wrong title: " + titles.get(i));
            }
            if (dieselEngines[i] instanceof DieselEngine) {
                ((DieselEngine) dieselEngines[i]).setFuelType("Diesel");
                if (cylinders.get(i) <= 2 || cylinders.get(i) >= 32 || cylinders.get(i) % 1 != 0) {
                    System.out.println("Wrong cylinders count value: " + titles.get(i));
                }
                ((InternalCombustionEngine) dieselEngines[i]).setCylinderCount(cylinders.get(i));

                if (horsePowers.get(i) <= 30 || horsePowers.get(i) >= 2000) {
                    System.out.println("Wrong hp value: " + horsePowers.get(i));
                }
                ((InternalCombustionEngine) dieselEngines[i]).setHP(horsePowers.get(i));

                if (torques.get(i) <= 70 || torques.get(i) >= 3000) {
                    System.out.println("Wrong torque value: " + torques.get(i));
                }
                ((InternalCombustionEngine) dieselEngines[i]).setTorque(torques.get(i));

                if (engineVolumes.get(i) <= 0.5 || engineVolumes.get(i) >= 12.0) {
                    System.out.println("Wrong engine volume value: " + engineVolumes.get(i));
                }
                ((InternalCombustionEngine) dieselEngines[i]).setVolumeEngine(engineVolumes.get(i));

                if (numberOfInjectors.get(i) <=1 || numberOfInjectors.get(i) >= 32) {
                    System.out.println("Wrong numberOfInjectors value: " + engineVolumes.get(i));
                }
                ((DieselEngine) dieselEngines[i]).setNumberOfInjectors(numberOfInjectors.get(i));
            }
        }

        System.out.println("\n All data received from " + fileName);
        for (int i = 0; i < titles.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(dieselEngines[i].show());
        }

        System.out.print("\n-------------------------------------------\nSort Diesel Engines by title:\n" +
                "-------------------------------------------\n");
        List<BaseEngine> engineList = new ArrayList<>();
        for (int i = 0; i < dieselEngines.length; i++) {
            engineList.add(dieselEngines[i]);
        }
        Comparator<BaseEngine> comparator = Comparator.comparing(BaseEngine::getTitle);
        Collections.sort(engineList, comparator);
        for (int i = 0; i < engineList.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(engineList.get(i).show());
        }

        System.out.println("\nEnter data about a new Internal Combustion engine:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter engine title: ");
        String title = scanner.nextLine();
        String fuelType = "Diesel";
        System.out.print("Enter cylinder count: ");
        int cylinderCount = scanner.nextInt();
        System.out.print("Enter horse powers: ");
        double hp = scanner.nextDouble();
        System.out.print("Enter torque: ");
        double torque = scanner.nextDouble();
        System.out.print("Enter volume engine: ");
        double volumeEngine = scanner.nextDouble();
        System.out.print("Enter number of injectors");
        int numOfInjectors = scanner.nextInt();

        BaseEngine newEngine = new DieselEngine();
        newEngine.setTitle(Character.toTitleCase(title.charAt(0)) + title.substring(1));
        if (newEngine instanceof DieselEngine) {
            switch (fuelType) {
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
                    ((InternalCombustionEngine) newEngine).setFuelType(fuelType);
                    break;
                default:
                    System.out.println(" Invalid fuel type entered: " + fuelType);
            }
            ((DieselEngine) newEngine).setCylinderCount(cylinderCount);
            ((DieselEngine) newEngine).setHP(hp);
            ((DieselEngine) newEngine).setTorque(torque);
            ((DieselEngine) newEngine).setVolumeEngine(volumeEngine);
            ((DieselEngine) newEngine).setNumberOfInjectors(numOfInjectors);
        }
        engineList.add(newEngine);
        Collections.sort(engineList, comparator);

        System.out.print("\n-------------------------------------------\nSorting after adding a new engine:\n" +
                "-------------------------------------------\n");
        for (BaseEngine engine : engineList) {
            System.out.print("\nData about a [" + (engineList.indexOf(engine) + 1) + "] engine");
            System.out.println(engine.show());
        }
    }

    public static void jetEngine (ArrayList<String> lines, ArrayList<String> titles, ArrayList<String> bypassRatio,
                                  ArrayList<String> thrust, String fileName) {
        int k = 0;
        while (k < lines.size()) {
            titles.add(Character.toTitleCase(lines.get(k).charAt(0)) + lines.get(k).substring(1));
            k++;
            bypassRatio.add(lines.get(k));
            k++;
            thrust.add(lines.get(k));
            k++;
        }

        BaseEngine[] jetEngines = new BaseEngine[titles.size()];
        for (int i = 0; i < titles.size(); i++) {
            jetEngines[i] = new ReactiveEngine();

            if (titles.get(i) != "") {
                jetEngines[i].setTitle(titles.get(i));
            } else {
                System.out.println("Wrong title: " + titles.get(i));
            }

            if (jetEngines[i] instanceof ReactiveEngine) {
                if (bypassRatio.get(i).isEmpty()) {
                    System.out.println("Empty setBypassRatio value: " + bypassRatio.get(i));
                }
                ((ReactiveEngine) jetEngines[i]).setBypassRatio(bypassRatio.get(i));
                if (thrust.get(i).isEmpty()) {
                    System.out.println("Empty thrust value: " + thrust.get(i));
                }
                ((ReactiveEngine) jetEngines[i]).setThrust(thrust.get(i));
            }
        }
        System.out.println("\n All data received from " + fileName);
        for (int i = 0; i < titles.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(jetEngines[i].show());
        }

        System.out.print("\n-------------------------------------------\nSort Jet Engines by title:\n" +
                "-------------------------------------------\n");
        List<BaseEngine> engineList = new ArrayList<>();
        for (int i = 0; i < jetEngines.length; i++) {
            engineList.add(jetEngines[i]);
        }
        Comparator<BaseEngine> comparator = Comparator.comparing(BaseEngine::getTitle);
        Collections.sort(engineList, comparator);
        for (int i = 0; i < engineList.size(); i++) {
            System.out.print("\nData about a [" + (i+1) + "] engine");
            System.out.println(engineList.get(i).show());
        }

        System.out.println("\nEnter data about a new engine:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter engine title: ");
        String title = scanner.nextLine();
        System.out.print("Enter engine bypass ratio: ");
        String bypassR = scanner.nextLine();
        System.out.print("Enter engine thrust: ");
        String thrustV = scanner.nextLine();

        BaseEngine newEngine = new ReactiveEngine();
        newEngine.setTitle(Character.toTitleCase(title.charAt(0)) + title.substring(1));
        if (newEngine instanceof ReactiveEngine) {
            ((ReactiveEngine) newEngine).setBypassRatio(bypassR);
            ((ReactiveEngine) newEngine).setThrust(thrustV);
        }
        engineList.add(newEngine);
        Collections.sort(engineList, comparator);

        System.out.print("\n-------------------------------------------\nSorting after adding a new engine:\n" +
                "-------------------------------------------\n");
        for (BaseEngine engine : engineList) {
            System.out.print("\nData about a [" + (engineList.indexOf(engine) + 1) + "] engine");
            System.out.println(engine.show());
        }
    }
}