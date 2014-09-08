/**
 * @(#)MainMenu.java
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

import java.util.Scanner;

/**
 * MainMenu class provides simple console UI with user input.
 * @author Darren Roberts
 */
public class MainMenu {
    
    public MainMenu(){
        this.Run();
    }

    void Run() {

        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String option = null;

        while (!"exit".equals(option)) {

            System.out.println("Enter option 1 to return all records");
            System.out.println("Enter option 2 to return all books by library name");
            System.out.println("Enter option 3 to return all books by author name");
            System.out.println("Type 'exit' to quit");
            System.out.print("Enter your selection: ");
            option = in.nextLine().toLowerCase();

            switch (option) {
                case "1": {
                    LibraryQuery.getAll();
                    break;
                }
                case "2": {
                    // Get all books by library
                    System.out.println("Enter a library name, it is not case sensitive");
                    System.out.print("Enter library name: ");
                    String select = in.nextLine().toLowerCase();
                    LibraryQuery.getByLibName(select);
                    break;
                }
                case "3": {
                    // Get all books by authors
                    System.out.println("Enter the authors full name (e.g. Darren Roberts)this is not case sensitive:");
                    System.out.print("Enter Name: ");             
                    String select = in.nextLine().toLowerCase();
                    System.out.println();
                    LibraryQuery.getByAuthName(select);
                    break;
                }
                case "exit": {
                    System.out.println("Thank you for using the NMi Library app\n");
                    System.out.println("*Closed*");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("\n Warning: Please enter a valid option or type `exit`.\n");
                    break;
                }
            }
        }
    }
}
