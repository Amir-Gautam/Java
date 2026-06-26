import java.util.Arrays;
import java.util.List;

public class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
            throw new ConnectionLostException("Airport data connection lost! Maybe a pigeon sat on the antenna?");
        }
        return Arrays.asList(
            "Visitor: Sita Sharma, Nepal",
            "Visitor: John Doe, USA",
            "Visitor: Emily White, UK",
            "Visitor: Ram Thapa, Nepal"
        );
    }

    public static void main(String[] args) {
        AirportArrivalsDataSource source = new AirportArrivalsDataSource();
        for (int i = 0; i < 5; i++) {
            try {
                List<String> data = source.fetchData();
                System.out.println("Fetched " + data.size() + " records from " + source.sourceName);
            } catch (ConnectionLostException e) {
                System.out.println("Connection error: " + e.getMessage());
            } catch (DataSourceAccessException e) {
                System.out.println("Access error: " + e.getMessage());
            }
        }
    }
}
