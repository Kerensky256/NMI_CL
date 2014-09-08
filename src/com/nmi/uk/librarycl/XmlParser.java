/**
 * @(#)XmlParser.java
 * 
 * Copyright (C) 2014 Darren
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nmi.uk.librarycl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * A class to parse XML documents into LibraryRecord.java beans.
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

    /**
     * XML Parser constructor specify file to be read in. 
     * @param filename the XML file to be parsed, must be of type library schema.
     */
    public XmlParser(String filename) {
        this.filename = filename;
    }

    /**
     * Method to extract books using xml binding to `LibraryBind.java and `BookBind.java` beans.
     * The extracted elements are stored to `LibraryRecord.java` objects.<br> 
     * Duplicate `LibraryRecord` removed before adding to the array using hash of content.<br>
     * NOTE: SchemaFacotry schema validation not fully implemented. Exception to catch incorrect format of XML at the moment.
     */
     
    public void parseXml() {
        try { 
            //SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //Schema schema = sf.newSchema(new File("./src/resources/bethesda-library.xsd"));
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            InputStream is = this.getClass().getResourceAsStream("/resources/bethesda-library.xml");
            Library lib = (Library) jaxbUnmarshaller.unmarshal(is);

            libraryName = lib.getName();
            xmlBookList = lib.getListOfBooks();

            for (Book toAdd : xmlBookList) {
                rec = new LibraryRecord();
                rec.setLib_name(lib.getName());
                rec.setBook_name(toAdd.getTitle());
                rec.setAuth_name(toAdd.getAuthor());
                rec.setCat_name(toAdd.getCategory());

                if (!LibraryAccess.bookShelves.isEmpty()) {
                    for (LibraryRecord bookSaved : LibraryAccess.bookShelves) {

                        if (this.rec.getHashOfContent() == bookSaved.getHashOfContent()) {
                            duplicate = true;
                            rec = null;
                        }
                    }
                    
                    if (!duplicate) {
                        LibraryAccess.addRecord(rec);
                        
                    }          
                    duplicate = false;

                } else {
                    System.out.println("Library empty : Adding records...");
                    LibraryAccess.addRecord(this.rec);
                }
            }


        } catch (javax.xml.bind.UnmarshalException e) {
            System.out.println("The XMl file does not contain all of/the correct elements for import");
        } catch (JAXBException ex) {
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
