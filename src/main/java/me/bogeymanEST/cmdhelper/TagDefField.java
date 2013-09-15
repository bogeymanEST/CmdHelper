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

import me.bogeymanEST.cmdhelper.output.Output;
import me.bogeymanEST.cmdhelper.tagdef.TagDef;

import java.lang.reflect.Field;

/**
 * Used in displaying a field value in a JTree.
 * <p/>
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 13:38
 */
public class TagDefField {
    private TagDef tag;
    private Field field;

    public TagDefField(TagDef tag, Field field) {
        this.tag = tag;
        this.field = field;
    }

    @Override
    public String toString() {
        Output o = new Output(false);
        try {
            return field.getName() + " = " + o.get(field.get(tag));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
