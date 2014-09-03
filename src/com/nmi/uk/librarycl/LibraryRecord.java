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

/**
 * @class LibraryRecord
 * @author Darren
 * Simple Data object - store details on one book.
 */
public class LibraryRecord implements Serializable{
    
    static String lib_name;
    static String book_name;
    static String auth_name;
    static String cat_name;
    
    static enum attributes {
        lib_name, book_name, auth_name, cat_name
    };

    public LibraryRecord() {
    }

    public String getLib_name() {
        return lib_name;
    }

    public void setLib_name(String lib_name) {
        LibraryRecord.lib_name = lib_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        LibraryRecord.book_name = book_name;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        LibraryRecord.auth_name = auth_name;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        LibraryRecord.cat_name = cat_name;
    } 
}
