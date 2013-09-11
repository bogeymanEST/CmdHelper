/*
 * CmdHelper
 * Copyright (C) 2013 bogeymanEST
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package me.bogeymanEST.cmdhelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: Bogeyman
 * Date: 9.09.13
 * Time: 18:15
 */
public class Items {
    private static Items instance;
    private Map<String, String> items = new LinkedHashMap<String, String>();

    public Items(InputStream stream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] sp = line.trim().split("\t\t");
                items.put(sp[0], sp[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance = this;
    }

    public String getItemName(String id) {
        return items.get(id);
    }

    public Map<String, String> getItems() {
        return items;
    }

    public static Items getInstance() {
        if (instance == null) {
            instance = new Items(Resource.getStream("items.txt"));
        }
        return instance;
    }
}