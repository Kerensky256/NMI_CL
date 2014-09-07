/**
 * @(#)Book.java
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

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A bean class utilising xml binding annotations, is dependent on Library.java.
 * The class provides binding for the inner elements of the Library XML schema.
 * @author Darren Roberts
 */

@XmlRootElement 
public class Book implements Serializable {

    private String title;
    private String author;
    private String category;

    public Book() {

    }

    /**
     * Construct a new book bean from the supplied parameters.
     * @param title name of the book parsed form the XML document.
     * @param author name of the author parsed form the XML document.
     * @param category name of the book category parsed form the XML document.
     */
    public Book(String title, String author, String category) {
        super();
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
