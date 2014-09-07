/**
 * @(#)LibraryAccess.java
 *
 * Copyright (C) 2014 Darren
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.nmi.uk.librarycl;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class providing storage for Books as `LibraryRecord` objects to and ArrayList.
 * This is the class which is the data store for all the parsing operations.
 * @author Darren Roberts
 */
public class LibraryAccess implements Serializable {

    public static ArrayList<LibraryRecord> bookShelves = new ArrayList<>();

    public LibraryAccess() {

    }

    /**
     * Add a new library record to the ArrayList of type `LibraryRecord`
     * @param rec the record constructed form the json or xml files.
     */
    public static void addRecord(LibraryRecord rec) {
        bookShelves.add(rec);
    }

    public static ArrayList<LibraryRecord> getShelves() {
        return bookShelves;
    }

    /**
     * Method to print content of the library and other details, i.e. counts
     * etc.
     */
    public static void printLibraryDetails() {
        
        System.out.println("T-szie, " + bookShelves.size());
        int i = 0;
        for (LibraryRecord rec : bookShelves) {

            System.out.println(i += 1);
            System.out.println("Element name: " + rec.getAuth_name());
            System.out.println("Element name: " + rec.getBook_name());
            System.out.println("Element name: " + rec.getCat_name());
            System.out.println("Element name: " + rec.getLib_name());
        }
    }
}
