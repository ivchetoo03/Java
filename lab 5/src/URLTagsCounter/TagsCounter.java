package URLTagsCounter;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagsCounter {

    public static Map<String, Integer> countTags(String html) {

        Map<String, Integer> tags = new TreeMap<>();
        
        Pattern pattern = Pattern.compile("<([a-z][a-z0-9-]*)\\b[^>]*>");
        Matcher matcher = pattern.matcher(html);
        
        while (matcher.find()) {
            String tag = matcher.group(1).toLowerCase();
            if (!tag.isEmpty() && tag.matches("[a-z0-9-]+")) {
                tags.put(tag, tags.getOrDefault(tag, 0) + 1);
            }
        }

        return tags;
    }

    public static void printTagsAlphabetical(Map<String, Integer> tags){
        int maxTagLength = "Тег".length();

        for (String tag : tags.keySet()) {
            if (tag.length() > maxTagLength) {
                maxTagLength = tag.length();
            }
        }
        String formatString = "%-" + maxTagLength + "s | %5s\n";
        String numberFormatString = "%-" + maxTagLength + "s | %5d\n";
        String separator = "-".repeat(maxTagLength+1) + "+----------";

        System.out.println(separator);
        System.out.printf(formatString, "Тег", "Кількість");
        System.out.println(separator);
        
        tags.forEach((tag, count) -> System.out.printf(numberFormatString, tag, count));

        System.out.println(separator);
    }

    public static void printTagsByCount(Map<String, Integer> tags){
        int maxTagLength = "Тег".length();

        for (String tag : tags.keySet()) {
            if (tag.length() > maxTagLength) {
                maxTagLength = tag.length();
            }
        }
        String formatString = "%-" + maxTagLength + "s | %5s\n";
        String numberFormatString = "%-" + maxTagLength + "s | %5d\n";
        String separator = "-".repeat(maxTagLength+1) + "+----------";

        System.out.println(separator);
        System.out.printf(formatString, "Тег", "Кількість");
        System.out.println(separator);

        tags.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(e -> System.out.printf(numberFormatString, e.getKey(), e.getValue()));

        System.out.println(separator);
    }
}
