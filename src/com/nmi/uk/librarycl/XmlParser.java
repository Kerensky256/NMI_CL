package com.nmi.uk.librarycl;

//import com.sun.xml.internal.ws.developer.ValidationErrorHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 * Created by Darren on 25/08/2014.
 */
public class XmlParser {

    private String filename = null;
    private String libraryName = null;
    private ArrayList<Book> xmlBookList = null;

    public XmlParser() {

    }

    public XmlParser(String filename) {
        this.filename = filename;
    }

    public void parseXml() {
        try {

            // FixMe: implement schema validation. 
            JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("./src/resources/bethesda-library.xsd"));

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File XMLfile = new File("./src/resources/bethesda-library.xml");
            Library lib = (Library) jaxbUnmarshaller.unmarshal(XMLfile);
            
            System.out.println("Library name:" + lib.getName());

            lib.getListOfBooks();
            libraryName = lib.getName();
            xmlBookList = lib.getListOfBooks();

            for (Book toAdd : xmlBookList) {
                
                
                // do not add duplicates !!!!!
                System.out.println("Book:" + toAdd.getTitle() + "," + toAdd.getAuthor() + "," + toAdd.getCategory());
                
                LibraryRecord rec = new LibraryRecord();
                rec.setLib_name(lib.getName());
                rec.setBook_name(toAdd.getTitle());
                rec.setAuth_name(toAdd.getAuthor());
                rec.setCat_name(toAdd.getCategory());
                LibraryAccess.addRecord(rec);
                System.out.println("Record has been added");
            }

        } catch (javax.xml.bind.UnmarshalException e) {
            System.out.println("The XMl file does not contain all of/the correct elements for import");
        } catch (JAXBException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLibraryName() {
        return libraryName;
    }

    public ArrayList getXmlBookList() {
        return xmlBookList;
    }
}
