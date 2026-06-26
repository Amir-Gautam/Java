import java.util.Arrays;
import java.util.List;

public class HotelRegistrationsDataSource extends TouristDataSource {

    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        if (sourceName.contains("Hotels") && Math.random() < 0.2) {
            throw new AuthenticationFailedException("Hotel API authentication failed! Did someone forget the password again?");
        }
        return Arrays.asList(
            "Hotel: Yak & Yeti, Guest: Ram Thapa, NP",
            "Hotel: Annapurna, Guest: Alice Smith, AU",
            "Hotel: Hyatt Regency, Guest: Roshan Karki, NP",
            "Hotel: Soaltee, Guest: Damodar Shrestha, NP"
        );
    }

    public static void main(String[] args) {
        HotelRegistrationsDataSource source = new HotelRegistrationsDataSource();
        for (int i = 0; i < 5; i++) {
            try {
                List<String> data = source.fetchData();
                System.out.println("Fetched " + data.size() + " records from " + source.sourceName);
            } catch (AuthenticationFailedException e) {
                System.out.println("Auth error: " + e.getMessage());
            } catch (DataSourceAccessException e) {
                System.out.println("Access error: " + e.getMessage());
            }
        }
    }
}
