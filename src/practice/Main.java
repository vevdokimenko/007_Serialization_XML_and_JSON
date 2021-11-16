package practice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("./src/practice/menu.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(xmlFile);

            Element root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                System.out.println("Food:");
                NodeList childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }

                    String nodeName = childNode.getNodeName();
                    if (nodeName.equals("name")) {
                        System.out.println("Name: " + childNode.getTextContent());
                    } else if (nodeName.equals("price")) {
                        System.out.println("Price: " + childNode.getTextContent());
                    } else if (nodeName.equals("description")) {
                        System.out.println("Description: " + childNode.getTextContent());
                    } else if (nodeName.equals("calories")) {
                        System.out.println("Calories: " + childNode.getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
