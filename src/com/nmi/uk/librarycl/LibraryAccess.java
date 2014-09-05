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
 *
 * @author Darren
 * @version %I%, %G%
 */
public class LibraryAccess implements Serializable {

    public static ArrayList<LibraryRecord> bookShelves = new ArrayList<>();

    public LibraryAccess() {

    }

    /**
     *
     * @param rec
     */
    protected static void addRecord(LibraryRecord rec) {
        bookShelves.add(rec);
    }

    protected ArrayList<LibraryRecord> getRecord() {
        
        return bookShelves;
    }

    /**
     * Method to print results of a search.
     */
    public static void printResult(String searchFor) {
        System.out.println("Testing object output, " + searchFor);
        System.out.println("T-szie, " + bookShelves.size());
        
        int i =0;
        for(LibraryRecord rec : bookShelves){
            
            System.out.println( i += 1);
                           
            //if (rec.getAuth_name().equals(searchFor)) {
                System.out.println("Element name: " + rec.getAuth_name());
                System.out.println("Element name: " + rec.getBook_name());
                System.out.println("Element name: " + rec.getCat_name());
                System.out.println("Element name: " + rec.getLib_name());
            //} else {
            //    System.out.println("No matching record found");
            //    break;
            //}
        }
    }

}
