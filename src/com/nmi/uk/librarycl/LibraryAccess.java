/*
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to store the book objects, could also persist to a database.
 *
 * @author Darren
 */
public class LibraryAccess implements Serializable {

    ArrayList<LibraryRecord> bookShelves;

    public LibraryAccess() {
        bookShelves = new ArrayList<LibraryRecord>();
    }

    protected void addRecord(LibraryRecord rec) {
        bookShelves.add(rec);
    }

    protected ArrayList<LibraryRecord> getRecords() {
        return bookShelves;
    }

    /**
     * Method to print results of a search.
     */
    public void printResult(String searchFor) {
        System.out.println("Testing object output");
        Iterator<LibraryRecord> search = bookShelves.iterator();

        while (search.hasNext()) {
            LibraryRecord element = search.next();
            if (element.getAuth_name().equalsIgnoreCase(searchFor)) {
                System.out.println("Element name: " + element.getAuth_name());
                System.out.println("Element name: " + element.getBook_name());
                System.out.println("Element name: " + element.getCat_name());
                System.out.println("Element name: " + element.getLib_name());
            }
            else{
                System.out.println("No matching record found");
            }
        }
    }

}
