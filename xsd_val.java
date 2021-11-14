import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class xsd_val{
  public static void main(String[] args){
    File schemas = new File("house.xsd");
    Source my_xml = new StreamSource(new File("house.xml"));
    SchemaFactory schemaFactory = SchemaFactory
    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    try {
  Schema schema = schemaFactory.newSchema(schemas);
  Validator validator = schema.newValidator();
  validator.validate(my_xml);
  System.out.println(my_xml.getSystemId() + " is valid");
} catch (SAXException e) {
  System.out.println(my_xml.getSystemId() + " is NOT valid reason:" + e);
} catch (IOException e) {}

  }

}
