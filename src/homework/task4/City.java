package homework.task4;

import javax.xml.bind.annotation.XmlAttribute;

public class City {
    private String name;
    private String type;

    public City() {
    }

    public City(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "city='" + name + '\'' +
                ", type='" + type;
    }
}
