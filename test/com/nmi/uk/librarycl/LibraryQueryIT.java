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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darren
 */
public class LibraryQueryIT {
    
    public LibraryQueryIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getAll method, of class LibraryQuery.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        LibraryQuery.getAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByLibName method, of class LibraryQuery.
     */
    @Test
    public void testGetByLibName() {
        System.out.println("getByLibName");
        String option = "";
        LibraryQuery.getByLibName(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByAuthName method, of class LibraryQuery.
     */
    @Test
    public void testGetByAuthName() {
        System.out.println("getByAuthName");
        String option = "";
        LibraryQuery.getByAuthName(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
