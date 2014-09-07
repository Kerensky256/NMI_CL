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

import org.json.simple.JSONArray;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darren
 */
public class JsnParserIT {
    
    public JsnParserIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of parseJson method, of class JsnParser.
     */
    @Test
    public void testParseJson() {
        System.out.println("parseJson");
        JsnParser instance = new JsnParser();
        instance.parseJson();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibraryName method, of class JsnParser.
     */
    @Test
    public void testGetLibraryName() {
        System.out.println("getLibraryName");
        JsnParser instance = new JsnParser();
        String expResult = "";
        String result = instance.getLibraryName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonBookList method, of class JsnParser.
     */
    @Test
    public void testGetJsonBookList() {
        System.out.println("getJsonBookList");
        JsnParser instance = new JsnParser();
        JSONArray expResult = null;
        JSONArray result = instance.getJsonBookList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
