package algorithms.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdventDay8 {

    public static int getResultAdventDay8Part1() throws IOException {

        int globalAcc = 0;
        int pc = 0;

        List<Integer> visitedPCs = new ArrayList<>();

        List<String> dataFromFiles = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay8.txt"));


        boolean run = true;

        while(run) {
            visitedPCs.add(pc);
            String op = dataFromFiles.get(pc);
            String[] opAndArgs = op.split(" ");
            switch (opAndArgs[0]) {
                case "nop":
                    pc++;
                    break;
                case "acc":
                    globalAcc += Integer.parseInt(opAndArgs[1]);
                    pc++;
                    break;
                case "jmp":
                    pc += Integer.parseInt(opAndArgs[1]);
                    break;
            }

            if (visitedPCs.contains(pc)) {
                run = false;
            }

        }

        return globalAcc;

    }


    public static int getResultAdventDay8Part2() throws IOException {

        List<String> dataFromFiles = Files.readAllLines(Paths.get("src/main/resources/inputs/adventOfCode/adventOfCodeDay8.txt"));

        Result result = execute(dataFromFiles);

        boolean run = true;
        int index = 0;
        String old = "";
        Result result2;
        do {

            boolean found = false;
            while(!found && index < dataFromFiles.size()) {
                String op = dataFromFiles.get(index);
                String[] opAndArgs = op.split(" ");

                if (opAndArgs[0].equals("nop")) {
                    found = true;
                    old = dataFromFiles.get(index);
                    dataFromFiles.set(index, old.replace("nop", "jmp"));

                } else if (opAndArgs[0].equals("jmp")) {
                    found = true;
                    old = dataFromFiles.get(index);
                    dataFromFiles.set(index, old.replace("jmp", "nop"));
                } else {
                    index++;
                }
            }
            result2 = execute(dataFromFiles);
            if (!result2.infinite) {
                run = false;
            } else {
                dataFromFiles.set(index, old);
            }
            index++;

        } while(run && index < dataFromFiles.size());




        return result2.acc;
    }

    public static Result execute(List<String> input) {

        Result toReturn = new Result();
        int globalAcc = 0;
        int pc = 0;

        List<Integer> visitedPCs = new ArrayList<>();



        boolean run = true;

        while(run) {
            visitedPCs.add(pc);
            String op = input.get(pc);
            String[] opAndArgs = op.split(" ");
            switch (opAndArgs[0]) {
                case "nop":
                    pc++;
                    break;
                case "acc":
                    globalAcc += Integer.parseInt(opAndArgs[1]);
                    pc++;
                    break;
                case "jmp":
                    pc += Integer.parseInt(opAndArgs[1]);
                    break;
            }

            if (visitedPCs.contains(pc)) {
                run = false;
                toReturn.infinite = true;
                toReturn.acc = globalAcc;
            } else if (pc >= input.size()) {
                run = false;
                toReturn.infinite = false;
                toReturn.acc = globalAcc;
            }

        }


        return toReturn;
    }



    private static class Result {
        boolean infinite;
        int acc;
    }


}
