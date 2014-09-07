/**
 * @(#)Library.java
 * 
 * Copyright (C) 2014 Darren Roberts
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

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/** A bean class utilising xml binding annotations, is dependent on `Book.java`.
 * The class provides binding for the outer elements of the LibraryBind XML schema.
 * @author Darren
 */
@XmlRootElement
@XmlType
public class Library implements Serializable{

    private ArrayList<Book> listOfBooks;
    private String name;

    String getName() {
        return name;
    }

    /**
     * The outer root element library name.
     * @param name the name of the library bound to this element.
     */
    @XmlElement
    public void setName(String name) {

        this.name = name;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    /**
     * Annotated method which maps to the books elements of the XML file.
     * @param listOfBooks ArrayList of type `BookBind.java`, the books retrieved from the XML file 
     */
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public void setListOfBooks(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
