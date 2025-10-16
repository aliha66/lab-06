package com.example.lab6_listycity;

/**
This class is for representing a city object
 **/
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * This is the constructor for the City class
     * @param city
     * @param province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the city name
     * @return
     * Return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * This returns the province name
     * @return
     * Return the province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * This sets the city name
     * @param city
     * This is the city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This sets the province name
     * @param province
     * This is the province name
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This compares two cities
     *
     * @param o the object to be compared.
     * @return -1 if the caller is greater than the city name field
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o; // type cast to City
        return this.city.compareTo(city.getCity());
    }

    /**
     * This checks if two cities are equal
     *
     * @param o the object to be compared.
     * @return true if the cities are equal
     */
    @Override
    public boolean equals(Object o) {
        //  check if the object is the same as this object
        if (this == o) return true;
        // check if the object is null or not a City (type) object
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;
        return this.city.equals(city.getCity()) && this.province.equals(city.getProvince());
    }

    /**
     * Returns a hash code value for this city.
     *      - must be overwritten when equals is overwritten
     *      - If two objects are equal (check using equals()), they must return the same hashCode().
     * @return a hash code value for this city.
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode(); // formula for hash code calculation
        return result;
    }

}
