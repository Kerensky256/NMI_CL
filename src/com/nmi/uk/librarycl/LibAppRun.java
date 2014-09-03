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

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

/**
 *
 * @author Darren
 * @version %I%, %G%
 */
public class LibAppRun {

    public static void main(String[] args) {

        System.out.println("Loading app..");
        String option = null;

        XmlParser newxp = new XmlParser("test");
        newxp.parseXml();
        JsonParser newjp = new JsonParser("test");
        newjp.parseJson();

        MainMenu.Run();
        // Load Files
        // call the loader method fo the parser classes in a seperate UI

        Console userInput = System.console();

        while ("Q".equals(option)) {

        }
        // Main Menu Loop

    }

}
