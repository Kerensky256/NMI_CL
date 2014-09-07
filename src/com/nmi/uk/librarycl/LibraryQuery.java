/**
 * @(#)LibraryQuery.java
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

/**
 * Class providing a simple method for carrying out queries on the Library.
 * @author Darren Roberts
 */
public class LibraryQuery {

    /**
     * Return and display all records in the Library
     */
    public static void getAll() {

        System.out.println("ALL Book Results: ");
        System.out.println();

        for (LibraryRecord rec : LibraryAccess.bookShelves) {
            System.out.println("Book location: " + rec.getLib_name());
            System.out.println("Title: " + rec.getBook_name());
            System.out.println("Author: " + rec.getAuth_name());
            System.out.println("Category: " + rec.getCat_name());
            System.out.println();
        }  
        System.out.println("End of Results\n");
    }

    /**
     * Return and display all records in the Library by library name.
     * @param option the name of the library to search, passed in from menu.
     */
    public static void getByLibName(String option) {

        System.out.println("Book Results for: " + option);
        System.out.println();

        for (LibraryRecord rec : LibraryAccess.bookShelves) {
            if (rec.getLib_name().equalsIgnoreCase(option)) {
                System.out.println("Title: " + rec.getBook_name());
                System.out.println("Author: " + rec.getAuth_name());
                System.out.println("Category: " + rec.getCat_name());
                System.out.println();
            }
        } 
        System.out.println("End of Results\n");
    }

    /**
     * Return and display all records by authors name.
     * @param option the name of the author to search for, passed in from menu.
     */
    static void getByAuthName(String option) {

        System.out.println("Book Results for: " + option);
        System.out.println();
        
        for (LibraryRecord rec : LibraryAccess.bookShelves) {
            if (rec.getAuth_name().equalsIgnoreCase(option)) {
                System.out.println("Title: " + rec.getBook_name());
                System.out.println("Author: " + rec.getAuth_name());
                System.out.println("Book Location: " + rec.getLib_name());
                System.out.println();
            }
        }
        
        System.out.println("End of Results\n");
    }
}
