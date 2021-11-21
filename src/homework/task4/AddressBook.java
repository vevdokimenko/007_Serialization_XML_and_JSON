package homework.task4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "address-book")
public class AddressBook {
    public AddressBook() {
    }

    @XmlElement(name = "address")
    private List<Address> addresses = new ArrayList<>();

    public void add(Address address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(addresses.toArray());
    }
}
