import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<City> cityList = List.of(
                new City("New York", "New York", 8_000_000),
                new City("Los Angeles", "California", 3_800_000),
                new City("Chicago", "Illinois", 2_600_000),
                new City("Houston", "Texas", 2_300_000),
                new City("Phoenix", "Arizona", 1_700_000),
                new City("Philadelphia", "Pennsylvania", 1_600_000),
                new City("San Antonio", "Texas", 1_500_000),
                new City("San Diego", "California", 1_400_000),
                new City("Dallas", "Texas", 1_300_000),
                new City("Jacksonville", "Florida", 990_000),
                new City("Austin", "Texas", 980_000),
                new City("Fort Worth", "Texas", 979_000),
                new City("San Jose", "California", 970_000)
        );

        Stream<City> cityStream = cityList.stream();
        Map<String, String> uniqueState = cityStream.collect(
                Collectors.toMap(
                        City::getState,
                        City::getName,
                        (firstValue, secondValue) -> firstValue.compareTo(secondValue) < 0 ? firstValue : secondValue
                        //Duplicate key Texas (attempted merging values Houston and San Antonio)
                )
        );

        for (Map.Entry<String, String> stringStringEntry : uniqueState.entrySet())
        {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }

    }
}