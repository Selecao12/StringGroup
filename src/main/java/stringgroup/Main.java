package stringgroup;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String wordsString = "меню щука щенок аист сокровище рыбак фломастер парк успех подарок торт" +
                " радуга щенок подарок автобус холодный отчаянный выдающийся сказочный идеальное безупречный" +
                " активный идеальный космический впечатляющий футбольный идеальная идиома ";

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(wordsString.split("\\s+")));
        HashMap<String, ArrayList<String>> result = (HashMap<String, ArrayList<String>>) arrayList.stream().sorted((s1, s2) -> {

            if (s1.length() > s2.length()) {
                return -1;
            }
            if (s1.length() < s2.length()) {
                return 1;
            }
            return s1.compareTo(s2);
        }).collect(Collectors.toMap(s -> String.valueOf(s.charAt(0)), s -> new ArrayList<String>(Arrays.asList(s)), (i1, i2) -> {
             i1.add(i2.get(0));
             return i1;
        })).entrySet().stream().filter(k -> k.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        SortedMap<String, ArrayList<String>> sortedResult = new TreeMap<String, ArrayList<String>>(result);






        System.out.println(sortedResult);
    }
}
