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

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author Darren
 */
public class MainMenu {

    /**
     * Method to load and manage the menu options.
     */
    static void Run() {
        LibraryAccess admin = new LibraryAccess();
        Scanner in = new Scanner(System.in);
        String option = null;

        while (!"exit".equals(option)) {
            System.out.println("Enter option 1 to return all books by author");
            System.out.println("Enter option 2 to return all books by author");
            System.out.println("Type 'exit' to quit");
            System.out.print("Enter your selection: ");
            option = in.next().toLowerCase();

            switch (option) {
                case "1": {
                    // run query 1
                    LibraryRecord rec = new LibraryRecord();

                    rec.setBook_name("Alien");
                    rec.setAuth_name("Darren");
                    rec.setCat_name("Sci-fi");
                    rec.setLib_name("Bangor");

                    admin.addRecord(rec);
                    break;
                }
                case "2": {
                    // run query 1
                    admin.printResult("Darren");
                    break;
                }
                case "exit": {
                    System.exit(0);
                    break;
                }
                default: {
                    break;
                }

            }

        }
    }

}
