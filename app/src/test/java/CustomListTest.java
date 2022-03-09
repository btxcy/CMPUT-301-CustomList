import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;
import com.example.simpleparadox.listycity.CityList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void checkHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    public void checkDelCities() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "ON");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        // delete the city
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void checkCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Victoria", "BC");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());

        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList(); // Edmonton inside of that

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "PEI");
        cityList.add(city);

        // Edmonton, Charlottetown -> Charlottetown, Edmonton
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

}
