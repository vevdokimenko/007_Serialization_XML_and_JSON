package homework.task4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
    private City city;
    private String street;
    private int building;

    public Address() {
    }

    public Address(City city, String street, int building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public City getCity() {
        return city;
    }

    @XmlElement
    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", street='" + street + '\'' +
                ", building=" + building +
                '}';
    }

    public String getStreet() {
        return street;
    }

    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    @XmlElement
    public void setBuilding(int building) {
        this.building = building;
    }
}
