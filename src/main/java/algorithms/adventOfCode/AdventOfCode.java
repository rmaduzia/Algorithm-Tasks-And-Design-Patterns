package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class AdventOfCode {

    public abstract int getFirstPartSolution();
    public abstract int getSecondPartSolution();

    public String getInputPath() {
        String packageName = getClass().getPackageName();
        String className = getClass().getSimpleName();

        return "src/main/resources/" +
            packageName.replace('.', '/') + "/" +
            className + ".txt";
    }
    
    
    public List<String> getInputDataAsListOfString() {
        List<String> dataFromFile = new ArrayList<>();
        System.out.println(getInputPath());
        try {
            dataFromFile = Files.readAllLines(Paths.get(getInputPath()));
        } catch (IOException ioException) {
            System.out.println("Couldn't find input data. Used path: " + getInputPath());
        }
        
        return dataFromFile;
    }

}