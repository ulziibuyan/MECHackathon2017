
import java.io.File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public  class ConfigurationExporter {
    public String SQLText;
    public String longTextValue;

    public ConfigurationExporter() {
        SQLText = null;
        longTextValue = null;
    }

    public void write() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();
            Element element;
            Node node;

            element = document.createElement("ConfigRoot");
            document.appendChild(element);

            node = document.getLastChild();
            element = document.createElement("Indices");
            node.appendChild(element);

            node = document.getLastChild();
            element = document.createElement("Index");
            node.appendChild(element);

            node = document.getLastChild();
            element = document.createElement("ConfigElement");
            element.setAttribute("name", "Execute onto a business document");
            node.appendChild(element);

            element = document.createElement("Attribute");
            node.appendChild(element);
            element = document.createElement("Attribute");
            node.appendChild(element);

            element = document.createElement("Index");
            node.appendChild(element);

            node = document.getLastChild();
            element = document.createElement("ConfigElement");
            element.setAttribute("name", "C_Calculate_First_Party_Age_Group");
            node.appendChild(element);

            node = document.getLastChild();
            element = document.createElement("Attribute");
            element.setAttribute("value", "SQL: Get the first party age group");
            node.appendChild(element);

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("../config.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  String getSQLText() {
        return this.SQLText;
    }
    public  void setSQLText(String text) {
        this.SQLText = text;
    }
    public  String getLongTextValue() {
        return this.longTextValue;
    }
    public  void setLongTextValue(String text) {
        this.longTextValue = text;
    }

    public static void main(String[] args) throws Exception {
        ConfigurationExporter configurationExporter = new ConfigurationExporter();
        configurationExporter.setLongTextValue("longlong");
        configurationExporter.setSQLText("sqlsql");
        configurationExporter.write();
    }
}
