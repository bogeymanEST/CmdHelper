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

package me.bogeymanEST.cmdhelper.datatags;

import java.util.Set;
import java.util.TreeSet;

/**
 * User: Bogeyman
 * Date: 13.09.13
 * Time: 10:25
 */
public class DataTagManager {
    private static Set<DataTag> tags = new TreeSet<DataTag>();

    public static Set<DataTag> getTags() {
        return tags;
    }

    public static void addTag(DataTag tag) {
        tags.add(tag);
    }

    public static DataTag getTag(String name) {
        for (DataTag tag : tags) {
            if (tag.toString().equals(name)) return tag;
        }
        return null;
    }
}
