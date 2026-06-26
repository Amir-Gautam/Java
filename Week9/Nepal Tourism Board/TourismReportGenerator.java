import java.util.Arrays;
import java.util.List;

public class TourismReportGenerator {

    public static void generateOverallReport(List<TouristDataSource> dataSources, DataProcessor processor) {
        System.out.println("Generating overall tourism report...");
        System.out.println();

        for (TouristDataSource dataSource : dataSources) {
            List<String> fetchedData = null;
            try {
                fetchedData = dataSource.fetchData();
            } catch (DataSourceAccessException e) {
                System.out.println("Could not fetch data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this source.");
                if (e.getCause() != null) {
                    System.out.println("Reason: " + e.getCause().getMessage());
                }
            } finally {
                System.out.println("Data handling from " + dataSource.sourceName + " completed.");
                System.out.println();
            }

            if (fetchedData == null) {
                continue;
            }

            try {
                List<String> processed = processor.process(fetchedData);
                for (String line : processed) {
                    System.out.println(line);
                }
            } catch (DataProcessingException e) {
                System.out.println("Error processing data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this data.");
            }
        }
    }

    public static void main(String[] args) {
        List<TouristDataSource> sources = Arrays.asList(
            new AirportArrivalsDataSource(),
            new HotelRegistrationsDataSource()
        );

        UniqueVisitorCounter counter = new UniqueVisitorCounter();
        generateOverallReport(sources, counter);
    }
}
