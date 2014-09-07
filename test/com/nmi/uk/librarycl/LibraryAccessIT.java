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

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darren
 */
public class LibraryAccessIT {
    
    public LibraryAccessIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addRecord method, of class LibraryAccess.
     */
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        LibraryRecord rec = null;
        LibraryAccess.addRecord(rec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShelves method, of class LibraryAccess.
     */
    @Test
    public void testGetShelves() {
        System.out.println("getShelves");
        LibraryAccess instance = new LibraryAccess();
        ArrayList<LibraryRecord> expResult = null;
        ArrayList<LibraryRecord> result = instance.getShelves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printLibraryDetails method, of class LibraryAccess.
     */
    @Test
    public void testPrintLibraryDetails() {
        System.out.println("printLibraryDetails");
        LibraryAccess.printLibraryDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
