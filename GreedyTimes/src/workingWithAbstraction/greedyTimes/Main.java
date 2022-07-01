package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemAndQuantity = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();

        long goldAmount = 0;
        long rocksAmaunt = 0;
        long money = 0;

        for (int i = 0; i < itemAndQuantity.length; i += 2) {
            String name = itemAndQuantity[i];
            long count = Long.parseLong(itemAndQuantity[i + 1]);

            String items = itensToGather(name);

            if (items.equals("") || enoughBagCapacity(bagCapacity, bag, count) ) {
                continue;
            }
            if (rulesToPutItemsInBag(bag, count, items)) continue;
            if (!bag.containsKey(items)) {
                bag.put((items), new LinkedHashMap<>());
            }
            if (!bag.get(items).containsKey(name)) {
                bag.get(items).put(name, 0L);
            }

            bag.get(items).put(name, bag.get(items).get(name) + count);

            if (items.equals("Gold")) {
                goldAmount += count;
            } else if (items.equals("Gem")) {
                rocksAmaunt += count;
            } else if (items.equals("Cash")) {
                money += count;
            }
        }

        print(bag);
    }

    private static void print(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (var itemsInBag : bag.entrySet()) {
            Long sumValues = itemsInBag.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", itemsInBag.getKey(), sumValues));

            itemsInBag.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean rulesToPutItemsInBag(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count, String items) {
        switch (items) {
            case "Gem":
                if (!bag.containsKey(items)) {
                    if (bag.containsKey("Gold")) {
                        if (count > ruleGold(bag, "Gold")) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (ruleGold(bag, items) + count > ruleGold(bag, "Gold")) {
                    return true;
                }
                break;
            case "Cash":
                if (!bag.containsKey(items)) {
                    if (bag.containsKey("Gem")) {
                        if (count > ruleGold(bag, "Gold")) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (ruleGold(bag, items) + count > ruleGold(bag, "Gem")) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static long ruleGold(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, String gold) {
        return bag.get(gold).values().stream().mapToLong(e -> e).sum();
    }

    private static boolean enoughBagCapacity(long bagCapacity, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count) {
        return bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count;
    }

    private static String itensToGather(String name) {
        String items = "";

        if (name.length() == 3) {
            items = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            items = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            items = "Gold";
        }
        return items;
    }
}