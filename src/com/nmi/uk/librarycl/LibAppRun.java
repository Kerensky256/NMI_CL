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

/**
 *
 * @author Darren
 * @version %I%, %G%
 */
public class LibAppRun {

    public static void main(String[] args) {

        LibraryAccess admin = new LibraryAccess();
        LibraryRecord rec = new LibraryRecord();
        rec.setBook_name("Alien");
        rec.setAuth_name("Darren");
        rec.setCat_name("Sci-fi");
        rec.setLib_name("Bangor");
        admin.addRecord(rec);
        admin.printResult("Darren");

        System.out.println("Loading app..");
        //FIXME:  Test the classes remove in final
        XmlParser newxp = new XmlParser();
        newxp.parseXml();
        JsnParser newjp = new JsnParser();
        newjp.parseJson();

        MainMenu.Run();
    }
}
