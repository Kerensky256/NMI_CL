/**
 * @(#)JsnParser.java
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
 * A class to parse JSON documents into LibraryRecord.java beans.
 * Required the simple json library `json-simple-1.1.1.jar`.
 * @author Darren Roberts
 */
public class JsnParser {

    private String filename = null;
    private String libraryName = null;
    private JSONArray jsonBookList = null;
    private LibraryRecord rec;
    private boolean duplicate;

    public JsnParser() {

    }

    /**
     * Constructor to pass in the JSON filename, not yet implemented, filename hard coded.
     * @param filename the .json file to be parsed. 
     */
    public JsnParser(String filename) {
        this.filename = filename;
    }

    /**
     * Method to construct the json object and json array form the source file.
     * The extracted elements are stored to `LibraryRecord.java` objects.<br> 
     * Duplicate `LibraryRecord` removed before adding to the array using hash of content.
     */
    public void parseJson() {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("./src/resources/bangor-library.json"));
            String name = (String) jsonObj.get("name");
            libraryName = name;
            JSONArray extractedBooks = (JSONArray) jsonObj.get("books");

            Iterator i = extractedBooks.iterator();
            while (i.hasNext()) {
                rec = new LibraryRecord();
                rec.setLib_name(libraryName);
                JSONObject innerObj = (JSONObject) i.next();
                rec.setBook_name(innerObj.get("name").toString());
                rec.setAuth_name(innerObj.get("author").toString());
                rec.setCat_name(innerObj.get("category").toString());

                if (!LibraryAccess.bookShelves.isEmpty()) {
                    for (LibraryRecord bookSaved : LibraryAccess.bookShelves) {
                        if (this.rec.getHashOfContent() == bookSaved.getHashOfContent()) {
                            duplicate = true;
                            rec = null;
                        }
                    }
                    if (!duplicate) {
                        LibraryAccess.addRecord(rec);
                    }
                    duplicate = false;

                } else {
                    System.out.println("Library empty : Adding records...");
                    LibraryAccess.addRecord(this.rec);
                }
            }

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
