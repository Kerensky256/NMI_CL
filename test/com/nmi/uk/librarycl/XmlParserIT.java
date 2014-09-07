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
public class XmlParserIT {
    private Class<? extends ArrayList> result;
    
    public XmlParserIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of parseXml method, of class XmlParser.
     */
    @Test
    public void testParseXml() {
        System.out.println("parseXml");
        XmlParser instance = new XmlParser();
        instance.parseXml();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibraryName method, of class XmlParser.
     */
    @Test
    public void testGetLibraryName() {
        System.out.println("getLibraryName");
        XmlParser instance = new XmlParser();
        String expResult = "";
        String result = instance.getLibraryName();
        System.out.println("Lib name: " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXmlBookList method, of class XmlParser.
     */
    @Test
    public void testGetXmlBookList() {
        System.out.println("getXmlBookList");
        XmlParser instance = new XmlParser();
        result = instance.getXmlBookList().getClass();
        assertEquals(ArrayList.class, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
