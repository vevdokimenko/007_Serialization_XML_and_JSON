package homework.task4;

/*
 * Используя JAXB выполнить задание №3.
 * Задание 3
 * Создайте класс, используя SAXParser, в котором опишите иерархию XML файла.
 * Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
 * В городе используйте аттрибут(например, <city size=”big>Kiev</city>).
 * */

import javax.xml.bind.*;
import java.io.File;

public class Task4 {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.add(new Address(new City("Kiev", "big"), "Shevchenko str", 10));
        addressBook.add(new Address(new City("Kiev", "big"), "Nezalezhnosti str", 5));

        try {
            File file = new File("./src/homework/address.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(AddressBook.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(addressBook, file);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            AddressBook addressBook1 = (AddressBook) unmarshaller.unmarshal(file);
            System.out.println(addressBook1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
