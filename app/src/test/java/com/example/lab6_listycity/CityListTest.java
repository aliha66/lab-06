package com.example.lab6_listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * TEST FOR HASCITY()
     * This tests the hasCity method in the CityList class
     * It also tests the hash method and equal method in the City class
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Should return true because this city was added in mockCityList()
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testHasCityFalse() {
        CityList cityList = mockCityList();
        // Should return false because this city was NOT added in mockCityList()
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testHasCitydifferentProvince() {
        CityList cityList = mockCityList();
        // Should return false because this city was NOT added in mockCityList()
        // This is because the province is different and the cities are not equal because the provinces are different
        // specifically tests equal method in the City class
        assertFalse(cityList.hasCity(new City("Edmonton", "Ontario")));
    }


    /**
     * TEST FOR REMOVE()
     * This tests the remove method in the CityList class
     */

    @Test
    void testRemove() {
        CityList cityList = mockCityList();
        // Should remove the city from the list
        cityList.remove(mockCity());
    }

    @Test
    void testRemoveException() {
        CityList cityList = mockCityList();
        // Should throw
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.remove(new City("Regina", "Saskatchewan"));
        });
    }

     //1. The city exists before deletion
     //2. The list size decreases after deletion
     //3. The city no longer exists after deletion
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        // Verify initial state: 1 city exists
        assertEquals(1, cityList.countCities());
        assertTrue(cityList.hasCity(city));

        // Delete the city
        cityList.remove(city);

        // Verify final state: 0 cities, city no longer exists
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteMultipleCities() {
        CityList cityList = mockCityList();  // Edmonton
        City city1 = new City("Toronto", "Ontario");
        City city2 = new City("Montreal", "Quebec");

        cityList.add(city1);
        cityList.add(city2);

        // Should have 3 cities now
        assertEquals(3, cityList.countCities());

        // Delete Toronto
        cityList.remove(city1);

        // Verify: count is 2, Toronto is gone, but Montreal and Edmonton remain
        assertEquals(2, cityList.countCities());
        assertFalse(cityList.hasCity(city1));  // Toronto gone
        assertTrue(cityList.hasCity(city2));   // Montreal still there
        assertTrue(cityList.hasCity(mockCity()));  // Edmonton still there
    }

    /**
     * TEST FOR COUNTCITIES()
     * This tests the countCities method in the CityList class
     */

    @Test
    void testCountCitiesEmpty() {
        CityList cityList = new CityList();  // Fresh, empty list
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        // Should return 1 because this city was added in mockCityList()
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testCountCitiesMultiple() {
        CityList cityList = mockCityList();  // Starts with 1 city

        cityList.add(new City("Ottawa", "Ontario"));
        cityList.add(new City("Victoria", "British Columbia"));
        cityList.add(new City("Winnipeg", "Manitoba"));

        // Should have 4 cities total (1 initial + 3 added)
        assertEquals(4, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterDelete() {
        CityList cityList = mockCityList();  // 1 city (Edmonton)
        City city = new City("Halifax", "Nova Scotia");

        // Add a city
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        // Delete the city we just added
        cityList.remove(city);
        assertEquals(1, cityList.countCities());

        // Delete the original city
        cityList.remove(mockCity());
        assertEquals(0, cityList.countCities());
    }

}
