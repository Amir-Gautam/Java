import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws DataProcessingException {
        if (rawData.isEmpty()) {
            throw new EmptyDataException("No raw data to process! Did all tourists go missing?");
        }

        Set<String> uniqueNames = new HashSet<>();
        for (String entry : rawData) {
            if (entry.contains("Visitor: ") || entry.contains("Guest: ")) {
                String afterPrefix = entry.contains("Visitor: ")
                    ? entry.split("Visitor: ")[1]
                    : entry.split("Guest: ")[1];
                String name = afterPrefix.split(",")[0].trim();
                uniqueNames.add(name);
            }
        }

        return Collections.singletonList("Unique Visitors: " + uniqueNames.size());
    }

    public static void main(String[] args) {
        UniqueVisitorCounter counter = new UniqueVisitorCounter();

        try {
            counter.process(Collections.emptyList());
        } catch (EmptyDataException e) {
            System.out.println("Empty data error: " + e.getMessage());
        } catch (DataProcessingException e) {
            System.out.println("Processing error: " + e.getMessage());
        }

        List<String> sampleData = Arrays.asList(
            "Visitor: Sita Sharma, Nepal",
            "Visitor: John Doe, USA",
            "Hotel: Yak & Yeti, Guest: Ram Thapa, NP",
            "Visitor: Sita Sharma, Nepal"
        );

        try {
            List<String> result = counter.process(sampleData);
            System.out.println(result.get(0));
        } catch (DataProcessingException e) {
            System.out.println("Processing error: " + e.getMessage());
        }
    }
}
