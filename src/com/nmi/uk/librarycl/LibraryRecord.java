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
 * LibraryRecord is as Simple Data object to store details on one book.
 *
 * @author Darren
 *
 */
public class LibraryRecord implements Serializable {

    String lib_name;
    String book_name;
    String auth_name;
    String cat_name;
    int hashCode;

    public LibraryRecord() {

    }

    public String getLib_name() {
        return lib_name;
    }

    /**
     *
     * @param lib_name
     */
    public void setLib_name(String lib_name) {
        this.lib_name = lib_name;
    }

    public String getBook_name() {
        return book_name;
    }

    /**
     *
     * @param book_name
     */
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuth_name() {
        return auth_name;
    }

    /**
     *
     * @param auth_name
     */
    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getCat_name() {
        return cat_name;
    }

    /**
     *
     * @param cat_name
     */
    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
    
    public int getHashOfContent(){
        int hashCode = (cat_name+lib_name+auth_name+book_name).hashCode();
        this.hashCode = hashCode;
        return this.hashCode;
    }
}
