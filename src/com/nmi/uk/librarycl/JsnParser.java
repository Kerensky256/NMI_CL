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

import java.io.FileNotFoundException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Iterator;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Darren
 */
public class JsnParser {

    private String filename = null;
    private String libraryName = null;
    private JSONArray jsonBookList = null;

    public JsnParser() {
    
    }

    /**
     * Constructor to pass in the json filename.
     *
     * @param filename
     */
    public JsnParser(String filename) {
        this.filename = filename;
    }

    public void parseJson() {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("./src/resources/bangor-library.json"));

            String name = (String) jsonObj.get("name");
            libraryName = name;
            
            JSONArray extractedBooks = (JSONArray) jsonObj.get("books");

            System.out.println("Library: " + name);
            Iterator i = extractedBooks.iterator();
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("title " + innerObj.get("name")
                        + " author " + innerObj.get("author") + " category "
                        + innerObj.get("category"));
            }
            this.jsonBookList = extractedBooks;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsnParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsnParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JsnParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLibraryName() {
        return libraryName;
    }

    public JSONArray getJsonBookList() {
        return jsonBookList;
    }
}
