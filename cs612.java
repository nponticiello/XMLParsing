import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.*;
import javax.xml.validation.*;

public class cs612 {

public static void validate(String xmlFile) throws IOException, ParserConfigurationException, SAXException
{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler(){

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                throw exception;}
            @Override
            public void error(SAXParseException exception) throws SAXException {throw exception;}
            @Override
            public void fatalError(SAXParseException exception) throws SAXException {throw exception;}
        });
        documentBuilder.parse(new FileInputStream(xmlFile));
    }



    public static void main(String[] args)
    {
        boolean flag = true;
        try{ validate("house.xml"); }
        catch(ParserConfigurationException e){flag = false;
        System.out.println("parser error");}
        catch(FileNotFoundException e){flag = false;
            System.out.println("file not found error");}
        catch(SAXException e){flag = false;
            System.out.println("Sax error");}
        catch(IOException e){flag = false;}
        System.out.println("xml is valid " + flag);



    }
}
