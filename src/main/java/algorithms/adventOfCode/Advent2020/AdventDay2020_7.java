package algorithms.adventOfCode.Advent2020;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventDay2020_7 extends AdventOfCode {

    Map<String, List<BagInfo>> bags = new HashMap<>();

    @Override
    public long getFirstPartSolution() {
        fillValue();

        int count = 0;
        for (String bag: bags.keySet()) {
            if (isGoldBagInBag(bag))
                count++;
        }
        return count;
    }

    @Override
    public long getSecondPartSolution() {
        fillValue();

        return countBagsInGoldBag("shiny gold") -1;
    }

    private void fillValue() {
        List<String> dateFromFile = getInputDataAsListOfString();

        for (String value : dateFromFile) {
            String[] split1 = value.substring(0, value.length() - 1).split("bags contain");
            String outerBag = split1[0].trim();
            String[] innerBags = split1[1].split(",");
            List<BagInfo> bagInfos = new ArrayList<>();
            for (String innerBag : innerBags) {
                innerBag = innerBag.replace("bags", "").replace("bag", "").trim();
                int index = innerBag.trim().indexOf(" ");
                String quantityStr = innerBag.substring(0, index);

                if (!quantityStr.equalsIgnoreCase("no")) {

                    BagInfo bagInfo = new BagInfo();
                    bagInfo.quantity = Integer.parseInt(quantityStr);
                    bagInfo.bagName = innerBag.substring(index + 1);
                    bagInfos.add(bagInfo);
                }
            }
            bags.put(outerBag, bagInfos);
        }
    }

    private boolean isGoldBagInBag (String bag) {

        for (BagInfo subBag: bags.get(bag)) {
            if (subBag.bagName.equalsIgnoreCase("shiny gold"))
                return true;
        }

        for (BagInfo subBag: bags.get(bag)) {
            if (isGoldBagInBag(subBag.bagName))
                return true;
        }
        return false;
    }

    private int countBagsInGoldBag(String bagName) {

        List<BagInfo> bagList = bags.get(bagName);

        int count = 1;
        for (BagInfo bagInfo: bagList) {
            count += bagInfo.quantity * countBagsInGoldBag(bagInfo.bagName);
        }

        return count;
    }

    public static class BagInfo {
        public int quantity;
        public String bagName;
    }
}
