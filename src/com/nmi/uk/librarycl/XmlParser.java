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
    private Boolean duplicate = false;
    private LibraryRecord rec = null;

    public XmlParser() {

    }

    public XmlParser(String filename) {
        this.filename = filename;
    }

    public void parseXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("./src/resources/bethesda-library.xsd"));

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File XMLfile = new File("./src/resources/bethesda-library.xml");
            Library lib = (Library) jaxbUnmarshaller.unmarshal(XMLfile);

            libraryName = lib.getName();
            xmlBookList = lib.getListOfBooks();

            for (Book toAdd : xmlBookList) {
                this.rec = new LibraryRecord();
                this.rec.setLib_name(lib.getName());
                this.rec.setBook_name(toAdd.getTitle());
                this.rec.setAuth_name(toAdd.getAuthor());
                this.rec.setCat_name(toAdd.getCategory());

                if (!LibraryAccess.bookShelves.isEmpty()) {
                    for (LibraryRecord bookSaved : LibraryAccess.bookShelves) {

                        if (this.rec.getHashOfContent() != bookSaved.getHashOfContent()) {
                            duplicate = false;
                            System.out.println(duplicate);
                        } else {
                            duplicate = true;
                            System.out.println(duplicate);
                        }
                    }
                    if (!duplicate) {
                        LibraryAccess.addRecord(rec);
                    }

                } else {
                    System.out.println("Library empty : Adding first record!!!");
                    LibraryAccess.addRecord(this.rec);
                    System.out.println(this.rec.getHashOfContent());
                }
            }

            // TO DO: remove when test done !!!!
            LibraryAccess.printResult("Neal Stephenson");

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
